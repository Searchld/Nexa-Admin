package com.ruoyi.system.service.agent.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.ooxml.extractor.ExtractorFactory;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.agent.SysAgentActionDraft;
import com.ruoyi.system.domain.agent.SysAgentApp;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeBase;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeChunk;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeDoc;
import com.ruoyi.system.domain.agent.SysAgentMessage;
import com.ruoyi.system.domain.agent.SysAgentSession;
import com.ruoyi.system.domain.agent.SysAgentToolCall;
import com.ruoyi.system.domain.agent.SysAgentWorkflow;
import com.ruoyi.system.domain.agent.SysAgentWorkflowRun;
import com.ruoyi.system.domain.agent.dto.AgentRagSearchRequest;
import com.ruoyi.system.mapper.agent.SysAgentMapper;
import com.ruoyi.system.service.agent.ISysAgentService;

@Service
public class SysAgentServiceImpl implements ISysAgentService
{
    private static final String MASKED_KEY = "********";

    @Autowired
    private SysAgentMapper mapper;

    @Override
    public List<SysAgentApp> selectAppList(SysAgentApp app)
    {
        List<SysAgentApp> apps = mapper.selectAppList(app);
        apps.forEach(this::maskSecrets);
        return apps;
    }

    @Override
    public List<SysAgentApp> selectEnabledApps()
    {
        List<SysAgentApp> apps = mapper.selectEnabledApps();
        apps.forEach(this::maskSecrets);
        return apps;
    }

    @Override
    public SysAgentApp selectAppById(Long appId)
    {
        SysAgentApp app = mapper.selectAppById(appId);
        maskSecrets(app);
        return app;
    }

    @Override
    public SysAgentApp selectAppSecretById(Long appId)
    {
        return requiredApp(appId);
    }

    @Override
    @Transactional
    public int insertApp(SysAgentApp app)
    {
        normalizeApp(app);
        if ("1".equals(app.getIsDefault()))
        {
            mapper.clearDefaultApp(null);
        }
        return mapper.insertApp(app);
    }

    @Override
    @Transactional
    public int updateApp(SysAgentApp app)
    {
        requiredApp(app.getAppId());
        normalizeApp(app);
        if (MASKED_KEY.equals(app.getApiKey())) app.setApiKey(null);
        if (MASKED_KEY.equals(app.getEmbeddingApiKey())) app.setEmbeddingApiKey(null);
        if ("1".equals(app.getIsDefault()))
        {
            mapper.clearDefaultApp(app.getAppId());
        }
        return mapper.updateApp(app);
    }

    @Override
    public int deleteAppsByIds(Long[] appIds)
    {
        return mapper.deleteAppsByIds(appIds);
    }

    @Override
    public List<SysAgentSession> selectSessionList(Long userId, Long appId)
    {
        return mapper.selectSessionList(userId, appId);
    }

    @Override
    public SysAgentSession createSession(Long userId, Long appId, String module)
    {
        SysAgentApp app = requiredEnabledApp(appId);
        SysAgentSession session = new SysAgentSession();
        session.setUserId(userId);
        session.setAppId(app.getAppId());
        session.setTitle("新会话");
        session.setModule(StringUtils.defaultIfEmpty(module, "agent"));
        mapper.insertSession(session);
        session.setAppName(app.getAppName());
        session.setModelCode(app.getModelCode());
        return session;
    }

    @Override
    public SysAgentSession selectSession(Long sessionId, Long userId)
    {
        SysAgentSession session = mapper.selectSession(sessionId, userId);
        if (session == null)
        {
            throw new ServiceException("会话不存在或无权访问");
        }
        return session;
    }

    @Override
    @Transactional
    public void deleteSession(Long sessionId, Long userId)
    {
        selectSession(sessionId, userId);
        mapper.deleteMessagesBySessionId(sessionId);
        mapper.deleteSession(sessionId, userId);
    }

    @Override
    public List<SysAgentMessage> selectMessageList(Long sessionId, Long userId)
    {
        selectSession(sessionId, userId);
        return mapper.selectMessageList(sessionId);
    }

    @Override
    public List<SysAgentMessage> selectRecentMessages(Long sessionId, int limit)
    {
        return mapper.selectRecentMessages(sessionId, limit);
    }

    @Override
    public void insertMessage(Long sessionId, String role, String content, String referencesJson, Long elapsedMs)
    {
        SysAgentMessage message = new SysAgentMessage();
        message.setSessionId(sessionId);
        message.setRole(role);
        message.setContent(content);
        message.setReferencesJson(referencesJson);
        message.setElapsedMs(elapsedMs);
        mapper.insertMessage(message);
        mapper.touchSession(sessionId);
    }

    @Override
    public void titleSession(Long sessionId, String content)
    {
        String title = content == null ? "新会话" : content.trim().replaceAll("\\s+", " ");
        mapper.updateSessionTitle(sessionId, title.length() > 30 ? title.substring(0, 30) : title);
    }

    @Override
    public List<SysAgentKnowledgeBase> selectKbList(SysAgentKnowledgeBase kb)
    {
        return mapper.selectKbList(kb);
    }

    @Override
    public List<SysAgentKnowledgeBase> selectEnabledKbList()
    {
        return mapper.selectEnabledKbList();
    }

    @Override
    public SysAgentKnowledgeBase selectKbById(Long kbId)
    {
        SysAgentKnowledgeBase kb = mapper.selectKbById(kbId);
        if (kb == null)
        {
            throw new ServiceException("知识库不存在");
        }
        return kb;
    }

    @Override
    public int insertKb(SysAgentKnowledgeBase kb)
    {
        if (StringUtils.isEmpty(kb.getVisibility())) kb.setVisibility("private");
        if (StringUtils.isEmpty(kb.getStatus())) kb.setStatus("0");
        return mapper.insertKb(kb);
    }

    @Override
    public int updateKb(SysAgentKnowledgeBase kb)
    {
        selectKbById(kb.getKbId());
        return mapper.updateKb(kb);
    }

    @Override
    public int deleteKbsByIds(Long[] kbIds)
    {
        return mapper.deleteKbsByIds(kbIds);
    }

    @Override
    public List<SysAgentKnowledgeDoc> selectDocList(Long kbId)
    {
        return mapper.selectDocList(kbId);
    }

    @Override
    @Transactional
    public SysAgentKnowledgeDoc saveDocument(Long kbId, File file, String fileName, Long fileSize, String username)
    {
        selectKbById(kbId);
        SysAgentKnowledgeDoc doc = new SysAgentKnowledgeDoc();
        doc.setKbId(kbId);
        doc.setFileName(fileName);
        doc.setFileType(extension(fileName));
        doc.setFilePath(file.getAbsolutePath());
        doc.setFileSize(fileSize);
        doc.setParseStatus("parsing");
        doc.setChunkCount(0);
        doc.setCreateBy(username);
        mapper.insertDoc(doc);
        return indexDocument(doc.getDocId(), username);
    }

    @Override
    @Transactional
    public SysAgentKnowledgeDoc reindexDocument(Long docId, String username)
    {
        return indexDocument(docId, username);
    }

    @Override
    public int deleteDocsByIds(Long[] docIds)
    {
        return mapper.deleteDocsByIds(docIds);
    }

    @Override
    public List<SysAgentKnowledgeChunk> selectChunksByDocId(Long docId)
    {
        return mapper.selectChunksByDocId(docId);
    }

    @Override
    public List<SysAgentKnowledgeChunk> searchChunks(AgentRagSearchRequest request)
    {
        int limit = request.getTopK() == null || request.getTopK() <= 0 ? 5 : request.getTopK();
        List<Long> kbIds = new ArrayList<>();
        if (request.getKbIds() != null) kbIds.addAll(request.getKbIds());
        if (request.getKbId() != null && !kbIds.contains(request.getKbId())) kbIds.add(request.getKbId());
        return mapper.searchChunks(kbIds, request.getQuery(), limit);
    }

    @Override
    public List<SysAgentWorkflow> selectWorkflowList(SysAgentWorkflow workflow)
    {
        return mapper.selectWorkflowList(workflow);
    }

    @Override
    public SysAgentWorkflow selectWorkflowById(Long workflowId)
    {
        SysAgentWorkflow workflow = mapper.selectWorkflowById(workflowId);
        if (workflow == null)
        {
            throw new ServiceException("工作流不存在");
        }
        return workflow;
    }

    @Override
    public int insertWorkflow(SysAgentWorkflow workflow)
    {
        if (workflow.getVersion() == null) workflow.setVersion(1);
        if (StringUtils.isEmpty(workflow.getStatus())) workflow.setStatus("0");
        return mapper.insertWorkflow(workflow);
    }

    @Override
    public int updateWorkflow(SysAgentWorkflow workflow)
    {
        selectWorkflowById(workflow.getWorkflowId());
        return mapper.updateWorkflow(workflow);
    }

    @Override
    public int deleteWorkflowsByIds(Long[] workflowIds)
    {
        return mapper.deleteWorkflowsByIds(workflowIds);
    }

    @Override
    public SysAgentWorkflowRun createWorkflowRun(Long workflowId, Long userId, String inputJson)
    {
        selectWorkflowById(workflowId);
        SysAgentWorkflowRun run = new SysAgentWorkflowRun();
        run.setWorkflowId(workflowId);
        run.setUserId(userId);
        run.setInputJson(inputJson);
        run.setStatus("running");
        mapper.insertWorkflowRun(run);
        return run;
    }

    @Override
    public SysAgentWorkflowRun updateWorkflowRun(SysAgentWorkflowRun run)
    {
        mapper.updateWorkflowRun(run);
        return mapper.selectWorkflowRunById(run.getRunId());
    }

    @Override
    public SysAgentWorkflowRun selectWorkflowRunById(Long runId)
    {
        return mapper.selectWorkflowRunById(runId);
    }

    @Override
    public List<SysAgentWorkflowRun> selectWorkflowRunList(SysAgentWorkflowRun run)
    {
        return mapper.selectWorkflowRunList(run);
    }

    @Override
    public void insertToolCall(SysAgentToolCall toolCall)
    {
        mapper.insertToolCall(toolCall);
    }

    @Override
    public List<SysAgentToolCall> selectToolCallList(SysAgentToolCall toolCall)
    {
        return mapper.selectToolCallList(toolCall);
    }

    @Override
    public void insertActionDraft(SysAgentActionDraft draft)
    {
        mapper.insertActionDraft(draft);
    }

    @Override
    public SysAgentActionDraft selectActionDraftById(Long draftId, Long userId)
    {
        return mapper.selectActionDraftById(draftId, userId);
    }

    @Override
    public List<SysAgentActionDraft> selectPendingActionDrafts(Long sessionId, Long userId)
    {
        return mapper.selectPendingActionDrafts(sessionId, userId);
    }

    @Override
    public SysAgentActionDraft updateActionDraft(SysAgentActionDraft draft)
    {
        mapper.updateActionDraft(draft);
        return mapper.selectActionDraftById(draft.getDraftId(), draft.getUserId());
    }

    private SysAgentKnowledgeDoc indexDocument(Long docId, String username)
    {
        SysAgentKnowledgeDoc doc = mapper.selectDocById(docId);
        if (doc == null)
        {
            throw new ServiceException("知识文档不存在");
        }
        mapper.deleteChunksByDocId(docId);
        try
        {
            String text = extractText(new File(doc.getFilePath()), doc.getFileType());
            List<String> chunks = splitText(text);
            int index = 1;
            for (String chunkText : chunks)
            {
                SysAgentKnowledgeChunk chunk = new SysAgentKnowledgeChunk();
                chunk.setKbId(doc.getKbId());
                chunk.setDocId(doc.getDocId());
                chunk.setChunkText(chunkText);
                chunk.setChunkSummary(chunkText.length() > 180 ? chunkText.substring(0, 180) : chunkText);
                chunk.setVectorId("nexa:agent:kb:" + doc.getDocId() + ":" + index);
                chunk.setSourceParagraph(index);
                chunk.setContentHash(sha256(chunkText));
                mapper.insertChunk(chunk);
                index++;
            }
            doc.setParseStatus("success");
            doc.setChunkCount(chunks.size());
            doc.setErrorMsg("");
        }
        catch (Exception e)
        {
            doc.setParseStatus("failed");
            doc.setErrorMsg(e.getMessage());
            doc.setChunkCount(0);
        }
        doc.setUpdateBy(username);
        mapper.updateDoc(doc);
        return mapper.selectDocById(docId);
    }

    private String extractText(File file, String fileType) throws Exception
    {
        String type = StringUtils.defaultString(fileType).toLowerCase();
        if ("txt".equals(type) || "md".equals(type))
        {
            return Files.readString(file.toPath(), StandardCharsets.UTF_8);
        }
        if ("docx".equals(type) || "xlsx".equals(type))
        {
            try (POITextExtractor extractor = ExtractorFactory.createExtractor(file))
            {
                return extractor.getText();
            }
        }
        if ("pdf".equals(type))
        {
            try (PDDocument document = Loader.loadPDF(file))
            {
                return new PDFTextStripper().getText(document);
            }
        }
        throw new IOException("不支持的文件类型：" + fileType);
    }

    private List<String> splitText(String text)
    {
        String normalized = StringUtils.defaultString(text).replace("\r\n", "\n").trim();
        if (normalized.isEmpty()) return List.of();
        List<String> chunks = new ArrayList<>();
        int size = 900;
        int overlap = 120;
        for (int start = 0; start < normalized.length(); start += size - overlap)
        {
            int end = Math.min(normalized.length(), start + size);
            chunks.add(normalized.substring(start, end));
            if (end == normalized.length()) break;
        }
        return chunks;
    }

    private SysAgentApp requiredApp(Long appId)
    {
        SysAgentApp app = mapper.selectAppById(appId);
        if (app == null)
        {
            throw new ServiceException("Agent 应用不存在");
        }
        return app;
    }

    private SysAgentApp requiredEnabledApp(Long appId)
    {
        SysAgentApp app = requiredApp(appId);
        if (!"0".equals(app.getStatus()))
        {
            throw new ServiceException("Agent 应用已停用");
        }
        return app;
    }

    private void normalizeApp(SysAgentApp app)
    {
        if (StringUtils.isEmpty(app.getAppType())) app.setAppType("chat");
        if (StringUtils.isEmpty(app.getStatus())) app.setStatus("0");
        if (StringUtils.isEmpty(app.getIsDefault())) app.setIsDefault("0");
        if (app.getTemperature() == null) app.setTemperature(BigDecimal.valueOf(0.7));
        if (app.getMaxTokens() == null) app.setMaxTokens(2048);
        if (StringUtils.isNotEmpty(app.getBaseUrl())) app.setBaseUrl(app.getBaseUrl().replaceAll("/+$", ""));
        if (StringUtils.isNotEmpty(app.getEmbeddingBaseUrl())) app.setEmbeddingBaseUrl(app.getEmbeddingBaseUrl().replaceAll("/+$", ""));
    }

    private void maskSecrets(SysAgentApp app)
    {
        if (app == null) return;
        if (StringUtils.isNotEmpty(app.getApiKey())) app.setApiKey(MASKED_KEY);
        if (StringUtils.isNotEmpty(app.getEmbeddingApiKey())) app.setEmbeddingApiKey(MASKED_KEY);
    }

    private String extension(String fileName)
    {
        int index = fileName == null ? -1 : fileName.lastIndexOf('.');
        return index < 0 ? "" : fileName.substring(index + 1).toLowerCase();
    }

    private String sha256(String text) throws Exception
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return HexFormat.of().formatHex(digest.digest(text.getBytes(StandardCharsets.UTF_8)));
    }
}
