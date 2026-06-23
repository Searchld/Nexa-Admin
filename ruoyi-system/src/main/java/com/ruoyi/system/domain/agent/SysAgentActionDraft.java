package com.ruoyi.system.domain.agent;

import java.util.Date;

public class SysAgentActionDraft
{
    private Long draftId;
    private Long userId;
    private Long sessionId;
    private String actionType;
    private String actionTitle;
    private String actionDesc;
    private String argumentsJson;
    private String requiredPerms;
    private String executable;
    private String status;
    private String resultMsg;
    private String errorMsg;
    private Date createTime;
    private Date updateTime;
    private Date confirmTime;

    public Long getDraftId() { return draftId; }
    public void setDraftId(Long draftId) { this.draftId = draftId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }
    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }
    public String getActionTitle() { return actionTitle; }
    public void setActionTitle(String actionTitle) { this.actionTitle = actionTitle; }
    public String getActionDesc() { return actionDesc; }
    public void setActionDesc(String actionDesc) { this.actionDesc = actionDesc; }
    public String getArgumentsJson() { return argumentsJson; }
    public void setArgumentsJson(String argumentsJson) { this.argumentsJson = argumentsJson; }
    public String getRequiredPerms() { return requiredPerms; }
    public void setRequiredPerms(String requiredPerms) { this.requiredPerms = requiredPerms; }
    public String getExecutable() { return executable; }
    public void setExecutable(String executable) { this.executable = executable; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getResultMsg() { return resultMsg; }
    public void setResultMsg(String resultMsg) { this.resultMsg = resultMsg; }
    public String getErrorMsg() { return errorMsg; }
    public void setErrorMsg(String errorMsg) { this.errorMsg = errorMsg; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
    public Date getConfirmTime() { return confirmTime; }
    public void setConfirmTime(Date confirmTime) { this.confirmTime = confirmTime; }
}
