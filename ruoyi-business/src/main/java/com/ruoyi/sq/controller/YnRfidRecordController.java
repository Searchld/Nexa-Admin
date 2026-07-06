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
import com.ruoyi.sq.domain.YnRfidRecord;
import com.ruoyi.sq.service.IYnRfidRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnRfidRecordController
 */
@Tag(name = "旧系统YnRfidRecord接口")
@RestController
@RequestMapping("/api/ynRfidRecord")
public class YnRfidRecordController extends BaseController
{
    @Autowired
    private IYnRfidRecordService ynRfidRecordService;

    @PreAuthorize("@ss.hasPermi('ynRfidRecord:list')")
    @Operation(summary = "查询YnRfidRecord列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnRfidRecord ynRfidRecord)
    {
        startPage();
        List<YnRfidRecord> list = ynRfidRecordService.selectYnRfidRecordList(ynRfidRecord);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynRfidRecord:list')")
    @Log(title = "YnRfidRecord", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnRfidRecord")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnRfidRecord ynRfidRecord)
    {
        List<YnRfidRecord> list = ynRfidRecordService.selectYnRfidRecordList(ynRfidRecord);
        ExcelUtil<YnRfidRecord> util = new ExcelUtil<>(YnRfidRecord.class);
        util.exportExcel(response, list, "YnRfidRecord数据");
    }

    @PreAuthorize("@ss.hasPermi('ynRfidRecord:query')")
    @Operation(summary = "获取YnRfidRecord详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Integer id)
    {
        return success(ynRfidRecordService.selectYnRfidRecordById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynRfidRecord:add')")
    @Log(title = "YnRfidRecord", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnRfidRecord")
    @PostMapping
    public AjaxResult add(@RequestBody YnRfidRecord ynRfidRecord)
    {
        return toAjax(ynRfidRecordService.insertYnRfidRecord(ynRfidRecord));
    }

    @PreAuthorize("@ss.hasPermi('ynRfidRecord:edit')")
    @Log(title = "YnRfidRecord", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnRfidRecord")
    @PutMapping
    public AjaxResult edit(@RequestBody YnRfidRecord ynRfidRecord)
    {
        return toAjax(ynRfidRecordService.updateYnRfidRecord(ynRfidRecord));
    }

    @PreAuthorize("@ss.hasPermi('ynRfidRecord:del')")
    @Log(title = "YnRfidRecord", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnRfidRecord")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(ynRfidRecordService.deleteYnRfidRecordByIds(ids));
    }

}
