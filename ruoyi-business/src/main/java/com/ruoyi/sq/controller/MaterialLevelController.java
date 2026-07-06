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

@Tag(name = "旧系统materialLevel接口")
@RestController
@RequestMapping("/api/materialLevel")
public class MaterialLevelController extends SqBaseController
{
    private static final String ENTITY = "materialLevel";

    @PreAuthorize("@ss.hasPermi('materialLevel:list')")
    @Operation(summary = "查询列表")
    @GetMapping
    public TableDataInfo list(@RequestParam Map<String, Object> params)
    {
        return listEntity(ENTITY, params);
    }

    @PreAuthorize("@ss.hasPermi('materialLevel:edit')")
    @Log(title = "旧系统数据修改", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改数据")
    @PutMapping
    public AjaxResult edit(@RequestBody Map<String, Object> body)
    {
        return updateEntity(ENTITY, body);
    }

    @Operation(summary = "旧系统兼容接口 GET /cars/num")
    @GetMapping("/cars/num")
    public AjaxResult get1_cars_num(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "cars_num", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /team/num")
    @GetMapping("/team/num")
    public AjaxResult get2_team_num(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "team_num", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /left/list")
    @GetMapping("/left/list")
    public AjaxResult get3_left_list(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "left_list", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /chart/count/ru")
    @GetMapping("/chart/count/ru")
    public AjaxResult get4_chart_count_ru(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "chart_count_ru", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /chart/count/chu")
    @GetMapping("/chart/count/chu")
    public AjaxResult get5_chart_count_chu(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "chart_count_chu", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /chart/count/chu/list")
    @GetMapping("/chart/count/chu/list")
    public AjaxResult get6_chart_count_chu_list(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "chart_count_chu_list", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /chart/count/ru/list")
    @GetMapping("/chart/count/ru/list")
    public AjaxResult get7_chart_count_ru_list(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "chart_count_ru_list", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /chart/count/537")
    @GetMapping("/chart/count/537")
    public AjaxResult get8_chart_count_537(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "chart_count_537", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /chart/count/537/list")
    @GetMapping("/chart/count/537/list")
    public AjaxResult get9_chart_count_537_list(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "chart_count_537_list", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /cars/logs/byId")
    @GetMapping("/cars/logs/byId")
    public AjaxResult get10_cars_logs_byId(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "cars_logs_byId", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /cars/out/logs/byId")
    @GetMapping("/cars/out/logs/byId")
    public AjaxResult get11_cars_out_logs_byId(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "cars_out_logs_byId", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /getOne")
    @GetMapping("/getOne")
    public AjaxResult get12_getOne(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "getOne", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /count/num")
    @GetMapping("/count/num")
    public AjaxResult get13_count_num(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "count_num", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /ru/count/num")
    @GetMapping("/ru/count/num")
    public AjaxResult get14_ru_count_num(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "ru_count_num", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /get/camera")
    @GetMapping("/get/camera")
    public AjaxResult get15_get_camera(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "get_camera", params, body, pathVars);
    }

}
