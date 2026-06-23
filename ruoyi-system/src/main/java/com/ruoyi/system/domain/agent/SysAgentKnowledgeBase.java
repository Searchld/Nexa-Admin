package com.ruoyi.system.domain.agent;

import com.ruoyi.common.core.domain.BaseEntity;

public class SysAgentKnowledgeBase extends BaseEntity
{
    private Long kbId;
    private String kbName;
    private String description;
    private String visibility;
    private String status;
    private String delFlag;
    private Integer docCount;

    public Long getKbId() { return kbId; }
    public void setKbId(Long kbId) { this.kbId = kbId; }
    public String getKbName() { return kbName; }
    public void setKbName(String kbName) { this.kbName = kbName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getVisibility() { return visibility; }
    public void setVisibility(String visibility) { this.visibility = visibility; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getDelFlag() { return delFlag; }
    public void setDelFlag(String delFlag) { this.delFlag = delFlag; }
    public Integer getDocCount() { return docCount; }
    public void setDocCount(Integer docCount) { this.docCount = docCount; }
}
