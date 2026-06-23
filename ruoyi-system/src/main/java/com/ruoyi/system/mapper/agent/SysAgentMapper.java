package com.ruoyi.system.mapper.agent;

import java.util.List;
import org.apache.ibatis.annotations.Param;
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

public interface SysAgentMapper
{
    List<SysAgentApp> selectAppList(SysAgentApp app);
    List<SysAgentApp> selectEnabledApps();
    SysAgentApp selectAppById(Long appId);
    int insertApp(SysAgentApp app);
    int updateApp(SysAgentApp app);
    int clearDefaultApp(@Param("excludeAppId") Long excludeAppId);
    int deleteAppsByIds(Long[] appIds);

    List<SysAgentSession> selectSessionList(@Param("userId") Long userId, @Param("appId") Long appId);
    SysAgentSession selectSession(@Param("sessionId") Long sessionId, @Param("userId") Long userId);
    int insertSession(SysAgentSession session);
    int deleteSession(@Param("sessionId") Long sessionId, @Param("userId") Long userId);
    int deleteMessagesBySessionId(Long sessionId);
    int updateSessionTitle(@Param("sessionId") Long sessionId, @Param("title") String title);
    int touchSession(Long sessionId);
    List<SysAgentMessage> selectMessageList(@Param("sessionId") Long sessionId);
    List<SysAgentMessage> selectRecentMessages(@Param("sessionId") Long sessionId, @Param("limit") int limit);
    int insertMessage(SysAgentMessage message);

    List<SysAgentKnowledgeBase> selectKbList(SysAgentKnowledgeBase kb);
    List<SysAgentKnowledgeBase> selectEnabledKbList();
    SysAgentKnowledgeBase selectKbById(Long kbId);
    int insertKb(SysAgentKnowledgeBase kb);
    int updateKb(SysAgentKnowledgeBase kb);
    int deleteKbsByIds(Long[] kbIds);
    List<SysAgentKnowledgeDoc> selectDocList(@Param("kbId") Long kbId);
    SysAgentKnowledgeDoc selectDocById(Long docId);
    int insertDoc(SysAgentKnowledgeDoc doc);
    int updateDoc(SysAgentKnowledgeDoc doc);
    int deleteDocsByIds(Long[] docIds);
    int deleteChunksByDocId(Long docId);
    int insertChunk(SysAgentKnowledgeChunk chunk);
    List<SysAgentKnowledgeChunk> selectChunksByDocId(Long docId);
    List<SysAgentKnowledgeChunk> searchChunks(@Param("kbIds") List<Long> kbIds, @Param("query") String query, @Param("limit") int limit);

    List<SysAgentWorkflow> selectWorkflowList(SysAgentWorkflow workflow);
    SysAgentWorkflow selectWorkflowById(Long workflowId);
    int insertWorkflow(SysAgentWorkflow workflow);
    int updateWorkflow(SysAgentWorkflow workflow);
    int deleteWorkflowsByIds(Long[] workflowIds);
    int insertWorkflowRun(SysAgentWorkflowRun run);
    int updateWorkflowRun(SysAgentWorkflowRun run);
    SysAgentWorkflowRun selectWorkflowRunById(Long runId);
    List<SysAgentWorkflowRun> selectWorkflowRunList(SysAgentWorkflowRun run);

    int insertToolCall(SysAgentToolCall toolCall);
    List<SysAgentToolCall> selectToolCallList(SysAgentToolCall toolCall);

    int insertActionDraft(SysAgentActionDraft draft);
    SysAgentActionDraft selectActionDraftById(@Param("draftId") Long draftId, @Param("userId") Long userId);
    List<SysAgentActionDraft> selectPendingActionDrafts(@Param("sessionId") Long sessionId, @Param("userId") Long userId);
    int updateActionDraft(SysAgentActionDraft draft);
}
