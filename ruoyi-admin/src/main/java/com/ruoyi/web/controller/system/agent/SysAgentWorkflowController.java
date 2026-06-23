package com.ruoyi.web.controller.system.agent;

import java.util.Date;
import java.util.List;
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
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.agent.SysAgentApp;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeChunk;
import com.ruoyi.system.domain.agent.SysAgentWorkflow;
import com.ruoyi.system.domain.agent.SysAgentWorkflowRun;
import com.ruoyi.system.domain.agent.dto.AgentRagSearchRequest;
import com.ruoyi.system.domain.agent.dto.AgentWorkflowRunRequest;
import com.ruoyi.system.service.agent.ISysAgentService;
import com.ruoyi.web.service.agent.AgentToolRuntimeService;
import com.ruoyi.web.service.agent.SpringAiAgentRuntimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AI Agent 工作流")
@RestController
@RequestMapping("/system/agent/workflow")
public class SysAgentWorkflowController extends BaseController
{
    @Autowired
    private ISysAgentService agentService;

    @Autowired
    private AgentToolRuntimeService toolRuntimeService;

    @Autowired
    private SpringAiAgentRuntimeService runtimeService;

    @PreAuthorize("@ss.hasPermi('system:agent:workflow:list')")
    @Operation(summary = "查询 Agent 工作流列表")
    @GetMapping("/list")
    public TableDataInfo list(SysAgentWorkflow workflow)
    {
        startPage();
        return getDataTable(agentService.selectWorkflowList(workflow));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:workflow:query')")
    @Operation(summary = "获取 Agent 工作流详情")
    @GetMapping("/{workflowId}")
    public AjaxResult getInfo(@PathVariable Long workflowId)
    {
        return success(agentService.selectWorkflowById(workflowId));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:workflow:add')")
    @Log(title = "Agent工作流", businessType = BusinessType.INSERT)
    @Operation(summary = "新增 Agent 工作流")
    @PostMapping
    public AjaxResult add(@RequestBody SysAgentWorkflow workflow)
    {
        workflow.setCreateBy(getUsername());
        return toAjax(agentService.insertWorkflow(workflow));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:workflow:edit')")
    @Log(title = "Agent工作流", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改 Agent 工作流")
    @PutMapping
    public AjaxResult edit(@RequestBody SysAgentWorkflow workflow)
    {
        workflow.setUpdateBy(getUsername());
        return toAjax(agentService.updateWorkflow(workflow));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:workflow:remove')")
    @Log(title = "Agent工作流", businessType = BusinessType.DELETE)
    @Operation(summary = "删除 Agent 工作流")
    @DeleteMapping("/{workflowIds}")
    public AjaxResult remove(@PathVariable Long[] workflowIds)
    {
        return toAjax(agentService.deleteWorkflowsByIds(workflowIds));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:workflow:run')")
    @Log(title = "Agent工作流运行", businessType = BusinessType.OTHER)
    @Operation(summary = "运行 Agent 工作流")
    @PostMapping("/{workflowId}/run")
    public AjaxResult run(@PathVariable Long workflowId, @RequestBody AgentWorkflowRunRequest request)
    {
        long start = System.currentTimeMillis();
        SysAgentWorkflowRun run = agentService.createWorkflowRun(workflowId, getUserId(), JSONObject.toJSONString(request));
        try
        {
            SysAgentWorkflow workflow = agentService.selectWorkflowById(workflowId);
            JSONObject output = executeWorkflow(workflow, run, request);
            run.setOutputJson(output.toJSONString());
            run.setStatus("success");
            run.setElapsedMs(System.currentTimeMillis() - start);
            run.setUpdateTime(new Date());
        }
        catch (Exception e)
        {
            run.setOutputJson(JSONObject.of("output", "", "steps", new JSONArray()).toJSONString());
            run.setStatus("failed");
            run.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 900));
            run.setElapsedMs(System.currentTimeMillis() - start);
            run.setUpdateTime(new Date());
        }
        return success(agentService.updateWorkflowRun(run));
    }

    private JSONObject executeWorkflow(SysAgentWorkflow workflow, SysAgentWorkflowRun run, AgentWorkflowRunRequest request)
    {
        JSONObject definition = JSONObject.parseObject(StringUtils.defaultString(workflow.getDefinitionJson(), "{}"));
        JSONArray nodes = definition.getJSONArray("nodes");
        JSONArray steps = new JSONArray();
        String input = StringUtils.defaultIfEmpty(request.getInput(), request.getInputJson());
        String current = StringUtils.defaultString(input);
        StringBuilder context = new StringBuilder();
        if (nodes == null || nodes.isEmpty())
        {
            return JSONObject.of("output", current, "steps", steps, "message", "工作流未配置节点");
        }
        for (int i = 0; i < nodes.size(); i++)
        {
            JSONObject node = nodes.getJSONObject(i);
            String id = node.getString("id");
            String type = node.getString("type");
            JSONObject config = node.getJSONObject("config");
            long nodeStart = System.currentTimeMillis();
            JSONObject step = JSONObject.of("node", id, "type", type, "status", "success");
            try
            {
                if ("input".equals(type))
                {
                    step.put("output", current);
                }
                else if ("tool".equals(type))
                {
                    String toolName = config == null ? null : config.getString("tool");
                    String result = toolRuntimeService.executeWorkflowTool(getUserId(), run.getRunId(), current, toolName);
                    context.append("\n[").append(id).append("]\n").append(result).append("\n");
                    current = result;
                    step.put("tool", toolName);
                    step.put("output", result);
                }
                else if ("rag".equals(type))
                {
                    AgentRagSearchRequest ragRequest = new AgentRagSearchRequest();
                    ragRequest.setQuery(current);
                    ragRequest.setTopK(config == null || config.getInteger("topK") == null ? 5 : config.getInteger("topK"));
                    List<SysAgentKnowledgeChunk> chunks = agentService.searchChunks(ragRequest);
                    String ragContext = runtimeService.renderRagContext(chunks);
                    context.append("\n[").append(id).append("]\n").append(ragContext).append("\n");
                    current = ragContext;
                    step.put("references", chunks);
                    step.put("output", ragContext);
                }
                else if ("prompt".equals(type))
                {
                    String template = config == null ? "" : StringUtils.defaultString(config.getString("template"));
                    SysAgentApp app = defaultApp();
                    String prompt = template + "\n\n工作流输入：\n" + input + "\n\n上下文：\n" + context;
                    current = app == null ? prompt : runtimeService.completeOnce(app, List.of(), context.toString(), prompt);
                    step.put("output", current);
                }
                else if ("condition".equals(type))
                {
                    step.put("output", "condition 节点已通过，表达式执行器后续扩展");
                }
                else if ("output".equals(type))
                {
                    step.put("output", current);
                }
                else
                {
                    step.put("status", "skipped");
                    step.put("output", "未知节点类型：" + type);
                }
            }
            catch (Exception e)
            {
                step.put("status", "failed");
                step.put("error", e.getMessage());
                steps.add(step);
                throw e;
            }
            finally
            {
                step.put("elapsedMs", System.currentTimeMillis() - nodeStart);
            }
            steps.add(step);
        }
        return JSONObject.of("output", current, "steps", steps);
    }

    private SysAgentApp defaultApp()
    {
        List<SysAgentApp> apps = agentService.selectEnabledApps();
        if (apps == null || apps.isEmpty())
        {
            return null;
        }
        return agentService.selectAppSecretById(apps.get(0).getAppId());
    }

    @PreAuthorize("@ss.hasPermi('system:agent:workflow:run')")
    @Operation(summary = "查询 Agent 工作流运行详情")
    @GetMapping("/runs/{runId}")
    public AjaxResult runInfo(@PathVariable Long runId)
    {
        return success(agentService.selectWorkflowRunById(runId));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:workflow:list')")
    @Operation(summary = "查询 Agent 工作流运行记录")
    @GetMapping("/runs")
    public TableDataInfo runs(SysAgentWorkflowRun run)
    {
        startPage();
        return getDataTable(agentService.selectWorkflowRunList(run));
    }
}
