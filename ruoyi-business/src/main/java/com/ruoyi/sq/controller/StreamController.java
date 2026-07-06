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

@Tag(name = "旧系统stream接口")
@RestController
@RequestMapping("/api/stream")
public class StreamController extends SqBaseController
{
    private static final String ENTITY = "stream";

    @PreAuthorize("@ss.hasPermi('stream:list')")
    @Operation(summary = "查询列表")
    @GetMapping
    public TableDataInfo list(@RequestParam Map<String, Object> params)
    {
        return listEntity(ENTITY, params);
    }

    @PreAuthorize("@ss.hasPermi('stream:del')")
    @Log(title = "旧系统数据删除", businessType = BusinessType.DELETE)
    @Operation(summary = "删除数据")
    @DeleteMapping
    public AjaxResult remove(@RequestBody Object[] ids)
    {
        return deleteEntity(ENTITY, ids);
    }

}
