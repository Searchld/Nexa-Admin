package com.ruoyi.system.domain.agent.dto;

import java.util.List;

public class AgentRagSearchRequest
{
    private String query;
    private Long kbId;
    private List<Long> kbIds;
    private Integer topK;
    private Double similarityThreshold;

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }
    public Long getKbId() { return kbId; }
    public void setKbId(Long kbId) { this.kbId = kbId; }
    public List<Long> getKbIds() { return kbIds; }
    public void setKbIds(List<Long> kbIds) { this.kbIds = kbIds; }
    public Integer getTopK() { return topK; }
    public void setTopK(Integer topK) { this.topK = topK; }
    public Double getSimilarityThreshold() { return similarityThreshold; }
    public void setSimilarityThreshold(Double similarityThreshold) { this.similarityThreshold = similarityThreshold; }
}
