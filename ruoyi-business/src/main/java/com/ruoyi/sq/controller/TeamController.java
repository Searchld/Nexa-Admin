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
import com.ruoyi.sq.domain.Team;
import com.ruoyi.sq.service.ITeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * TeamController
 */
@Tag(name = "旧系统Team接口")
@RestController
@RequestMapping("/api/team")
public class TeamController extends BaseController
{
    @Autowired
    private ITeamService teamService;

    @PreAuthorize("@ss.hasPermi('team:list')")
    @Operation(summary = "查询Team列表")
    @GetMapping({"", "/list"})
    public TableDataInfo list(Team team)
    {
        startPage();
        List<Team> list = teamService.selectTeamList(team);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('team:list')")
    @Log(title = "Team", businessType = BusinessType.EXPORT)
    @Operation(summary = "导出Team")
    @PostMapping({"/export", "/download"})
    public void export(HttpServletResponse response, Team team)
    {
        List<Team> list = teamService.selectTeamList(team);
        ExcelUtil<Team> util = new ExcelUtil<>(Team.class);
        util.exportExcel(response, list, "Team数据");
    }

    @PreAuthorize("@ss.hasPermi('team:query')")
    @Operation(summary = "获取Team详情")
    @GetMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id)
    {
        return success(teamService.selectTeamById(id));
    }

    @PreAuthorize("@ss.hasPermi('team:add')")
    @Log(title = "Team", businessType = BusinessType.INSERT)
    @Operation(summary = "新增Team")
    @PostMapping
    public AjaxResult add(@RequestBody Team team)
    {
        return toAjax(teamService.insertTeam(team));
    }

    @PreAuthorize("@ss.hasPermi('team:edit')")
    @Log(title = "Team", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改Team")
    @PutMapping
    public AjaxResult edit(@RequestBody Team team)
    {
        return toAjax(teamService.updateTeam(team));
    }

    @PreAuthorize("@ss.hasPermi('team:del')")
    @Log(title = "Team", businessType = BusinessType.DELETE)
    @Operation(summary = "删除Team")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teamService.deleteTeamByIds(ids));
    }

}
