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
import com.ruoyi.sq.domain.Cars;
import com.ruoyi.sq.service.ICarsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * CarsController
 */
@Tag(name = "旧系统Cars接口")
@RestController
@RequestMapping("/api/cars")
public class CarsController extends BaseController
{
    @Autowired
    private ICarsService carsService;

    @PreAuthorize("@ss.hasPermi('cars:list')")
    @Operation(summary = "查询Cars列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(Cars cars)
    {
        startPage();
        List<Cars> list = carsService.selectCarsList(cars);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('cars:list')")
    @Log(title = "Cars", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出Cars")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, Cars cars)
    {
        List<Cars> list = carsService.selectCarsList(cars);
        ExcelUtil<Cars> util = new ExcelUtil<>(Cars.class);
        util.exportExcel(response, list, "Cars数据");
    }

    @PreAuthorize("@ss.hasPermi('cars:query')")
    @Operation(summary = "获取Cars详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(carsService.selectCarsById(id));
    }

    @PreAuthorize("@ss.hasPermi('cars:add')")
    @Log(title = "Cars", businessType = BusinessType.INSERT)
    @Operation(summary = "新增Cars")
    @PostMapping
    public AjaxResult add(@RequestBody Cars cars)
    {
        return toAjax(carsService.insertCars(cars));
    }

    @PreAuthorize("@ss.hasPermi('cars:edit')")
    @Log(title = "Cars", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改Cars")
    @PutMapping
    public AjaxResult edit(@RequestBody Cars cars)
    {
        return toAjax(carsService.updateCars(cars));
    }

    @PreAuthorize("@ss.hasPermi('cars:del')")
    @Log(title = "Cars", businessType = BusinessType.DELETE)
    @Operation(summary = "删除Cars")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carsService.deleteCarsByIds(ids));
    }

}
