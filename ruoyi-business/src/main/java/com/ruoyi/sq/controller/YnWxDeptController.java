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
import com.ruoyi.sq.domain.YnWxDept;
import com.ruoyi.sq.service.IYnWxDeptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnWxDeptController
 */
@Tag(name = "旧系统YnWxDept接口")
@RestController
@RequestMapping("/api/ynWxDept")
public class YnWxDeptController extends BaseController
{
    @Autowired
    private IYnWxDeptService ynWxDeptService;

    @PreAuthorize("@ss.hasPermi('ynWxDept:list')")
    @Operation(summary = "查询YnWxDept列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnWxDept ynWxDept)
    {
        startPage();
        List<YnWxDept> list = ynWxDeptService.selectYnWxDeptList(ynWxDept);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynWxDept:list')")
    @Log(title = "YnWxDept", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnWxDept")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnWxDept ynWxDept)
    {
        List<YnWxDept> list = ynWxDeptService.selectYnWxDeptList(ynWxDept);
        ExcelUtil<YnWxDept> util = new ExcelUtil<>(YnWxDept.class);
        util.exportExcel(response, list, "YnWxDept数据");
    }

    @PreAuthorize("@ss.hasPermi('ynWxDept:query')")
    @Operation(summary = "获取YnWxDept详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(ynWxDeptService.selectYnWxDeptById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynWxDept:add')")
    @Log(title = "YnWxDept", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnWxDept")
    @PostMapping
    public AjaxResult add(@RequestBody YnWxDept ynWxDept)
    {
        return toAjax(ynWxDeptService.insertYnWxDept(ynWxDept));
    }

    @PreAuthorize("@ss.hasPermi('ynWxDept:edit')")
    @Log(title = "YnWxDept", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnWxDept")
    @PutMapping
    public AjaxResult edit(@RequestBody YnWxDept ynWxDept)
    {
        return toAjax(ynWxDeptService.updateYnWxDept(ynWxDept));
    }

    @PreAuthorize("@ss.hasPermi('ynWxDept:del')")
    @Log(title = "YnWxDept", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnWxDept")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ynWxDeptService.deleteYnWxDeptByIds(ids));
    }

}
