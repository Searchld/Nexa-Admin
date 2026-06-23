package com.ruoyi.web.controller.system.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.agent.SysAgentApp;
import com.ruoyi.system.service.agent.ISysAgentService;
import com.ruoyi.web.service.agent.SpringAiAgentRuntimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AI Agent 应用")
@RestController
@RequestMapping("/system/agent/app")
public class SysAgentAppController extends BaseController
{
    @Autowired
    private ISysAgentService agentService;

    @Autowired
    private SpringAiAgentRuntimeService runtimeService;

    @PreAuthorize("@ss.hasPermi('system:agent:app:list')")
    @Operation(summary = "查询 Agent 应用列表")
    @GetMapping("/list")
    public TableDataInfo list(SysAgentApp app)
    {
        startPage();
        return getDataTable(agentService.selectAppList(app));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:app:query')")
    @Operation(summary = "获取 Agent 应用详情")
    @GetMapping("/{appId}")
    public AjaxResult getInfo(@PathVariable Long appId)
    {
        return success(agentService.selectAppById(appId));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:app:add')")
    @Log(title = "Agent应用", businessType = BusinessType.INSERT)
    @Operation(summary = "新增 Agent 应用")
    @PostMapping
    public AjaxResult add(@RequestBody SysAgentApp app)
    {
        app.setCreateBy(getUsername());
        return toAjax(agentService.insertApp(app));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:app:edit')")
    @Log(title = "Agent应用", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改 Agent 应用")
    @PutMapping
    public AjaxResult edit(@RequestBody SysAgentApp app)
    {
        app.setUpdateBy(getUsername());
        return toAjax(agentService.updateApp(app));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:app:remove')")
    @Log(title = "Agent应用", businessType = BusinessType.DELETE)
    @Operation(summary = "删除 Agent 应用")
    @DeleteMapping("/{appIds}")
    public AjaxResult remove(@PathVariable Long[] appIds)
    {
        return toAjax(agentService.deleteAppsByIds(appIds));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:app:test')")
    @Log(title = "Agent应用连接测试", businessType = BusinessType.OTHER, isSaveResponseData = false)
    @Operation(summary = "测试 Agent 应用模型连接")
    @PostMapping("/{appId}/test")
    public AjaxResult test(@PathVariable Long appId)
    {
        runtimeService.test(agentService.selectAppSecretById(appId));
        return success("连接成功");
    }
}
