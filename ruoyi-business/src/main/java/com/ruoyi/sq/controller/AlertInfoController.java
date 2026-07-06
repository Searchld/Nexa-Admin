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
import com.ruoyi.sq.domain.AlertInfo;
import com.ruoyi.sq.service.IAlertInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * AlertInfoController
 */
@Tag(name = "旧系统AlertInfo接口")
@RestController
@RequestMapping("/api/alertInfo")
public class AlertInfoController extends BaseController
{
    @Autowired
    private IAlertInfoService alertInfoService;

    @PreAuthorize("@ss.hasPermi('alertInfo:list')")
    @Operation(summary = "查询AlertInfo列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(AlertInfo alertInfo)
    {
        startPage();
        List<AlertInfo> list = alertInfoService.selectAlertInfoList(alertInfo);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('alertInfo:list')")
    @Log(title = "AlertInfo", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出AlertInfo")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, AlertInfo alertInfo)
    {
        List<AlertInfo> list = alertInfoService.selectAlertInfoList(alertInfo);
        ExcelUtil<AlertInfo> util = new ExcelUtil<>(AlertInfo.class);
        util.exportExcel(response, list, "AlertInfo数据");
    }

    @PreAuthorize("@ss.hasPermi('alertInfo:query')")
    @Operation(summary = "获取AlertInfo详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(alertInfoService.selectAlertInfoById(id));
    }

    @PreAuthorize("@ss.hasPermi('alertInfo:add')")
    @Log(title = "AlertInfo", businessType = BusinessType.INSERT)
    @Operation(summary = "新增AlertInfo")
    @PostMapping
    public AjaxResult add(@RequestBody AlertInfo alertInfo)
    {
        return toAjax(alertInfoService.insertAlertInfo(alertInfo));
    }

    @PreAuthorize("@ss.hasPermi('alertInfo:edit')")
    @Log(title = "AlertInfo", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改AlertInfo")
    @PutMapping
    public AjaxResult edit(@RequestBody AlertInfo alertInfo)
    {
        return toAjax(alertInfoService.updateAlertInfo(alertInfo));
    }

    @PreAuthorize("@ss.hasPermi('alertInfo:del')")
    @Log(title = "AlertInfo", businessType = BusinessType.DELETE)
    @Operation(summary = "删除AlertInfo")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(alertInfoService.deleteAlertInfoByIds(ids));
    }

}
