package com.ruoyi.sq.controller;

import java.util.Map;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "旧系统channelConfig接口")
@RestController
@RequestMapping("/api/nvr")
public class ChannelConfigController extends SqBaseController
{
    private static final String ENTITY = "channelConfig";

    @Operation(summary = "旧系统兼容接口 GET /channel/list")
    @GetMapping("/channel/list")
    public AjaxResult get1_channel_list(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "channel_list", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /live/data")
    @GetMapping("/live/data")
    public AjaxResult get2_live_data(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "live_data", params, body, pathVars);
    }

    @PreAuthorize("@ss.hasPermi('nvr:edit')")
    @Operation(summary = "旧系统兼容接口 GET /save/data")
    @GetMapping("/save/data")
    public AjaxResult get3_save_data(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "save_data", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /get/channel")
    @GetMapping("/get/channel")
    public AjaxResult get4_get_channel(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "get_channel", params, body, pathVars);
    }

}
