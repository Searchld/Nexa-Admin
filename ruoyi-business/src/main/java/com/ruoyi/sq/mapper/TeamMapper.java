package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.Team;

/**
 * TeamMapper接口
 */
public interface TeamMapper
{
    /**
     * 查询Team
     *
     * @param id 主键
     * @return Team
     */
    public Team selectTeamById(Long id);

    /**
     * 查询Team列表
     *
     * @param team 查询条件
     * @return Team集合
     */
    public List<Team> selectTeamList(Team team);

    /**
     * 新增Team
     *
     * @param team Team
     * @return 结果
     */
    public int insertTeam(Team team);

    /**
     * 修改Team
     *
     * @param team Team
     * @return 结果
     */
    public int updateTeam(Team team);

    /**
     * 删除Team
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteTeamById(Long id);

    /**
     * 批量删除Team
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeamByIds(Long[] ids);
}
