package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.Team;

/**
 * TeamService接口
 */
public interface ITeamService
{
    /** 查询Team */
    public Team selectTeamById(Long id);

    /** 查询Team列表 */
    public List<Team> selectTeamList(Team team);

    /** 新增Team */
    public int insertTeam(Team team);

    /** 修改Team */
    public int updateTeam(Team team);

    /** 批量删除Team */
    public int deleteTeamByIds(Long[] ids);

    /** 删除Team信息 */
    public int deleteTeamById(Long id);
}
