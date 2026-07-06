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
import com.ruoyi.sq.domain.YnSiren;
import com.ruoyi.sq.service.IYnSirenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnSirenController
 */
@Tag(name = "旧系统YnSiren接口")
@RestController
@RequestMapping("/api/ynSiren")
public class YnSirenController extends BaseController
{
    @Autowired
    private IYnSirenService ynSirenService;

    @PreAuthorize("@ss.hasPermi('ynSiren:list')")
    @Operation(summary = "查询YnSiren列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnSiren ynSiren)
    {
        startPage();
        List<YnSiren> list = ynSirenService.selectYnSirenList(ynSiren);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynSiren:list')")
    @Log(title = "YnSiren", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnSiren")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnSiren ynSiren)
    {
        List<YnSiren> list = ynSirenService.selectYnSirenList(ynSiren);
        ExcelUtil<YnSiren> util = new ExcelUtil<>(YnSiren.class);
        util.exportExcel(response, list, "YnSiren数据");
    }

    @PreAuthorize("@ss.hasPermi('ynSiren:query')")
    @Operation(summary = "获取YnSiren详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Integer id)
    {
        return success(ynSirenService.selectYnSirenById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynSiren:add')")
    @Log(title = "YnSiren", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnSiren")
    @PostMapping
    public AjaxResult add(@RequestBody YnSiren ynSiren)
    {
        return toAjax(ynSirenService.insertYnSiren(ynSiren));
    }

    @PreAuthorize("@ss.hasPermi('ynSiren:edit')")
    @Log(title = "YnSiren", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnSiren")
    @PutMapping
    public AjaxResult edit(@RequestBody YnSiren ynSiren)
    {
        return toAjax(ynSirenService.updateYnSiren(ynSiren));
    }

    @PreAuthorize("@ss.hasPermi('ynSiren:del')")
    @Log(title = "YnSiren", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnSiren")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(ynSirenService.deleteYnSirenByIds(ids));
    }

}
