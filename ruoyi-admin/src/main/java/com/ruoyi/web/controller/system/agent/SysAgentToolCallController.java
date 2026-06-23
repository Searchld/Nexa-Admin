package com.ruoyi.web.controller.system.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.agent.SysAgentToolCall;
import com.ruoyi.system.service.agent.ISysAgentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AI Agent 调用日志")
@RestController
@RequestMapping("/system/agent/tool-call")
public class SysAgentToolCallController extends BaseController
{
    @Autowired
    private ISysAgentService agentService;

    @PreAuthorize("@ss.hasPermi('system:agent:log:list')")
    @Operation(summary = "查询 Agent 工具调用日志")
    @GetMapping("/list")
    public TableDataInfo list(SysAgentToolCall toolCall)
    {
        startPage();
        return getDataTable(agentService.selectToolCallList(toolCall));
    }
}
