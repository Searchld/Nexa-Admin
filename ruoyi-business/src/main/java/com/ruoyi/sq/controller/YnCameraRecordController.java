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
import com.ruoyi.sq.domain.YnCameraRecord;
import com.ruoyi.sq.service.IYnCameraRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnCameraRecordController
 */
@Tag(name = "旧系统YnCameraRecord接口")
@RestController
@RequestMapping("/api/ynCameraRecord")
public class YnCameraRecordController extends BaseController
{
    @Autowired
    private IYnCameraRecordService ynCameraRecordService;

    @PreAuthorize("@ss.hasPermi('ynCameraRecord:list')")
    @Operation(summary = "查询YnCameraRecord列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnCameraRecord ynCameraRecord)
    {
        startPage();
        List<YnCameraRecord> list = ynCameraRecordService.selectYnCameraRecordList(ynCameraRecord);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynCameraRecord:list')")
    @Log(title = "YnCameraRecord", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnCameraRecord")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnCameraRecord ynCameraRecord)
    {
        List<YnCameraRecord> list = ynCameraRecordService.selectYnCameraRecordList(ynCameraRecord);
        ExcelUtil<YnCameraRecord> util = new ExcelUtil<>(YnCameraRecord.class);
        util.exportExcel(response, list, "YnCameraRecord数据");
    }

    @PreAuthorize("@ss.hasPermi('ynCameraRecord:query')")
    @Operation(summary = "获取YnCameraRecord详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(ynCameraRecordService.selectYnCameraRecordById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynCameraRecord:add')")
    @Log(title = "YnCameraRecord", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnCameraRecord")
    @PostMapping
    public AjaxResult add(@RequestBody YnCameraRecord ynCameraRecord)
    {
        return toAjax(ynCameraRecordService.insertYnCameraRecord(ynCameraRecord));
    }

    @PreAuthorize("@ss.hasPermi('ynCameraRecord:edit')")
    @Log(title = "YnCameraRecord", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnCameraRecord")
    @PutMapping
    public AjaxResult edit(@RequestBody YnCameraRecord ynCameraRecord)
    {
        return toAjax(ynCameraRecordService.updateYnCameraRecord(ynCameraRecord));
    }

    @PreAuthorize("@ss.hasPermi('ynCameraRecord:del')")
    @Log(title = "YnCameraRecord", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnCameraRecord")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ynCameraRecordService.deleteYnCameraRecordByIds(ids));
    }

}
