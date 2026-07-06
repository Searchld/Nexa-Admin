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
import com.ruoyi.sq.domain.YnRfid;
import com.ruoyi.sq.service.IYnRfidService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnRfidController
 */
@Tag(name = "旧系统YnRfid接口")
@RestController
@RequestMapping("/api/ynRfid")
public class YnRfidController extends BaseController
{
    @Autowired
    private IYnRfidService ynRfidService;

    @PreAuthorize("@ss.hasPermi('ynRfid:list')")
    @Operation(summary = "查询YnRfid列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnRfid ynRfid)
    {
        startPage();
        List<YnRfid> list = ynRfidService.selectYnRfidList(ynRfid);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynRfid:list')")
    @Log(title = "YnRfid", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnRfid")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnRfid ynRfid)
    {
        List<YnRfid> list = ynRfidService.selectYnRfidList(ynRfid);
        ExcelUtil<YnRfid> util = new ExcelUtil<>(YnRfid.class);
        util.exportExcel(response, list, "YnRfid数据");
    }

    @PreAuthorize("@ss.hasPermi('ynRfid:query')")
    @Operation(summary = "获取YnRfid详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Integer id)
    {
        return success(ynRfidService.selectYnRfidById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynRfid:add')")
    @Log(title = "YnRfid", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnRfid")
    @PostMapping
    public AjaxResult add(@RequestBody YnRfid ynRfid)
    {
        return toAjax(ynRfidService.insertYnRfid(ynRfid));
    }

    @PreAuthorize("@ss.hasPermi('ynRfid:edit')")
    @Log(title = "YnRfid", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnRfid")
    @PutMapping
    public AjaxResult edit(@RequestBody YnRfid ynRfid)
    {
        return toAjax(ynRfidService.updateYnRfid(ynRfid));
    }

    @PreAuthorize("@ss.hasPermi('ynRfid:del')")
    @Log(title = "YnRfid", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnRfid")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(ynRfidService.deleteYnRfidByIds(ids));
    }

}
