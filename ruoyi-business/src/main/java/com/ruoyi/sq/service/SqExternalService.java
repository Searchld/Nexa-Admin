package com.ruoyi.sq.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.config.SqExternalProperties;

@Service
public class SqExternalService
{
    private final SqExternalProperties properties;

    public SqExternalService(SqExternalProperties properties)
    {
        this.properties = properties;
    }

    public Map<String, Object> status()
    {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("mqttEnabled", properties.getMqtt().isEnabled());
        map.put("mediaEnabled", properties.getMedia().isEnabled());
        map.put("wxEnabled", properties.getWx().isEnabled());
        map.put("websocketEnabled", properties.getWebsocket().isEnabled());
        return map;
    }

    public Map<String, Object> disabled(String capability)
    {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("enabled", false);
        map.put("capability", capability);
        map.put("message", capability + " 未启用，请配置 sq." + capability + ".enabled 及相关连接参数");
        return map;
    }
}
