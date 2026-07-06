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
import com.ruoyi.sq.domain.YnUserXj;
import com.ruoyi.sq.service.IYnUserXjService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnUserXjController
 */
@Tag(name = "旧系统YnUserXj接口")
@RestController
@RequestMapping("/api/ynUserXj")
public class YnUserXjController extends BaseController
{
    @Autowired
    private IYnUserXjService ynUserXjService;

    @PreAuthorize("@ss.hasPermi('ynUserXj:list')")
    @Operation(summary = "查询YnUserXj列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnUserXj ynUserXj)
    {
        startPage();
        List<YnUserXj> list = ynUserXjService.selectYnUserXjList(ynUserXj);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynUserXj:list')")
    @Log(title = "YnUserXj", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnUserXj")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnUserXj ynUserXj)
    {
        List<YnUserXj> list = ynUserXjService.selectYnUserXjList(ynUserXj);
        ExcelUtil<YnUserXj> util = new ExcelUtil<>(YnUserXj.class);
        util.exportExcel(response, list, "YnUserXj数据");
    }

    @PreAuthorize("@ss.hasPermi('ynUserXj:query')")
    @Operation(summary = "获取YnUserXj详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(ynUserXjService.selectYnUserXjById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynUserXj:add')")
    @Log(title = "YnUserXj", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnUserXj")
    @PostMapping
    public AjaxResult add(@RequestBody YnUserXj ynUserXj)
    {
        return toAjax(ynUserXjService.insertYnUserXj(ynUserXj));
    }

    @PreAuthorize("@ss.hasPermi('ynUserXj:edit')")
    @Log(title = "YnUserXj", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnUserXj")
    @PutMapping
    public AjaxResult edit(@RequestBody YnUserXj ynUserXj)
    {
        return toAjax(ynUserXjService.updateYnUserXj(ynUserXj));
    }

    @PreAuthorize("@ss.hasPermi('ynUserXj:del')")
    @Log(title = "YnUserXj", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnUserXj")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ynUserXjService.deleteYnUserXjByIds(ids));
    }

}
