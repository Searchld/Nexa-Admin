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
import com.ruoyi.sq.domain.ACarsLogsHis;
import com.ruoyi.sq.service.IACarsLogsHisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * ACarsLogsHisController
 */
@Tag(name = "旧系统ACarsLogsHis接口")
@RestController
@RequestMapping("/api/aCarsLogsHis")
public class ACarsLogsHisController extends BaseController
{
    @Autowired
    private IACarsLogsHisService aCarsLogsHisService;

    @PreAuthorize("@ss.hasPermi('aCarsLogsHis:list')")
    @Operation(summary = "查询ACarsLogsHis列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(ACarsLogsHis aCarsLogsHis)
    {
        startPage();
        List<ACarsLogsHis> list = aCarsLogsHisService.selectACarsLogsHisList(aCarsLogsHis);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('aCarsLogsHis:list')")
    @Log(title = "ACarsLogsHis", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出ACarsLogsHis")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, ACarsLogsHis aCarsLogsHis)
    {
        List<ACarsLogsHis> list = aCarsLogsHisService.selectACarsLogsHisList(aCarsLogsHis);
        ExcelUtil<ACarsLogsHis> util = new ExcelUtil<>(ACarsLogsHis.class);
        util.exportExcel(response, list, "ACarsLogsHis数据");
    }

    @PreAuthorize("@ss.hasPermi('aCarsLogsHis:query')")
    @Operation(summary = "获取ACarsLogsHis详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(aCarsLogsHisService.selectACarsLogsHisById(id));
    }

    @PreAuthorize("@ss.hasPermi('aCarsLogsHis:add')")
    @Log(title = "ACarsLogsHis", businessType = BusinessType.INSERT)
    @Operation(summary = "新增ACarsLogsHis")
    @PostMapping
    public AjaxResult add(@RequestBody ACarsLogsHis aCarsLogsHis)
    {
        return toAjax(aCarsLogsHisService.insertACarsLogsHis(aCarsLogsHis));
    }

    @PreAuthorize("@ss.hasPermi('aCarsLogsHis:edit')")
    @Log(title = "ACarsLogsHis", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改ACarsLogsHis")
    @PutMapping
    public AjaxResult edit(@RequestBody ACarsLogsHis aCarsLogsHis)
    {
        return toAjax(aCarsLogsHisService.updateACarsLogsHis(aCarsLogsHis));
    }

    @PreAuthorize("@ss.hasPermi('aCarsLogsHis:del')")
    @Log(title = "ACarsLogsHis", businessType = BusinessType.DELETE)
    @Operation(summary = "删除ACarsLogsHis")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aCarsLogsHisService.deleteACarsLogsHisByIds(ids));
    }

}
