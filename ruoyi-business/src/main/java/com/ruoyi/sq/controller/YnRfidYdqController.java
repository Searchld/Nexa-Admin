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
import com.ruoyi.sq.domain.YnRfidYdq;
import com.ruoyi.sq.service.IYnRfidYdqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnRfidYdqController
 */
@Tag(name = "旧系统YnRfidYdq接口")
@RestController
@RequestMapping("/api/ynRfidYdq")
public class YnRfidYdqController extends BaseController
{
    @Autowired
    private IYnRfidYdqService ynRfidYdqService;

    @PreAuthorize("@ss.hasPermi('ynRfidYdq:list')")
    @Operation(summary = "查询YnRfidYdq列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnRfidYdq ynRfidYdq)
    {
        startPage();
        List<YnRfidYdq> list = ynRfidYdqService.selectYnRfidYdqList(ynRfidYdq);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynRfidYdq:list')")
    @Log(title = "YnRfidYdq", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnRfidYdq")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnRfidYdq ynRfidYdq)
    {
        List<YnRfidYdq> list = ynRfidYdqService.selectYnRfidYdqList(ynRfidYdq);
        ExcelUtil<YnRfidYdq> util = new ExcelUtil<>(YnRfidYdq.class);
        util.exportExcel(response, list, "YnRfidYdq数据");
    }

    @PreAuthorize("@ss.hasPermi('ynRfidYdq:query')")
    @Operation(summary = "获取YnRfidYdq详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Integer id)
    {
        return success(ynRfidYdqService.selectYnRfidYdqById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynRfidYdq:add')")
    @Log(title = "YnRfidYdq", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnRfidYdq")
    @PostMapping
    public AjaxResult add(@RequestBody YnRfidYdq ynRfidYdq)
    {
        return toAjax(ynRfidYdqService.insertYnRfidYdq(ynRfidYdq));
    }

    @PreAuthorize("@ss.hasPermi('ynRfidYdq:edit')")
    @Log(title = "YnRfidYdq", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnRfidYdq")
    @PutMapping
    public AjaxResult edit(@RequestBody YnRfidYdq ynRfidYdq)
    {
        return toAjax(ynRfidYdqService.updateYnRfidYdq(ynRfidYdq));
    }

    @PreAuthorize("@ss.hasPermi('ynRfidYdq:del')")
    @Log(title = "YnRfidYdq", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnRfidYdq")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(ynRfidYdqService.deleteYnRfidYdqByIds(ids));
    }

}
