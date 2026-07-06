package com.ruoyi.sq.controller;

import java.util.List;
import java.util.Map;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.sq.service.SqCrudService;

public abstract class SqBaseController extends BaseController
{
    @Autowired
    protected SqCrudService sqCrudService;

    protected TableDataInfo listEntity(String entity, Map<String, Object> params)
    {
        startPage();
        List<?> list = sqCrudService.list(entity, params);
        return getDataTable(list);
    }

    protected AjaxResult listAllEntity(String entity, Map<String, Object> params)
    {
        return AjaxResult.success(sqCrudService.mapList(entity, params));
    }

    protected AjaxResult createEntity(String entity, Map<String, Object> body)
    {
        return AjaxResult.success(sqCrudService.create(entity, body));
    }

    protected AjaxResult updateEntity(String entity, Map<String, Object> body)
    {
        return toAjax(sqCrudService.update(entity, body));
    }

    protected AjaxResult deleteEntity(String entity, Object[] ids)
    {
        return toAjax(sqCrudService.delete(entity, ids));
    }

    protected AjaxResult specialEntity(String entity, String operation, Map<String, Object> params, Map<String, Object> body, Map<String, String> pathVars)
    {
        return AjaxResult.success(sqCrudService.special(entity, operation, params, body, pathVars));
    }

    protected void exportEntity(HttpServletResponse response, String entity, Map<String, Object> params)
    {
        try
        {
            List<Map<String, Object>> rows = sqCrudService.mapList(entity, params);
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/csv;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + entity + ".csv");
            java.io.PrintWriter writer = response.getWriter();
            if (!rows.isEmpty())
            {
                java.util.List<String> headers = new java.util.ArrayList<>(rows.get(0).keySet());
                writer.println(String.join(",", headers));
                for (Map<String, Object> row : rows)
                {
                    java.util.List<String> values = new java.util.ArrayList<>();
                    for (String header : headers)
                    {
                        Object value = row.get(header);
                        values.add(value == null ? "" : String.valueOf(value).replace(",", " "));
                    }
                    writer.println(String.join(",", values));
                }
            }
            writer.flush();
        }
        catch (Exception e)
        {
            throw new RuntimeException("导出旧系统数据失败", e);
        }
    }
}
