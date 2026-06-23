package com.ruoyi.system.domain.agent;

import java.util.Date;
import com.ruoyi.common.core.domain.BaseEntity;

public class SysAgentSession extends BaseEntity
{
    private Long sessionId;
    private Long userId;
    private Long appId;
    private String title;
    private String module;
    private Date lastMessageTime;
    private String appName;
    private String modelCode;

    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getAppId() { return appId; }
    public void setAppId(Long appId) { this.appId = appId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getModule() { return module; }
    public void setModule(String module) { this.module = module; }
    public Date getLastMessageTime() { return lastMessageTime; }
    public void setLastMessageTime(Date lastMessageTime) { this.lastMessageTime = lastMessageTime; }
    public String getAppName() { return appName; }
    public void setAppName(String appName) { this.appName = appName; }
    public String getModelCode() { return modelCode; }
    public void setModelCode(String modelCode) { this.modelCode = modelCode; }
}
