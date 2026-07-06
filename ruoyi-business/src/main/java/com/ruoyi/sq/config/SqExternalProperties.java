package com.ruoyi.sq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sq")
public class SqExternalProperties
{
    private final Mqtt mqtt = new Mqtt();
    private final Media media = new Media();
    private final Wx wx = new Wx();
    private final Upload upload = new Upload();
    private final Websocket websocket = new Websocket();

    public Mqtt getMqtt() { return mqtt; }
    public Media getMedia() { return media; }
    public Wx getWx() { return wx; }
    public Upload getUpload() { return upload; }
    public Websocket getWebsocket() { return websocket; }

    public static class Mqtt { private boolean enabled; private String url; private String username; private String password; private String clientId; private String defaultTopic; public boolean isEnabled(){return enabled;} public void setEnabled(boolean enabled){this.enabled=enabled;} public String getUrl(){return url;} public void setUrl(String url){this.url=url;} public String getUsername(){return username;} public void setUsername(String username){this.username=username;} public String getPassword(){return password;} public void setPassword(String password){this.password=password;} public String getClientId(){return clientId;} public void setClientId(String clientId){this.clientId=clientId;} public String getDefaultTopic(){return defaultTopic;} public void setDefaultTopic(String defaultTopic){this.defaultTopic=defaultTopic;} }
    public static class Media { private boolean enabled; private String baseUrl; private String snapshotPath; private String recordPath; private String ffmpegPath = "ffmpeg"; public boolean isEnabled(){return enabled;} public void setEnabled(boolean enabled){this.enabled=enabled;} public String getBaseUrl(){return baseUrl;} public void setBaseUrl(String baseUrl){this.baseUrl=baseUrl;} public String getSnapshotPath(){return snapshotPath;} public void setSnapshotPath(String snapshotPath){this.snapshotPath=snapshotPath;} public String getRecordPath(){return recordPath;} public void setRecordPath(String recordPath){this.recordPath=recordPath;} public String getFfmpegPath(){return ffmpegPath;} public void setFfmpegPath(String ffmpegPath){this.ffmpegPath=ffmpegPath;} }
    public static class Wx { private boolean enabled; private String corpId; private String secret; private String agentId; public boolean isEnabled(){return enabled;} public void setEnabled(boolean enabled){this.enabled=enabled;} public String getCorpId(){return corpId;} public void setCorpId(String corpId){this.corpId=corpId;} public String getSecret(){return secret;} public void setSecret(String secret){this.secret=secret;} public String getAgentId(){return agentId;} public void setAgentId(String agentId){this.agentId=agentId;} }
    public static class Upload { private String filePath; private String imagePath; public String getFilePath(){return filePath;} public void setFilePath(String filePath){this.filePath=filePath;} public String getImagePath(){return imagePath;} public void setImagePath(String imagePath){this.imagePath=imagePath;} }
    public static class Websocket { private boolean enabled; public boolean isEnabled(){return enabled;} public void setEnabled(boolean enabled){this.enabled=enabled;} }
}
