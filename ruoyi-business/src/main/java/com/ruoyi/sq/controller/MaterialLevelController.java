package com.ruoyi.sq.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 旧系统物料大屏接口
 */
@Tag(name = "旧系统materialLevel接口")
@RestController
@RequestMapping("/api/materialLevel")
public class MaterialLevelController extends BaseController
{
    @PreAuthorize("@ss.hasPermi('materialLevel:list')")
    @Operation(summary = "查询物料大屏汇总")
    @GetMapping
    public AjaxResult list()
    {
        return unsupported("list");
    }

    @PreAuthorize("@ss.hasPermi('materialLevel:edit')")
    @Log(title = "物料大屏", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改物料大屏")
    @PutMapping
    public AjaxResult edit(@RequestBody Map<String, Object> body)
    {
        return unsupported("edit");
    }

    @Operation(summary = "车辆数量")
    @GetMapping("/cars/num")
    public AjaxResult carsNum()
    {
        return zeroCount("cars/num");
    }

    @Operation(summary = "班组数量")
    @GetMapping("/team/num")
    public AjaxResult teamNum()
    {
        return zeroCount("team/num");
    }

    @Operation(summary = "左侧列表")
    @GetMapping("/left/list")
    public AjaxResult leftList()
    {
        return success(new java.util.ArrayList<>());
    }

    @Operation(summary = "入库统计")
    @GetMapping("/chart/count/ru")
    public AjaxResult chartCountRu()
    {
        return zeroCount("chart/count/ru");
    }

    @Operation(summary = "出库统计")
    @GetMapping("/chart/count/chu")
    public AjaxResult chartCountChu()
    {
        return zeroCount("chart/count/chu");
    }

    @Operation(summary = "出库统计列表")
    @GetMapping("/chart/count/chu/list")
    public AjaxResult chartCountChuList()
    {
        return success(new java.util.ArrayList<>());
    }

    @Operation(summary = "入库统计列表")
    @GetMapping("/chart/count/ru/list")
    public AjaxResult chartCountRuList()
    {
        return success(new java.util.ArrayList<>());
    }

    @Operation(summary = "537统计")
    @GetMapping("/chart/count/537")
    public AjaxResult chartCount537()
    {
        return zeroCount("chart/count/537");
    }

    @Operation(summary = "537统计列表")
    @GetMapping("/chart/count/537/list")
    public AjaxResult chartCount537List()
    {
        return success(new java.util.ArrayList<>());
    }

    @Operation(summary = "车辆入库日志")
    @GetMapping("/cars/logs/byId")
    public AjaxResult carsLogsById()
    {
        return unsupported("cars/logs/byId");
    }

    @Operation(summary = "车辆出库日志")
    @GetMapping("/cars/out/logs/byId")
    public AjaxResult carsOutLogsById()
    {
        return unsupported("cars/out/logs/byId");
    }

    @Operation(summary = "查询单条物料数据")
    @GetMapping("/getOne")
    public AjaxResult getOne()
    {
        return unsupported("getOne");
    }

    @Operation(summary = "总数统计")
    @GetMapping("/count/num")
    public AjaxResult countNum()
    {
        return zeroCount("count/num");
    }

    @Operation(summary = "入库总数统计")
    @GetMapping("/ru/count/num")
    public AjaxResult ruCountNum()
    {
        return zeroCount("ru/count/num");
    }

    @Operation(summary = "查询摄像头")
    @GetMapping("/get/camera")
    public AjaxResult getCamera()
    {
        return unsupported("get/camera");
    }

    private AjaxResult zeroCount(String operation)
    {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("operation", operation);
        result.put("count", 0);
        return success(result);
    }

    private AjaxResult unsupported(String operation)
    {
        return AjaxResult.error("旧物料大屏接口 /api/materialLevel/" + operation + " 已保留路径，请按原SQL统计语义补齐专用 Service 实现");
    }
}
