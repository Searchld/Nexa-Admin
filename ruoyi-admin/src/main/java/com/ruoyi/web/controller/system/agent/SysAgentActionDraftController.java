package com.ruoyi.web.controller.system.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.service.agent.AgentActionDraftService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AI Agent 动作确认")
@RestController
@RequestMapping("/system/agent/action-draft")
public class SysAgentActionDraftController extends BaseController
{
    @Autowired
    private AgentActionDraftService actionDraftService;

    @PreAuthorize("@ss.hasPermi('system:agent:action:confirm')")
    @Log(title = "Agent动作确认", businessType = BusinessType.OTHER)
    @Operation(summary = "确认执行 Agent 动作草稿")
    @PostMapping("/{draftId}/confirm")
    public AjaxResult confirm(@PathVariable Long draftId)
    {
        return success(actionDraftService.confirm(draftId, getUserId()));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:action:confirm')")
    @Log(title = "Agent动作取消", businessType = BusinessType.OTHER)
    @Operation(summary = "取消 Agent 动作草稿")
    @PostMapping("/{draftId}/cancel")
    public AjaxResult cancel(@PathVariable Long draftId)
    {
        return success(actionDraftService.cancel(draftId, getUserId()));
    }
}
