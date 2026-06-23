package com.ruoyi.web.controller.system.agent;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.agent.SysAgentApp;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeChunk;
import com.ruoyi.system.domain.agent.dto.AgentRagAskRequest;
import com.ruoyi.system.domain.agent.dto.AgentRagSearchRequest;
import com.ruoyi.system.service.agent.ISysAgentService;
import com.ruoyi.web.service.agent.SpringAiAgentRuntimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AI Agent RAG")
@RestController
@RequestMapping("/system/agent/rag")
public class SysAgentRagController extends BaseController
{
    @Autowired
    private ISysAgentService agentService;

    @Autowired
    private SpringAiAgentRuntimeService runtimeService;

    @PreAuthorize("@ss.hasPermi('system:agent:rag:search')")
    @Operation(summary = "检索知识库片段")
    @PostMapping("/search")
    public AjaxResult search(@RequestBody AgentRagSearchRequest request)
    {
        if (StringUtils.isEmpty(request.getQuery()))
        {
            throw new ServiceException("检索内容不能为空");
        }
        return success(agentService.searchChunks(request));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:rag:ask')")
    @Operation(summary = "基于知识库问答")
    @PostMapping("/ask")
    public AjaxResult ask(@RequestBody AgentRagAskRequest request)
    {
        if (StringUtils.isEmpty(request.getQuery()))
        {
            throw new ServiceException("问题不能为空");
        }
        SysAgentApp app = agentService.selectAppSecretById(request.getAppId());
        List<SysAgentKnowledgeChunk> chunks = agentService.searchChunks(request);
        String answer = runtimeService.complete(app, List.of(), runtimeService.renderRagContext(chunks), request.getQuery());
        return success(JSONObject.of("answer", answer, "references", chunks));
    }
}
