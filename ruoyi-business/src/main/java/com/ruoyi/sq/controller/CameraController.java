package com.ruoyi.sq.controller;

import java.util.Map;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "旧系统camera接口")
@RestController
@RequestMapping("/api/camera")
public class CameraController extends SqBaseController
{
    private static final String ENTITY = "camera";

    @PreAuthorize("@ss.hasPermi('camera:list')")
    @Operation(summary = "查询列表")
    @GetMapping
    public TableDataInfo list(@RequestParam Map<String, Object> params)
    {
        return listEntity(ENTITY, params);
    }

    @PreAuthorize("@ss.hasPermi('camera:list')")
    @Log(title = "旧系统数据导出", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出数据")
    @GetMapping("/download")
    public void download(HttpServletResponse response, @RequestParam Map<String, Object> params)
    {
        exportEntity(response, ENTITY, params);
    }

    @PreAuthorize("@ss.hasPermi('camera:add')")
    @Log(title = "旧系统数据新增", businessType = BusinessType.INSERT)
    @Operation(summary = "新增数据")
    @PostMapping
    public AjaxResult add(@RequestBody Map<String, Object> body)
    {
        return createEntity(ENTITY, body);
    }

    @PreAuthorize("@ss.hasPermi('camera:edit')")
    @Log(title = "旧系统数据修改", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改数据")
    @PutMapping
    public AjaxResult edit(@RequestBody Map<String, Object> body)
    {
        return updateEntity(ENTITY, body);
    }

    @PreAuthorize("@ss.hasPermi('camera:del')")
    @Log(title = "旧系统数据删除", businessType = BusinessType.DELETE)
    @Operation(summary = "删除数据")
    @DeleteMapping
    public AjaxResult remove(@RequestBody Object[] ids)
    {
        return deleteEntity(ENTITY, ids);
    }

    @Operation(summary = "旧系统兼容接口 POST /safe/area")
    @PostMapping("/safe/area")
    public AjaxResult post1_safe_area(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "safe_area", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /safe/area/img")
    @GetMapping("/safe/area/img")
    public AjaxResult get2_safe_area_img(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "safe_area_img", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 GET /list")
    @GetMapping("/list")
    public AjaxResult get3_list(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "list", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 POST /editheight")
    @PostMapping("/editheight")
    public AjaxResult post4_editheight(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "editheight", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 PUT /update")
    @PutMapping("/update")
    public AjaxResult put5_update(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "update", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 POST /view")
    @PostMapping("/view")
    public AjaxResult post6_view(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "view", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 POST /crlist")
    @PostMapping("/crlist")
    public AjaxResult post7_crlist(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "crlist", params, body, pathVars);
    }

    @Operation(summary = "旧系统兼容接口 PUT /upcrbyid")
    @PutMapping("/upcrbyid")
    public AjaxResult put8_upcrbyid(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "upcrbyid", params, body, pathVars);
    }

}
