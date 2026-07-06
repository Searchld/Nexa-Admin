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
import com.ruoyi.sq.domain.Visual;
import com.ruoyi.sq.service.IVisualService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * VisualController
 */
@Tag(name = "旧系统Visual接口")
@RestController
@RequestMapping("/data4j/visual")
public class VisualController extends BaseController
{
    @Autowired
    private IVisualService visualService;

    @PreAuthorize("@ss.hasPermi('visual:list')")
    @Operation(summary = "查询Visual列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(Visual visual)
    {
        startPage();
        List<Visual> list = visualService.selectVisualList(visual);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('visual:list')")
    @Log(title = "Visual", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出Visual")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, Visual visual)
    {
        List<Visual> list = visualService.selectVisualList(visual);
        ExcelUtil<Visual> util = new ExcelUtil<>(Visual.class);
        util.exportExcel(response, list, "Visual数据");
    }

    @PreAuthorize("@ss.hasPermi('visual:query')")
    @Operation(summary = "获取Visual详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(visualService.selectVisualById(id));
    }

    @PreAuthorize("@ss.hasPermi('visual:add')")
    @Log(title = "Visual", businessType = BusinessType.INSERT)
    @Operation(summary = "新增Visual")
    @PostMapping
    public AjaxResult add(@RequestBody Visual visual)
    {
        return toAjax(visualService.insertVisual(visual));
    }

    @PreAuthorize("@ss.hasPermi('visual:edit')")
    @Log(title = "Visual", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改Visual")
    @PutMapping
    public AjaxResult edit(@RequestBody Visual visual)
    {
        return toAjax(visualService.updateVisual(visual));
    }

    @PreAuthorize("@ss.hasPermi('visual:del')")
    @Log(title = "Visual", businessType = BusinessType.DELETE)
    @Operation(summary = "删除Visual")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(visualService.deleteVisualByIds(ids));
    }

}
