package com.ruoyi.system.service.agent;

import java.io.File;
import java.util.List;
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

public interface ISysAgentService
{
    List<SysAgentApp> selectAppList(SysAgentApp app);
    List<SysAgentApp> selectEnabledApps();
    SysAgentApp selectAppById(Long appId);
    SysAgentApp selectAppSecretById(Long appId);
    int insertApp(SysAgentApp app);
    int updateApp(SysAgentApp app);
    int deleteAppsByIds(Long[] appIds);

    List<SysAgentSession> selectSessionList(Long userId, Long appId);
    SysAgentSession createSession(Long userId, Long appId, String module);
    SysAgentSession selectSession(Long sessionId, Long userId);
    void deleteSession(Long sessionId, Long userId);
    List<SysAgentMessage> selectMessageList(Long sessionId, Long userId);
    List<SysAgentMessage> selectRecentMessages(Long sessionId, int limit);
    void insertMessage(Long sessionId, String role, String content, String referencesJson, Long elapsedMs);
    void titleSession(Long sessionId, String content);

    List<SysAgentKnowledgeBase> selectKbList(SysAgentKnowledgeBase kb);
    List<SysAgentKnowledgeBase> selectEnabledKbList();
    SysAgentKnowledgeBase selectKbById(Long kbId);
    int insertKb(SysAgentKnowledgeBase kb);
    int updateKb(SysAgentKnowledgeBase kb);
    int deleteKbsByIds(Long[] kbIds);
    List<SysAgentKnowledgeDoc> selectDocList(Long kbId);
    SysAgentKnowledgeDoc saveDocument(Long kbId, File file, String fileName, Long fileSize, String username);
    SysAgentKnowledgeDoc reindexDocument(Long docId, String username);
    int deleteDocsByIds(Long[] docIds);
    List<SysAgentKnowledgeChunk> selectChunksByDocId(Long docId);
    List<SysAgentKnowledgeChunk> searchChunks(AgentRagSearchRequest request);

    List<SysAgentWorkflow> selectWorkflowList(SysAgentWorkflow workflow);
    SysAgentWorkflow selectWorkflowById(Long workflowId);
    int insertWorkflow(SysAgentWorkflow workflow);
    int updateWorkflow(SysAgentWorkflow workflow);
    int deleteWorkflowsByIds(Long[] workflowIds);
    SysAgentWorkflowRun createWorkflowRun(Long workflowId, Long userId, String inputJson);
    SysAgentWorkflowRun updateWorkflowRun(SysAgentWorkflowRun run);
    SysAgentWorkflowRun selectWorkflowRunById(Long runId);
    List<SysAgentWorkflowRun> selectWorkflowRunList(SysAgentWorkflowRun run);

    void insertToolCall(SysAgentToolCall toolCall);
    List<SysAgentToolCall> selectToolCallList(SysAgentToolCall toolCall);

    void insertActionDraft(SysAgentActionDraft draft);
    SysAgentActionDraft selectActionDraftById(Long draftId, Long userId);
    List<SysAgentActionDraft> selectPendingActionDrafts(Long sessionId, Long userId);
    SysAgentActionDraft updateActionDraft(SysAgentActionDraft draft);
}
