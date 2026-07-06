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
import com.ruoyi.sq.domain.CarsLogs;
import com.ruoyi.sq.service.ICarsLogsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * CarsLogsController
 */
@Tag(name = "旧系统CarsLogs接口")
@RestController
@RequestMapping("/api/carsLogs")
public class CarsLogsController extends BaseController
{
    @Autowired
    private ICarsLogsService carsLogsService;

    @PreAuthorize("@ss.hasPermi('carsLogs:list')")
    @Operation(summary = "查询CarsLogs列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(CarsLogs carsLogs)
    {
        startPage();
        List<CarsLogs> list = carsLogsService.selectCarsLogsList(carsLogs);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('carsLogs:list')")
    @Log(title = "CarsLogs", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出CarsLogs")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, CarsLogs carsLogs)
    {
        List<CarsLogs> list = carsLogsService.selectCarsLogsList(carsLogs);
        ExcelUtil<CarsLogs> util = new ExcelUtil<>(CarsLogs.class);
        util.exportExcel(response, list, "CarsLogs数据");
    }

    @PreAuthorize("@ss.hasPermi('carsLogs:query')")
    @Operation(summary = "获取CarsLogs详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(carsLogsService.selectCarsLogsById(id));
    }

    @PreAuthorize("@ss.hasPermi('carsLogs:add')")
    @Log(title = "CarsLogs", businessType = BusinessType.INSERT)
    @Operation(summary = "新增CarsLogs")
    @PostMapping
    public AjaxResult add(@RequestBody CarsLogs carsLogs)
    {
        return toAjax(carsLogsService.insertCarsLogs(carsLogs));
    }

    @PreAuthorize("@ss.hasPermi('carsLogs:edit')")
    @Log(title = "CarsLogs", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改CarsLogs")
    @PutMapping
    public AjaxResult edit(@RequestBody CarsLogs carsLogs)
    {
        return toAjax(carsLogsService.updateCarsLogs(carsLogs));
    }

    @PreAuthorize("@ss.hasPermi('carsLogs:del')")
    @Log(title = "CarsLogs", businessType = BusinessType.DELETE)
    @Operation(summary = "删除CarsLogs")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carsLogsService.deleteCarsLogsByIds(ids));
    }

}
