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
import com.ruoyi.sq.domain.YnLogsOut;
import com.ruoyi.sq.service.IYnLogsOutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnLogsOutController
 */
@Tag(name = "旧系统YnLogsOut接口")
@RestController
@RequestMapping("/api/ynLogsOut")
public class YnLogsOutController extends BaseController
{
    @Autowired
    private IYnLogsOutService ynLogsOutService;

    @PreAuthorize("@ss.hasPermi('ynLogsOut:list')")
    @Operation(summary = "查询YnLogsOut列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnLogsOut ynLogsOut)
    {
        startPage();
        List<YnLogsOut> list = ynLogsOutService.selectYnLogsOutList(ynLogsOut);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynLogsOut:list')")
    @Log(title = "YnLogsOut", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnLogsOut")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnLogsOut ynLogsOut)
    {
        List<YnLogsOut> list = ynLogsOutService.selectYnLogsOutList(ynLogsOut);
        ExcelUtil<YnLogsOut> util = new ExcelUtil<>(YnLogsOut.class);
        util.exportExcel(response, list, "YnLogsOut数据");
    }

    @PreAuthorize("@ss.hasPermi('ynLogsOut:query')")
    @Operation(summary = "获取YnLogsOut详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(ynLogsOutService.selectYnLogsOutById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynLogsOut:add')")
    @Log(title = "YnLogsOut", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnLogsOut")
    @PostMapping
    public AjaxResult add(@RequestBody YnLogsOut ynLogsOut)
    {
        return toAjax(ynLogsOutService.insertYnLogsOut(ynLogsOut));
    }

    @PreAuthorize("@ss.hasPermi('ynLogsOut:edit')")
    @Log(title = "YnLogsOut", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnLogsOut")
    @PutMapping
    public AjaxResult edit(@RequestBody YnLogsOut ynLogsOut)
    {
        return toAjax(ynLogsOutService.updateYnLogsOut(ynLogsOut));
    }

    @PreAuthorize("@ss.hasPermi('ynLogsOut:del')")
    @Log(title = "YnLogsOut", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnLogsOut")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ynLogsOutService.deleteYnLogsOutByIds(ids));
    }

}
