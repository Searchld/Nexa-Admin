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
import com.ruoyi.sq.domain.YnWxUser;
import com.ruoyi.sq.service.IYnWxUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnWxUserController
 */
@Tag(name = "旧系统YnWxUser接口")
@RestController
@RequestMapping("/api/ynWxUser")
public class YnWxUserController extends BaseController
{
    @Autowired
    private IYnWxUserService ynWxUserService;

    @PreAuthorize("@ss.hasPermi('ynWxUser:list')")
    @Operation(summary = "查询YnWxUser列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnWxUser ynWxUser)
    {
        startPage();
        List<YnWxUser> list = ynWxUserService.selectYnWxUserList(ynWxUser);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynWxUser:list')")
    @Log(title = "YnWxUser", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnWxUser")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnWxUser ynWxUser)
    {
        List<YnWxUser> list = ynWxUserService.selectYnWxUserList(ynWxUser);
        ExcelUtil<YnWxUser> util = new ExcelUtil<>(YnWxUser.class);
        util.exportExcel(response, list, "YnWxUser数据");
    }

    @PreAuthorize("@ss.hasPermi('ynWxUser:query')")
    @Operation(summary = "获取YnWxUser详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(ynWxUserService.selectYnWxUserById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynWxUser:add')")
    @Log(title = "YnWxUser", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnWxUser")
    @PostMapping
    public AjaxResult add(@RequestBody YnWxUser ynWxUser)
    {
        return toAjax(ynWxUserService.insertYnWxUser(ynWxUser));
    }

    @PreAuthorize("@ss.hasPermi('ynWxUser:edit')")
    @Log(title = "YnWxUser", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnWxUser")
    @PutMapping
    public AjaxResult edit(@RequestBody YnWxUser ynWxUser)
    {
        return toAjax(ynWxUserService.updateYnWxUser(ynWxUser));
    }

    @PreAuthorize("@ss.hasPermi('ynWxUser:del')")
    @Log(title = "YnWxUser", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnWxUser")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ynWxUserService.deleteYnWxUserByIds(ids));
    }

}
