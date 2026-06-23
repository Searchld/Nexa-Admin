package com.ruoyi.web.controller.system.agent;

import java.util.List;
import java.util.concurrent.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.agent.SysAgentActionDraft;
import com.ruoyi.system.domain.agent.SysAgentApp;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeChunk;
import com.ruoyi.system.domain.agent.SysAgentMessage;
import com.ruoyi.system.domain.agent.SysAgentSession;
import com.ruoyi.system.domain.agent.dto.AgentChatRequest;
import com.ruoyi.system.domain.agent.dto.AgentRagSearchRequest;
import com.ruoyi.system.service.agent.ISysAgentService;
import com.ruoyi.web.service.agent.AgentToolRuntimeService;
import com.ruoyi.web.service.agent.SpringAiAgentRuntimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AI Agent 聊天")
@RestController
@RequestMapping("/system/agent/chat")
@PreAuthorize("@ss.hasPermi('system:agent:chat:use')")
public class SysAgentChatController extends BaseController
{
    @Autowired
    private ISysAgentService agentService;

    @Autowired
    private SpringAiAgentRuntimeService runtimeService;

    @Autowired
    private AgentToolRuntimeService toolRuntimeService;

    @Autowired
    @Qualifier("threadPoolTaskExecutor")
    private Executor executor;

    @Operation(summary = "查询可用 Agent 应用")
    @GetMapping("/apps")
    public AjaxResult apps()
    {
        return success(agentService.selectEnabledApps());
    }

    @Operation(summary = "查询当前用户 Agent 会话")
    @GetMapping("/sessions")
    public AjaxResult sessions(@RequestParam(required = false) Long appId)
    {
        return success(agentService.selectSessionList(getUserId(), appId));
    }

    @Operation(summary = "创建 Agent 会话")
    @PostMapping("/sessions")
    public AjaxResult createSession(@RequestBody AgentChatRequest request)
    {
        return success(agentService.createSession(getUserId(), request.getAppId(), "agent"));
    }

    @Operation(summary = "查询 Agent 会话消息")
    @GetMapping("/sessions/{sessionId}/messages")
    public AjaxResult messages(@PathVariable Long sessionId)
    {
        return success(agentService.selectMessageList(sessionId, getUserId()));
    }

    @Operation(summary = "删除 Agent 会话")
    @DeleteMapping("/sessions/{sessionId}")
    public AjaxResult deleteSession(@PathVariable Long sessionId)
    {
        agentService.deleteSession(sessionId, getUserId());
        return success();
    }

    @Operation(summary = "发送 Agent 消息并流式返回")
    @PostMapping(produces = "text/event-stream")
    public SseEmitter chat(@RequestBody AgentChatRequest request)
    {
        if (StringUtils.isEmpty(request.getContent()))
        {
            throw new ServiceException("消息不能为空");
        }
        Long userId = getUserId();
        SysAgentSession session = agentService.selectSession(request.getSessionId(), userId);
        SysAgentApp app = agentService.selectAppSecretById(session.getAppId());
        boolean firstMessage = agentService.selectRecentMessages(session.getSessionId(), 1).isEmpty();
        String content = request.getContent().trim();
        agentService.insertMessage(session.getSessionId(), "user", content, null, null);
        if (firstMessage)
        {
            agentService.titleSession(session.getSessionId(), content);
        }
        List<String> selectedToolNames = List.of();
        if ("agent".equals(app.getAppType()))
        {
            selectedToolNames = runtimeService.selectToolNames(app, toolRuntimeService.toolCatalogForPrompt(), content);
        }
        String toolContext = toolRuntimeService.buildToolContext(app, userId, session.getSessionId(), content, selectedToolNames);
        List<SysAgentActionDraft> actionDrafts = agentService.selectPendingActionDrafts(session.getSessionId(), userId);
        SseEmitter emitter = new SseEmitter(0L);
        List<String> finalSelectedToolNames = selectedToolNames;
        executor.execute(() -> stream(request, app, session.getSessionId(), content, toolContext, finalSelectedToolNames, actionDrafts, emitter));
        return emitter;
    }

    private void stream(AgentChatRequest request, SysAgentApp app, Long sessionId, String content, String toolContext, List<String> selectedToolNames, List<SysAgentActionDraft> actionDrafts, SseEmitter emitter)
    {
        long start = System.currentTimeMillis();
        StringBuilder answer = new StringBuilder();
        try
        {
            AgentRagSearchRequest ragRequest = new AgentRagSearchRequest();
            ragRequest.setKbId(request.getKbId());
            ragRequest.setKbIds(request.getKbIds());
            ragRequest.setQuery(content);
            ragRequest.setTopK(5);
            List<SysAgentKnowledgeChunk> chunks = agentService.searchChunks(ragRequest);
            String ragContext = runtimeService.renderRagContext(chunks);
            String context = StringUtils.isNotEmpty(toolContext) ? toolContext + "\n\n" + ragContext : ragContext;
            List<SysAgentMessage> recent = agentService.selectRecentMessages(sessionId, 20);
            if (selectedToolNames != null && !selectedToolNames.isEmpty())
            {
                emitter.send(SseEmitter.event().name("tool_calls").data(JSON.toJSONString(selectedToolNames)));
            }
            if (actionDrafts != null && !actionDrafts.isEmpty())
            {
                emitter.send(SseEmitter.event().name("action_drafts").data(JSON.toJSONString(actionDrafts)));
            }
            runtimeService.stream(app, recent, context, content, chunk -> {
                try
                {
                    answer.append(chunk);
                    emitter.send(SseEmitter.event().name("chunk").data(chunk));
                }
                catch (Exception e)
                {
                    throw new IllegalStateException(e);
                }
            });
            if (answer.isEmpty())
            {
                String fallback = runtimeService.completeOnce(app, recent, context, content);
                if (StringUtils.isEmpty(fallback) && StringUtils.isNotEmpty(toolContext))
                {
                    fallback = "已读取当前账号权限范围内的系统工具结果，但模型没有返回可用文本。以下是本次可用的 Agent 工具上下文：\n\n" + toolContext;
                }
                if (StringUtils.isNotEmpty(fallback))
                {
                    answer.append(fallback);
                    emitter.send(SseEmitter.event().name("chunk").data(fallback));
                }
            }
            if (answer.isEmpty())
            {
                throw new ServiceException("模型未返回有效内容，请检查模型编码、API Key 或上游模型服务状态");
            }
            agentService.insertMessage(sessionId, "assistant", answer.toString(), JSON.toJSONString(chunks), System.currentTimeMillis() - start);
            emitter.send(SseEmitter.event().name("references").data(JSON.toJSONString(chunks)));
            emitter.send(SseEmitter.event().name("done").data("ok"));
            emitter.complete();
        }
        catch (Exception e)
        {
            try
            {
                if (!answer.isEmpty())
                {
                    agentService.insertMessage(sessionId, "assistant", answer.toString(), null, System.currentTimeMillis() - start);
                    emitter.send(SseEmitter.event().name("done").data("ok"));
                }
                else
                {
                    emitter.send(SseEmitter.event().name("error").data(e.getMessage() == null ? "生成失败" : e.getMessage()));
                }
            }
            catch (Exception ignored)
            {
            }
            emitter.complete();
        }
    }
}
