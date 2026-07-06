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

@Tag(name = "旧系统visual接口")
@RestController
@RequestMapping("/data4j/visual")
public class VisualController extends SqBaseController
{
    private static final String ENTITY = "visual";

    @Operation(summary = "旧系统兼容接口 GET /detail")
    @GetMapping("/detail")
    public AjaxResult get1_detail(@PathVariable(required = false) Map<String, String> pathVars, @RequestParam(required = false) Map<String, Object> params, @RequestBody(required = false) Map<String, Object> body)
    {
        return specialEntity(ENTITY, "detail", params, body, pathVars);
    }

}
