package com.ruoyi.system.domain.agent;

import com.ruoyi.common.core.domain.BaseEntity;

public class SysAgentKnowledgeDoc extends BaseEntity
{
    private Long docId;
    private Long kbId;
    private String fileName;
    private String fileType;
    private String filePath;
    private Long fileSize;
    private String parseStatus;
    private String errorMsg;
    private Integer chunkCount;
    private String kbName;

    public Long getDocId() { return docId; }
    public void setDocId(Long docId) { this.docId = docId; }
    public Long getKbId() { return kbId; }
    public void setKbId(Long kbId) { this.kbId = kbId; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public Long getFileSize() { return fileSize; }
    public void setFileSize(Long fileSize) { this.fileSize = fileSize; }
    public String getParseStatus() { return parseStatus; }
    public void setParseStatus(String parseStatus) { this.parseStatus = parseStatus; }
    public String getErrorMsg() { return errorMsg; }
    public void setErrorMsg(String errorMsg) { this.errorMsg = errorMsg; }
    public Integer getChunkCount() { return chunkCount; }
    public void setChunkCount(Integer chunkCount) { this.chunkCount = chunkCount; }
    public String getKbName() { return kbName; }
    public void setKbName(String kbName) { this.kbName = kbName; }
}
