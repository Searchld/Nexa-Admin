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
import com.ruoyi.sq.domain.YnLogsLevel;
import com.ruoyi.sq.service.IYnLogsLevelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnLogsLevelController
 */
@Tag(name = "旧系统YnLogsLevel接口")
@RestController
@RequestMapping("/api/ynLogsLevel")
public class YnLogsLevelController extends BaseController
{
    @Autowired
    private IYnLogsLevelService ynLogsLevelService;

    @PreAuthorize("@ss.hasPermi('ynLogsLevel:list')")
    @Operation(summary = "查询YnLogsLevel列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnLogsLevel ynLogsLevel)
    {
        startPage();
        List<YnLogsLevel> list = ynLogsLevelService.selectYnLogsLevelList(ynLogsLevel);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynLogsLevel:list')")
    @Log(title = "YnLogsLevel", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnLogsLevel")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnLogsLevel ynLogsLevel)
    {
        List<YnLogsLevel> list = ynLogsLevelService.selectYnLogsLevelList(ynLogsLevel);
        ExcelUtil<YnLogsLevel> util = new ExcelUtil<>(YnLogsLevel.class);
        util.exportExcel(response, list, "YnLogsLevel数据");
    }

    @PreAuthorize("@ss.hasPermi('ynLogsLevel:query')")
    @Operation(summary = "获取YnLogsLevel详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Integer id)
    {
        return success(ynLogsLevelService.selectYnLogsLevelById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynLogsLevel:add')")
    @Log(title = "YnLogsLevel", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnLogsLevel")
    @PostMapping
    public AjaxResult add(@RequestBody YnLogsLevel ynLogsLevel)
    {
        return toAjax(ynLogsLevelService.insertYnLogsLevel(ynLogsLevel));
    }

    @PreAuthorize("@ss.hasPermi('ynLogsLevel:edit')")
    @Log(title = "YnLogsLevel", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnLogsLevel")
    @PutMapping
    public AjaxResult edit(@RequestBody YnLogsLevel ynLogsLevel)
    {
        return toAjax(ynLogsLevelService.updateYnLogsLevel(ynLogsLevel));
    }

    @PreAuthorize("@ss.hasPermi('ynLogsLevel:del')")
    @Log(title = "YnLogsLevel", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnLogsLevel")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(ynLogsLevelService.deleteYnLogsLevelByIds(ids));
    }

}
