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
import com.ruoyi.sq.domain.AlertReason;
import com.ruoyi.sq.service.IAlertReasonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * AlertReasonController
 */
@Tag(name = "旧系统AlertReason接口")
@RestController
@RequestMapping("/api/alertReason")
public class AlertReasonController extends BaseController
{
    @Autowired
    private IAlertReasonService alertReasonService;

    @PreAuthorize("@ss.hasPermi('alertReason:list')")
    @Operation(summary = "查询AlertReason列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(AlertReason alertReason)
    {
        startPage();
        List<AlertReason> list = alertReasonService.selectAlertReasonList(alertReason);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('alertReason:list')")
    @Log(title = "AlertReason", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出AlertReason")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, AlertReason alertReason)
    {
        List<AlertReason> list = alertReasonService.selectAlertReasonList(alertReason);
        ExcelUtil<AlertReason> util = new ExcelUtil<>(AlertReason.class);
        util.exportExcel(response, list, "AlertReason数据");
    }

    @PreAuthorize("@ss.hasPermi('alertReason:query')")
    @Operation(summary = "获取AlertReason详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(alertReasonService.selectAlertReasonById(id));
    }

    @PreAuthorize("@ss.hasPermi('alertReason:add')")
    @Log(title = "AlertReason", businessType = BusinessType.INSERT)
    @Operation(summary = "新增AlertReason")
    @PostMapping
    public AjaxResult add(@RequestBody AlertReason alertReason)
    {
        return toAjax(alertReasonService.insertAlertReason(alertReason));
    }

    @PreAuthorize("@ss.hasPermi('alertReason:edit')")
    @Log(title = "AlertReason", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改AlertReason")
    @PutMapping
    public AjaxResult edit(@RequestBody AlertReason alertReason)
    {
        return toAjax(alertReasonService.updateAlertReason(alertReason));
    }

    @PreAuthorize("@ss.hasPermi('alertReason:del')")
    @Log(title = "AlertReason", businessType = BusinessType.DELETE)
    @Operation(summary = "删除AlertReason")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(alertReasonService.deleteAlertReasonByIds(ids));
    }

}
