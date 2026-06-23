package com.ruoyi.web.service.agent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.agent.SysAgentApp;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeChunk;
import com.ruoyi.system.domain.agent.SysAgentMessage;

@Service
public class SpringAiAgentRuntimeService
{
    public String complete(SysAgentApp app, List<SysAgentMessage> recentMessages, String ragContext, String userContent)
    {
        StringBuilder answer = new StringBuilder();
        stream(app, recentMessages, ragContext, userContent, answer::append);
        return answer.toString();
    }

    public void stream(SysAgentApp app, List<SysAgentMessage> recentMessages, String ragContext, String userContent, Consumer<String> onChunk)
    {
        AtomicBoolean emitted = new AtomicBoolean(false);
        try
        {
            ChatClient.ChatClientRequestSpec spec = chatClient(app).prompt()
                .system(systemPrompt(app, ragContext))
                .user(renderUserPrompt(recentMessages, userContent));
            spec.stream().content().toStream().forEach(content -> {
                if (StringUtils.isNotEmpty(content))
                {
                    emitted.set(true);
                    onChunk.accept(content);
                }
            });
        }
        catch (Exception e)
        {
            if (!emitted.get())
            {
                streamWithHttpFallback(app, recentMessages, ragContext, userContent, onChunk);
            }
        }
    }

    public String completeOnce(SysAgentApp app, List<SysAgentMessage> recentMessages, String ragContext, String userContent)
    {
        try
        {
            String content = chatClient(app).prompt()
                .system(systemPrompt(app, ragContext))
                .user(renderUserPrompt(recentMessages, userContent))
                .call()
                .content();
            if (StringUtils.isNotEmpty(content))
            {
                return content;
            }
        }
        catch (Exception ignored)
        {
        }
        return completeWithHttpFallback(app, recentMessages, ragContext, userContent);
    }

    public List<String> selectToolNames(SysAgentApp app, String toolCatalogJson, String userContent)
    {
        if (app == null || StringUtils.isEmpty(toolCatalogJson))
        {
            return List.of();
        }
        String prompt = "你是系统 Agent 的工具选择器。只能从工具目录中选择工具，不要回答用户问题。\n"
            + "工具目录 JSON：\n" + toolCatalogJson + "\n\n"
            + "用户问题：\n" + userContent + "\n\n"
            + "请只输出 JSON，格式为 {\"tools\":[\"tool_name\"]}。"
            + "如果用户要求新增、修改、删除、授权、重置、清理、导出等写操作，必须包含 write_action_guard。"
            + "如果用户问你能做什么或接入了哪些接口，包含 system_api_catalog。最多选择 5 个工具。";
        try
        {
            String content = completeWithHttpFallback(app, List.of(), null, prompt);
            JSONObject json = extractJsonObject(content);
            JSONArray tools = json == null ? null : json.getJSONArray("tools");
            if (tools == null || tools.isEmpty())
            {
                return List.of();
            }
            List<String> names = new ArrayList<>();
            for (int i = 0; i < tools.size(); i++)
            {
                String name = tools.getString(i);
                if (StringUtils.isNotEmpty(name) && !names.contains(name))
                {
                    names.add(name);
                }
            }
            return names;
        }
        catch (Exception e)
        {
            return List.of();
        }
    }

    private void streamWithHttpFallback(SysAgentApp app, List<SysAgentMessage> recentMessages, String ragContext, String userContent, Consumer<String> onChunk)
    {
        try
        {
            JSONObject body = createCompletionBody(app, recentMessages, ragContext, userContent, true);
            HttpResponse<java.io.InputStream> response = client().send(request(app, body), HttpResponse.BodyHandlers.ofInputStream());
            if (response.statusCode() < 200 || response.statusCode() >= 300)
            {
                String error = new String(response.body().readAllBytes(), StandardCharsets.UTF_8);
                throw new ServiceException("上游模型服务异常：HTTP " + response.statusCode() + " - " + error);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body(), StandardCharsets.UTF_8)))
            {
                String line;
                boolean emitted = false;
                while ((line = reader.readLine()) != null)
                {
                    if (!line.startsWith("data:")) continue;
                    String data = line.substring(5).trim();
                    if ("[DONE]".equals(data)) break;
                    JSONObject chunk = JSONObject.parseObject(data);
                    JSONArray choices = chunk.getJSONArray("choices");
                    if (choices == null || choices.isEmpty()) continue;
                    JSONObject delta = choices.getJSONObject(0).getJSONObject("delta");
                    String content = delta == null ? null : delta.getString("content");
                    if (StringUtils.isNotEmpty(content))
                    {
                        emitted = true;
                        onChunk.accept(content);
                    }
                }
                if (!emitted)
                {
                    throw new ServiceException("模型流式接口未返回有效内容");
                }
            }
        }
        catch (ServiceException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new ServiceException("模型调用失败：" + e.getMessage());
        }
    }

    private String completeWithHttpFallback(SysAgentApp app, List<SysAgentMessage> recentMessages, String ragContext, String userContent)
    {
        try
        {
            JSONObject body = createCompletionBody(app, recentMessages, ragContext, userContent, false);
            HttpResponse<String> response = client().send(request(app, body), HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            if (response.statusCode() < 200 || response.statusCode() >= 300)
            {
                throw new ServiceException("上游模型服务异常：HTTP " + response.statusCode() + " - " + response.body());
            }
            JSONObject json = JSONObject.parseObject(response.body());
            JSONArray choices = json.getJSONArray("choices");
            if (choices == null || choices.isEmpty())
            {
                return "";
            }
            JSONObject message = choices.getJSONObject(0).getJSONObject("message");
            return message == null ? "" : StringUtils.defaultString(message.getString("content"));
        }
        catch (ServiceException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new ServiceException("模型非流式调用失败：" + e.getMessage());
        }
    }

    public void test(SysAgentApp app)
    {
        try
        {
            chatClient(app).prompt().user("ping").call().content();
        }
        catch (Exception e)
        {
            testWithHttpFallback(app);
        }
    }

    public String renderRagContext(List<SysAgentKnowledgeChunk> chunks)
    {
        if (chunks == null || chunks.isEmpty()) return "";
        StringBuilder context = new StringBuilder("以下是可引用的知识库片段，请仅在相关时使用：\n");
        for (int i = 0; i < chunks.size(); i++)
        {
            SysAgentKnowledgeChunk chunk = chunks.get(i);
            context.append("\n[引用").append(i + 1).append("] ")
                .append(StringUtils.defaultString(chunk.getFileName(), "知识文档"))
                .append("\n").append(chunk.getChunkText()).append("\n");
        }
        return context.toString();
    }

    private JSONObject createCompletionBody(SysAgentApp app, List<SysAgentMessage> recentMessages, String ragContext, String userContent, boolean stream)
    {
        JSONObject body = new JSONObject();
        body.put("model", app.getModelCode());
        body.put("stream", stream);
        if (app.getTemperature() != null) body.put("temperature", app.getTemperature());
        if (app.getMaxTokens() != null) body.put("max_tokens", app.getMaxTokens());
        JSONArray messages = new JSONArray();
        if (StringUtils.isNotEmpty(app.getSystemPrompt()))
        {
            messages.add(JSONObject.of("role", "system", "content", app.getSystemPrompt()));
        }
        if (StringUtils.isNotEmpty(ragContext))
        {
            messages.add(JSONObject.of("role", "system", "content", ragContext));
        }
        for (SysAgentMessage message : recentMessages)
        {
            if ("user".equals(message.getRole()) || "assistant".equals(message.getRole()) || "system".equals(message.getRole()))
            {
                messages.add(JSONObject.of("role", message.getRole(), "content", message.getContent()));
            }
        }
        messages.add(JSONObject.of("role", "user", "content", userContent));
        body.put("messages", messages);
        return body;
    }

    private ChatClient chatClient(SysAgentApp app)
    {
        OpenAiChatOptions.Builder options = OpenAiChatOptions.builder()
            .baseUrl(endpoint(app.getBaseUrl()).replaceAll("/chat/completions$", ""))
            .apiKey(app.getApiKey())
            .model(app.getModelCode())
            .maxTokens(app.getMaxTokens())
            .timeout(Duration.ofMinutes(5));
        if (app.getTemperature() != null)
        {
            options.temperature(app.getTemperature().doubleValue());
        }
        OpenAiChatModel model = OpenAiChatModel.builder().options(options.build()).build();
        return ChatClient.create(model);
    }

    private String systemPrompt(SysAgentApp app, String ragContext)
    {
        StringBuilder prompt = new StringBuilder();
        if (StringUtils.isNotEmpty(app.getSystemPrompt())) prompt.append(app.getSystemPrompt()).append("\n");
        if (StringUtils.isNotEmpty(ragContext)) prompt.append(ragContext);
        return prompt.toString();
    }

    private String renderUserPrompt(List<SysAgentMessage> recentMessages, String userContent)
    {
        if (recentMessages == null || recentMessages.isEmpty()) return userContent;
        StringBuilder prompt = new StringBuilder("最近对话：\n");
        for (SysAgentMessage message : recentMessages)
        {
            if ("user".equals(message.getRole()) || "assistant".equals(message.getRole()))
            {
                prompt.append(message.getRole()).append(": ").append(message.getContent()).append("\n");
            }
        }
        prompt.append("\n当前用户问题：").append(userContent);
        return prompt.toString();
    }

    private void testWithHttpFallback(SysAgentApp app)
    {
        try
        {
            JSONObject body = createCompletionBody(app, List.of(), null, "ping", false);
            HttpResponse<String> response = client().send(request(app, body), HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() < 200 || response.statusCode() >= 300)
            {
                throw new ServiceException("连接失败：HTTP " + response.statusCode() + " - " + response.body());
            }
        }
        catch (ServiceException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new ServiceException("连接失败：" + e.getMessage());
        }
    }

    private HttpClient client()
    {
        return HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
    }

    private JSONObject extractJsonObject(String content)
    {
        if (StringUtils.isEmpty(content))
        {
            return null;
        }
        String text = content.trim();
        int start = text.indexOf('{');
        int end = text.lastIndexOf('}');
        if (start < 0 || end <= start)
        {
            return null;
        }
        return JSONObject.parseObject(text.substring(start, end + 1));
    }

    private HttpRequest request(SysAgentApp app, JSONObject body)
    {
        return HttpRequest.newBuilder(URI.create(endpoint(app.getBaseUrl())))
            .timeout(Duration.ofMinutes(5))
            .header("Authorization", "Bearer " + app.getApiKey())
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(body.toJSONString()))
            .build();
    }

    private String endpoint(String baseUrl)
    {
        String normalized = StringUtils.defaultString(baseUrl).replaceAll("/+$", "");
        return normalized.endsWith("/chat/completions") ? normalized : normalized + "/chat/completions";
    }
}
