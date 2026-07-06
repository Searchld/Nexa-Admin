package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.Team;
import com.ruoyi.sq.mapper.TeamMapper;
import com.ruoyi.sq.service.ITeamService;

/**
 * TeamService业务层处理
 */
@Service
public class TeamServiceImpl implements ITeamService
{
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public Team selectTeamById(Long id)
    {
        return teamMapper.selectTeamById(id);
    }

    @Override
    public List<Team> selectTeamList(Team team)
    {
        return teamMapper.selectTeamList(team);
    }

    @Override
    public int insertTeam(Team team)
    {
        team.setCreateTime(Timestamp.from(Instant.now()));
        team.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        team.setIsDeleted("0");
        return teamMapper.insertTeam(team);
    }

    @Override
    public int updateTeam(Team team)
    {
        team.setUpdateTime(Timestamp.from(Instant.now()));
        team.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return teamMapper.updateTeam(team);
    }

    @Override
    public int deleteTeamByIds(Long[] ids)
    {
        return teamMapper.deleteTeamByIds(ids);
    }

    @Override
    public int deleteTeamById(Long id)
    {
        return teamMapper.deleteTeamById(id);
    }

    private Long getUserId()
    {
        try
        {
            return SecurityUtils.getUserId();
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
