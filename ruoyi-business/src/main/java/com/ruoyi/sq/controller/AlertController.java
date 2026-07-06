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
import com.ruoyi.sq.domain.Alert;
import com.ruoyi.sq.service.IAlertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * AlertController
 */
@Tag(name = "旧系统Alert接口")
@RestController
@RequestMapping("/api/alert")
public class AlertController extends BaseController
{
    @Autowired
    private IAlertService alertService;

    @PreAuthorize("@ss.hasPermi('alert:list')")
    @Operation(summary = "查询Alert列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(Alert alert)
    {
        startPage();
        List<Alert> list = alertService.selectAlertList(alert);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('alert:list')")
    @Log(title = "Alert", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出Alert")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, Alert alert)
    {
        List<Alert> list = alertService.selectAlertList(alert);
        ExcelUtil<Alert> util = new ExcelUtil<>(Alert.class);
        util.exportExcel(response, list, "Alert数据");
    }

    @PreAuthorize("@ss.hasPermi('alert:query')")
    @Operation(summary = "获取Alert详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(alertService.selectAlertById(id));
    }

    @PreAuthorize("@ss.hasPermi('alert:add')")
    @Log(title = "Alert", businessType = BusinessType.INSERT)
    @Operation(summary = "新增Alert")
    @PostMapping
    public AjaxResult add(@RequestBody Alert alert)
    {
        return toAjax(alertService.insertAlert(alert));
    }

    @PreAuthorize("@ss.hasPermi('alert:edit')")
    @Log(title = "Alert", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改Alert")
    @PutMapping
    public AjaxResult edit(@RequestBody Alert alert)
    {
        return toAjax(alertService.updateAlert(alert));
    }

    @PreAuthorize("@ss.hasPermi('alert:del')")
    @Log(title = "Alert", businessType = BusinessType.DELETE)
    @Operation(summary = "删除Alert")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(alertService.deleteAlertByIds(ids));
    }

}
