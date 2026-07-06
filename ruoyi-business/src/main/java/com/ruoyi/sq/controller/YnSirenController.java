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

@Tag(name = "旧系统ynSiren接口")
@RestController
@RequestMapping("/api/ynSiren")
public class YnSirenController extends SqBaseController
{
    private static final String ENTITY = "ynSiren";

    @PreAuthorize("@ss.hasPermi('ynSiren:list')")
    @Operation(summary = "查询列表")
    @GetMapping
    public TableDataInfo list(@RequestParam Map<String, Object> params)
    {
        return listEntity(ENTITY, params);
    }

    @PreAuthorize("@ss.hasPermi('ynSiren:list')")
    @Log(title = "旧系统数据导出", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出数据")
    @GetMapping("/download")
    public void download(HttpServletResponse response, @RequestParam Map<String, Object> params)
    {
        exportEntity(response, ENTITY, params);
    }

    @PreAuthorize("@ss.hasPermi('ynSiren:add')")
    @Log(title = "旧系统数据新增", businessType = BusinessType.INSERT)
    @Operation(summary = "新增数据")
    @PostMapping
    public AjaxResult add(@RequestBody Map<String, Object> body)
    {
        return createEntity(ENTITY, body);
    }

    @PreAuthorize("@ss.hasPermi('ynSiren:edit')")
    @Log(title = "旧系统数据修改", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改数据")
    @PutMapping
    public AjaxResult edit(@RequestBody Map<String, Object> body)
    {
        return updateEntity(ENTITY, body);
    }

    @PreAuthorize("@ss.hasPermi('ynSiren:del')")
    @Log(title = "旧系统数据删除", businessType = BusinessType.DELETE)
    @Operation(summary = "删除数据")
    @DeleteMapping
    public AjaxResult remove(@RequestBody Object[] ids)
    {
        return deleteEntity(ENTITY, ids);
    }

    @Anonymous
    @Operation(summary = "旧系统兼容接口 GET /str")
    @GetMapping("/str")
    public AjaxResult get1_str(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "str", params, body, pathVars);
    }

    @Anonymous
    @Operation(summary = "旧系统兼容接口 GET /send/message")
    @GetMapping("/send/message")
    public AjaxResult get2_send_message(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "send_message", params, body, pathVars);
    }

}
