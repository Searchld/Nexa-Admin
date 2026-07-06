package com.ruoyi.sq.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sq.domain.AddStream;
import com.ruoyi.sq.service.IAddStreamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 旧系统视频流接口
 */
@Tag(name = "旧系统stream接口")
@RestController
@RequestMapping("/api/stream")
public class StreamController extends BaseController
{
    @Autowired
    private IAddStreamService addStreamService;

    @PreAuthorize("@ss.hasPermi('stream:list')")
    @Operation(summary = "查询视频流列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(AddStream addStream)
    {
        startPage();
        List<AddStream> list = addStreamService.selectAddStreamList(addStream);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('stream:del')")
    @Log(title = "视频流", businessType = BusinessType.DELETE)
    @Operation(summary = "删除视频流")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(addStreamService.deleteAddStreamByIds(ids));
    }
}
