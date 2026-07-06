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
import com.ruoyi.sq.domain.Camera;
import com.ruoyi.sq.service.ICameraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * CameraController
 */
@Tag(name = "旧系统Camera接口")
@RestController
@RequestMapping("/api/camera")
public class CameraController extends BaseController
{
    @Autowired
    private ICameraService cameraService;

    @PreAuthorize("@ss.hasPermi('camera:list')")
    @Operation(summary = "查询Camera列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(Camera camera)
    {
        startPage();
        List<Camera> list = cameraService.selectCameraList(camera);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('camera:list')")
    @Log(title = "Camera", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出Camera")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, Camera camera)
    {
        List<Camera> list = cameraService.selectCameraList(camera);
        ExcelUtil<Camera> util = new ExcelUtil<>(Camera.class);
        util.exportExcel(response, list, "Camera数据");
    }

    @PreAuthorize("@ss.hasPermi('camera:query')")
    @Operation(summary = "获取Camera详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(cameraService.selectCameraById(id));
    }

    @PreAuthorize("@ss.hasPermi('camera:add')")
    @Log(title = "Camera", businessType = BusinessType.INSERT)
    @Operation(summary = "新增Camera")
    @PostMapping
    public AjaxResult add(@RequestBody Camera camera)
    {
        return toAjax(cameraService.insertCamera(camera));
    }

    @PreAuthorize("@ss.hasPermi('camera:edit')")
    @Log(title = "Camera", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改Camera")
    @PutMapping
    public AjaxResult edit(@RequestBody Camera camera)
    {
        return toAjax(cameraService.updateCamera(camera));
    }

    @PreAuthorize("@ss.hasPermi('camera:del')")
    @Log(title = "Camera", businessType = BusinessType.DELETE)
    @Operation(summary = "删除Camera")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cameraService.deleteCameraByIds(ids));
    }

}
