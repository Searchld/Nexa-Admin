package com.ruoyi.sq.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "旧系统大屏接口")
@RestController
@RequestMapping("/api/data")
public class DataController extends SqBaseController
{
    @Anonymous
    @GetMapping({"/getVideo", "/camera/list"})
    public TableDataInfo cameraList(@RequestParam Map<String, Object> params)
    {
        params.putIfAbsent("isDeleted", "0");
        return listEntity("camera", params);
    }

    @GetMapping({"/isAlert/{status}", "/show/alert"})
    public AjaxResult alertStatus(@PathVariable(required = false) Map<String, String> pathVars)
    {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", pathVars == null ? null : pathVars.get("status"));
        result.put("count", 0);
        return AjaxResult.success(result);
    }

    @Anonymous
    @GetMapping("/{operation}")
    public AjaxResult getOperation(@PathVariable String operation, @RequestParam Map<String, Object> params)
    {
        return specialEntity("camera", operation, params, null, null);
    }

    @Anonymous
    @GetMapping("/{operation}/{id}")
    public AjaxResult getOperationById(@PathVariable Map<String, String> pathVars, @RequestParam Map<String, Object> params)
    {
        return specialEntity("camera", pathVars.get("operation"), params, null, pathVars);
    }

    @Anonymous
    @PostMapping("/{operation}")
    public AjaxResult postOperation(@PathVariable String operation, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity("camera", operation, params, body, null);
    }
}
