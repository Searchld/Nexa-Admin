package com.ruoyi.system.domain.agent;

import java.util.Date;

public class SysAgentWorkflowRun
{
    private Long runId;
    private Long workflowId;
    private Long userId;
    private String inputJson;
    private String outputJson;
    private String status;
    private Long elapsedMs;
    private String errorMsg;
    private Date createTime;
    private Date updateTime;
    private String workflowName;

    public Long getRunId() { return runId; }
    public void setRunId(Long runId) { this.runId = runId; }
    public Long getWorkflowId() { return workflowId; }
    public void setWorkflowId(Long workflowId) { this.workflowId = workflowId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getInputJson() { return inputJson; }
    public void setInputJson(String inputJson) { this.inputJson = inputJson; }
    public String getOutputJson() { return outputJson; }
    public void setOutputJson(String outputJson) { this.outputJson = outputJson; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getElapsedMs() { return elapsedMs; }
    public void setElapsedMs(Long elapsedMs) { this.elapsedMs = elapsedMs; }
    public String getErrorMsg() { return errorMsg; }
    public void setErrorMsg(String errorMsg) { this.errorMsg = errorMsg; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
    public String getWorkflowName() { return workflowName; }
    public void setWorkflowName(String workflowName) { this.workflowName = workflowName; }
}
