package com.ruoyi.system.domain.agent;

import java.util.Date;

public class SysAgentKnowledgeChunk
{
    private Long chunkId;
    private Long kbId;
    private Long docId;
    private String chunkText;
    private String chunkSummary;
    private String vectorId;
    private Integer sourcePage;
    private Integer sourceParagraph;
    private String contentHash;
    private Date createTime;
    private String fileName;
    private String kbName;

    public Long getChunkId() { return chunkId; }
    public void setChunkId(Long chunkId) { this.chunkId = chunkId; }
    public Long getKbId() { return kbId; }
    public void setKbId(Long kbId) { this.kbId = kbId; }
    public Long getDocId() { return docId; }
    public void setDocId(Long docId) { this.docId = docId; }
    public String getChunkText() { return chunkText; }
    public void setChunkText(String chunkText) { this.chunkText = chunkText; }
    public String getChunkSummary() { return chunkSummary; }
    public void setChunkSummary(String chunkSummary) { this.chunkSummary = chunkSummary; }
    public String getVectorId() { return vectorId; }
    public void setVectorId(String vectorId) { this.vectorId = vectorId; }
    public Integer getSourcePage() { return sourcePage; }
    public void setSourcePage(Integer sourcePage) { this.sourcePage = sourcePage; }
    public Integer getSourceParagraph() { return sourceParagraph; }
    public void setSourceParagraph(Integer sourceParagraph) { this.sourceParagraph = sourceParagraph; }
    public String getContentHash() { return contentHash; }
    public void setContentHash(String contentHash) { this.contentHash = contentHash; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getKbName() { return kbName; }
    public void setKbName(String kbName) { this.kbName = kbName; }
}
