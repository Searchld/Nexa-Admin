package com.ruoyi.sq.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.sq.config.SqExternalProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 旧系统NVR通道配置接口
 */
@Tag(name = "旧系统NVR接口")
@RestController
@RequestMapping("/api/nvr")
public class ChannelConfigController extends BaseController
{
    private final SqExternalProperties properties;

    public ChannelConfigController(SqExternalProperties properties)
    {
        this.properties = properties;
    }

    @Operation(summary = "查询NVR通道列表")
    @GetMapping("/channel/list")
    public AjaxResult channelList()
    {
        return mediaDisabled("channel/list");
    }

    @Operation(summary = "查询NVR直播数据")
    @GetMapping("/live/data")
    public AjaxResult liveData()
    {
        return mediaDisabled("live/data");
    }

    @PreAuthorize("@ss.hasPermi('nvr:edit')")
    @Operation(summary = "保存NVR数据")
    @GetMapping("/save/data")
    public AjaxResult saveData()
    {
        return mediaDisabled("save/data");
    }

    @Operation(summary = "获取NVR通道")
    @GetMapping("/get/channel")
    public AjaxResult getChannel()
    {
        return mediaDisabled("get/channel");
    }

    private AjaxResult mediaDisabled(String operation)
    {
        if (!properties.getMedia().isEnabled())
        {
            return AjaxResult.error("sq.media.enabled 未开启，无法调用旧NVR接口 /api/nvr/" + operation);
        }
        return AjaxResult.error("旧NVR接口 /api/nvr/" + operation + " 已保留路径，请按现场NVR协议补齐专用 Service 实现");
    }
}
