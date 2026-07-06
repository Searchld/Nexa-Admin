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
import com.ruoyi.sq.domain.YnWxSend;
import com.ruoyi.sq.service.IYnWxSendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnWxSendController
 */
@Tag(name = "旧系统YnWxSend接口")
@RestController
@RequestMapping("/api/ynWxSend")
public class YnWxSendController extends BaseController
{
    @Autowired
    private IYnWxSendService ynWxSendService;

    @PreAuthorize("@ss.hasPermi('ynWxSend:list')")
    @Operation(summary = "查询YnWxSend列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnWxSend ynWxSend)
    {
        startPage();
        List<YnWxSend> list = ynWxSendService.selectYnWxSendList(ynWxSend);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynWxSend:list')")
    @Log(title = "YnWxSend", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnWxSend")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnWxSend ynWxSend)
    {
        List<YnWxSend> list = ynWxSendService.selectYnWxSendList(ynWxSend);
        ExcelUtil<YnWxSend> util = new ExcelUtil<>(YnWxSend.class);
        util.exportExcel(response, list, "YnWxSend数据");
    }

    @PreAuthorize("@ss.hasPermi('ynWxSend:query')")
    @Operation(summary = "获取YnWxSend详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(ynWxSendService.selectYnWxSendById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynWxSend:add')")
    @Log(title = "YnWxSend", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnWxSend")
    @PostMapping
    public AjaxResult add(@RequestBody YnWxSend ynWxSend)
    {
        return toAjax(ynWxSendService.insertYnWxSend(ynWxSend));
    }

    @PreAuthorize("@ss.hasPermi('ynWxSend:edit')")
    @Log(title = "YnWxSend", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnWxSend")
    @PutMapping
    public AjaxResult edit(@RequestBody YnWxSend ynWxSend)
    {
        return toAjax(ynWxSendService.updateYnWxSend(ynWxSend));
    }

    @PreAuthorize("@ss.hasPermi('ynWxSend:del')")
    @Log(title = "YnWxSend", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnWxSend")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ynWxSendService.deleteYnWxSendByIds(ids));
    }

}
