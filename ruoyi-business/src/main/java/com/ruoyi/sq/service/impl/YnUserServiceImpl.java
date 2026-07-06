package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnUser;
import com.ruoyi.sq.mapper.YnUserMapper;
import com.ruoyi.sq.service.IYnUserService;

/**
 * YnUserService业务层处理
 */
@Service
public class YnUserServiceImpl implements IYnUserService
{
    @Autowired
    private YnUserMapper ynUserMapper;

    @Override
    public YnUser selectYnUserById(Long id)
    {
        return ynUserMapper.selectYnUserById(id);
    }

    @Override
    public List<YnUser> selectYnUserList(YnUser ynUser)
    {
        return ynUserMapper.selectYnUserList(ynUser);
    }

    @Override
    public int insertYnUser(YnUser ynUser)
    {
        ynUser.setCreateTime(Timestamp.from(Instant.now()));
        return ynUserMapper.insertYnUser(ynUser);
    }

    @Override
    public int updateYnUser(YnUser ynUser)
    {
        // 无通用更新字段
        return ynUserMapper.updateYnUser(ynUser);
    }

    @Override
    public int deleteYnUserByIds(Long[] ids)
    {
        return ynUserMapper.deleteYnUserByIds(ids);
    }

    @Override
    public int deleteYnUserById(Long id)
    {
        return ynUserMapper.deleteYnUserById(id);
    }
}
