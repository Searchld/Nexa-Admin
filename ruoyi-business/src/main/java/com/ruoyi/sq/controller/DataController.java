package com.ruoyi.sq.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.sq.domain.Camera;
import com.ruoyi.sq.service.ICameraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 旧系统大屏接口
 */
@Tag(name = "旧系统大屏接口")
@RestController
@RequestMapping("/api/data")
public class DataController extends BaseController
{
    @Autowired
    private ICameraService cameraService;

    @Anonymous
    @Operation(summary = "查询视频摄像头列表")
    @GetMapping({"/getVideo", "/camera/list"})
    public TableDataInfo cameraList(Camera camera)
    {
        camera.setIsDeleted("0");
        startPage();
        List<Camera> list = cameraService.selectCameraList(camera);
        return getDataTable(list);
    }

    @Operation(summary = "查询报警状态")
    @GetMapping({"/isAlert/{status}", "/show/alert"})
    public AjaxResult alertStatus(@PathVariable(required = false) Map<String, String> pathVars)
    {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", pathVars == null ? null : pathVars.get("status"));
        result.put("count", 0);
        return success(result);
    }

    @Anonymous
    @Operation(summary = "旧系统大屏兼容GET接口")
    @GetMapping("/{operation}")
    public AjaxResult getOperation(@PathVariable String operation, @RequestParam Map<String, Object> params)
    {
        return unsupported(operation);
    }

    @Anonymous
    @Operation(summary = "旧系统大屏兼容详情接口")
    @GetMapping("/{operation}/{id}")
    public AjaxResult getOperationById(@PathVariable String operation, @PathVariable String id,
            @RequestParam Map<String, Object> params)
    {
        return unsupported(operation);
    }

    @Anonymous
    @Operation(summary = "旧系统大屏兼容POST接口")
    @PostMapping("/{operation}")
    public AjaxResult postOperation(@PathVariable String operation, @RequestParam(required = false) Map<String, Object> params,
            @RequestBody(required = false) Map<String, Object> body)
    {
        return unsupported(operation);
    }

    private AjaxResult unsupported(String operation)
    {
        return AjaxResult.error("旧大屏接口 /api/data/" + operation + " 已保留路径，请按原业务语义补齐专用 Service 实现");
    }
}
