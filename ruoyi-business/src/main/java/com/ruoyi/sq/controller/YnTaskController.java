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
import com.ruoyi.sq.domain.YnTask;
import com.ruoyi.sq.service.IYnTaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnTaskController
 */
@Tag(name = "旧系统YnTask接口")
@RestController
@RequestMapping("/api/ynTask")
public class YnTaskController extends BaseController
{
    @Autowired
    private IYnTaskService ynTaskService;

    @PreAuthorize("@ss.hasPermi('ynTask:list')")
    @Operation(summary = "查询YnTask列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnTask ynTask)
    {
        startPage();
        List<YnTask> list = ynTaskService.selectYnTaskList(ynTask);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynTask:list')")
    @Log(title = "YnTask", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnTask")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnTask ynTask)
    {
        List<YnTask> list = ynTaskService.selectYnTaskList(ynTask);
        ExcelUtil<YnTask> util = new ExcelUtil<>(YnTask.class);
        util.exportExcel(response, list, "YnTask数据");
    }

    @PreAuthorize("@ss.hasPermi('ynTask:query')")
    @Operation(summary = "获取YnTask详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Integer id)
    {
        return success(ynTaskService.selectYnTaskById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynTask:add')")
    @Log(title = "YnTask", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnTask")
    @PostMapping
    public AjaxResult add(@RequestBody YnTask ynTask)
    {
        return toAjax(ynTaskService.insertYnTask(ynTask));
    }

    @PreAuthorize("@ss.hasPermi('ynTask:edit')")
    @Log(title = "YnTask", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnTask")
    @PutMapping
    public AjaxResult edit(@RequestBody YnTask ynTask)
    {
        return toAjax(ynTaskService.updateYnTask(ynTask));
    }

    @PreAuthorize("@ss.hasPermi('ynTask:del')")
    @Log(title = "YnTask", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnTask")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(ynTaskService.deleteYnTaskByIds(ids));
    }

}
