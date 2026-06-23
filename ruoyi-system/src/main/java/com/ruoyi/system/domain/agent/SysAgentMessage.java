package com.ruoyi.system.domain.agent;

import java.util.Date;

public class SysAgentMessage
{
    private Long messageId;
    private Long sessionId;
    private String role;
    private String content;
    private String referencesJson;
    private Integer promptTokens;
    private Integer completionTokens;
    private Long elapsedMs;
    private Date createTime;

    public Long getMessageId() { return messageId; }
    public void setMessageId(Long messageId) { this.messageId = messageId; }
    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getReferencesJson() { return referencesJson; }
    public void setReferencesJson(String referencesJson) { this.referencesJson = referencesJson; }
    public Integer getPromptTokens() { return promptTokens; }
    public void setPromptTokens(Integer promptTokens) { this.promptTokens = promptTokens; }
    public Integer getCompletionTokens() { return completionTokens; }
    public void setCompletionTokens(Integer completionTokens) { this.completionTokens = completionTokens; }
    public Long getElapsedMs() { return elapsedMs; }
    public void setElapsedMs(Long elapsedMs) { this.elapsedMs = elapsedMs; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
}
