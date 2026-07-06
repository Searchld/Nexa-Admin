package com.ruoyi.sq.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.sq.domain.CarsOutLogs;
import com.ruoyi.sq.service.ICarsOutLogsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * CarsOutLogsController
 */
@Tag(name = "旧系统CarsOutLogs接口")
@RestController
@RequestMapping("/api/carsOutLogs")
public class CarsOutLogsController extends BaseController
{
    @Autowired
    private ICarsOutLogsService carsOutLogsService;

    @PreAuthorize("@ss.hasPermi('carsOutLogs:list')")
    @Operation(summary = "查询CarsOutLogs列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(CarsOutLogs carsOutLogs)
    {
        startPage();
        List<CarsOutLogs> list = carsOutLogsService.selectCarsOutLogsList(carsOutLogs);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('carsOutLogs:list')")
    @Log(title = "CarsOutLogs", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出CarsOutLogs")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, CarsOutLogs carsOutLogs)
    {
        List<CarsOutLogs> list = carsOutLogsService.selectCarsOutLogsList(carsOutLogs);
        ExcelUtil<CarsOutLogs> util = new ExcelUtil<>(CarsOutLogs.class);
        util.exportExcel(response, list, "CarsOutLogs数据");
    }

    @PreAuthorize("@ss.hasPermi('carsOutLogs:query')")
    @Operation(summary = "获取CarsOutLogs详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(carsOutLogsService.selectCarsOutLogsById(id));
    }

    @PreAuthorize("@ss.hasPermi('carsOutLogs:add')")
    @Log(title = "CarsOutLogs", businessType = BusinessType.INSERT)
    @Operation(summary = "新增CarsOutLogs")
    @PostMapping
    public AjaxResult add(@RequestBody CarsOutLogs carsOutLogs)
    {
        return toAjax(carsOutLogsService.insertCarsOutLogs(carsOutLogs));
    }

    @PreAuthorize("@ss.hasPermi('carsOutLogs:edit')")
    @Log(title = "CarsOutLogs", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改CarsOutLogs")
    @PutMapping
    public AjaxResult edit(@RequestBody CarsOutLogs carsOutLogs)
    {
        return toAjax(carsOutLogsService.updateCarsOutLogs(carsOutLogs));
    }

    @PreAuthorize("@ss.hasPermi('carsOutLogs:del')")
    @Log(title = "CarsOutLogs", businessType = BusinessType.DELETE)
    @Operation(summary = "删除CarsOutLogs")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carsOutLogsService.deleteCarsOutLogsByIds(ids));
    }

}
