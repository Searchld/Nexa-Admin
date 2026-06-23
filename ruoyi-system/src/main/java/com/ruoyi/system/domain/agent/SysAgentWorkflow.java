package com.ruoyi.system.domain.agent;

import com.ruoyi.common.core.domain.BaseEntity;

public class SysAgentWorkflow extends BaseEntity
{
    private Long workflowId;
    private String workflowName;
    private String definitionJson;
    private Integer version;
    private String status;
    private String delFlag;

    public Long getWorkflowId() { return workflowId; }
    public void setWorkflowId(Long workflowId) { this.workflowId = workflowId; }
    public String getWorkflowName() { return workflowName; }
    public void setWorkflowName(String workflowName) { this.workflowName = workflowName; }
    public String getDefinitionJson() { return definitionJson; }
    public void setDefinitionJson(String definitionJson) { this.definitionJson = definitionJson; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getDelFlag() { return delFlag; }
    public void setDelFlag(String delFlag) { this.delFlag = delFlag; }
}
