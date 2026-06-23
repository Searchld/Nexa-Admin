package com.ruoyi.system.domain.agent.dto;

import java.util.List;

public class AgentChatRequest
{
    private Long sessionId;
    private Long appId;
    private Long kbId;
    private String content;
    private List<Long> kbIds;

    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }
    public Long getAppId() { return appId; }
    public void setAppId(Long appId) { this.appId = appId; }
    public Long getKbId() { return kbId; }
    public void setKbId(Long kbId) { this.kbId = kbId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public List<Long> getKbIds() { return kbIds; }
    public void setKbIds(List<Long> kbIds) { this.kbIds = kbIds; }
}
