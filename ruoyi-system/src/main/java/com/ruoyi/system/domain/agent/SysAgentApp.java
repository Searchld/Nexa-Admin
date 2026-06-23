package com.ruoyi.system.domain.agent;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

public class SysAgentApp extends BaseEntity
{
    private Long appId;
    private String appName;
    private String appType;
    private String baseUrl;
    private String apiKey;
    private String modelCode;
    private String embeddingBaseUrl;
    private String embeddingApiKey;
    private String embeddingModelCode;
    private BigDecimal temperature;
    private Integer maxTokens;
    private String systemPrompt;
    private String bindModule;
    private String isDefault;
    private String status;
    private String delFlag;

    public Long getAppId() { return appId; }
    public void setAppId(Long appId) { this.appId = appId; }
    public String getAppName() { return appName; }
    public void setAppName(String appName) { this.appName = appName; }
    public String getAppType() { return appType; }
    public void setAppType(String appType) { this.appType = appType; }
    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    public String getModelCode() { return modelCode; }
    public void setModelCode(String modelCode) { this.modelCode = modelCode; }
    public String getEmbeddingBaseUrl() { return embeddingBaseUrl; }
    public void setEmbeddingBaseUrl(String embeddingBaseUrl) { this.embeddingBaseUrl = embeddingBaseUrl; }
    public String getEmbeddingApiKey() { return embeddingApiKey; }
    public void setEmbeddingApiKey(String embeddingApiKey) { this.embeddingApiKey = embeddingApiKey; }
    public String getEmbeddingModelCode() { return embeddingModelCode; }
    public void setEmbeddingModelCode(String embeddingModelCode) { this.embeddingModelCode = embeddingModelCode; }
    public BigDecimal getTemperature() { return temperature; }
    public void setTemperature(BigDecimal temperature) { this.temperature = temperature; }
    public Integer getMaxTokens() { return maxTokens; }
    public void setMaxTokens(Integer maxTokens) { this.maxTokens = maxTokens; }
    public String getSystemPrompt() { return systemPrompt; }
    public void setSystemPrompt(String systemPrompt) { this.systemPrompt = systemPrompt; }
    public String getBindModule() { return bindModule; }
    public void setBindModule(String bindModule) { this.bindModule = bindModule; }
    public String getIsDefault() { return isDefault; }
    public void setIsDefault(String isDefault) { this.isDefault = isDefault; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getDelFlag() { return delFlag; }
    public void setDelFlag(String delFlag) { this.delFlag = delFlag; }
}
