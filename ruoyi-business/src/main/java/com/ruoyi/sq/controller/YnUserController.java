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
import com.ruoyi.sq.domain.YnUser;
import com.ruoyi.sq.service.IYnUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * YnUserController
 */
@Tag(name = "旧系统YnUser接口")
@RestController
@RequestMapping("/api/ynUser")
public class YnUserController extends BaseController
{
    @Autowired
    private IYnUserService ynUserService;

    @PreAuthorize("@ss.hasPermi('ynUser:list')")
    @Operation(summary = "查询YnUser列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(YnUser ynUser)
    {
        startPage();
        List<YnUser> list = ynUserService.selectYnUserList(ynUser);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('ynUser:list')")
    @Log(title = "YnUser", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出YnUser")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, YnUser ynUser)
    {
        List<YnUser> list = ynUserService.selectYnUserList(ynUser);
        ExcelUtil<YnUser> util = new ExcelUtil<>(YnUser.class);
        util.exportExcel(response, list, "YnUser数据");
    }

    @PreAuthorize("@ss.hasPermi('ynUser:query')")
    @Operation(summary = "获取YnUser详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(ynUserService.selectYnUserById(id));
    }

    @PreAuthorize("@ss.hasPermi('ynUser:add')")
    @Log(title = "YnUser", businessType = BusinessType.INSERT)
    @Operation(summary = "新增YnUser")
    @PostMapping
    public AjaxResult add(@RequestBody YnUser ynUser)
    {
        return toAjax(ynUserService.insertYnUser(ynUser));
    }

    @PreAuthorize("@ss.hasPermi('ynUser:edit')")
    @Log(title = "YnUser", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改YnUser")
    @PutMapping
    public AjaxResult edit(@RequestBody YnUser ynUser)
    {
        return toAjax(ynUserService.updateYnUser(ynUser));
    }

    @PreAuthorize("@ss.hasPermi('ynUser:del')")
    @Log(title = "YnUser", businessType = BusinessType.DELETE)
    @Operation(summary = "删除YnUser")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ynUserService.deleteYnUserByIds(ids));
    }

}
