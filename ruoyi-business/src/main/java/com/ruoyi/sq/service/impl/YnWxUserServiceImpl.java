package com.ruoyi.sq.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnWxUser;
import com.ruoyi.sq.mapper.YnWxUserMapper;
import com.ruoyi.sq.service.IYnWxUserService;

/**
 * YnWxUserService业务层处理
 */
@Service
public class YnWxUserServiceImpl implements IYnWxUserService
{
    @Autowired
    private YnWxUserMapper ynWxUserMapper;

    @Override
    public YnWxUser selectYnWxUserById(Long id)
    {
        return ynWxUserMapper.selectYnWxUserById(id);
    }

    @Override
    public List<YnWxUser> selectYnWxUserList(YnWxUser ynWxUser)
    {
        return ynWxUserMapper.selectYnWxUserList(ynWxUser);
    }

    @Override
    public int insertYnWxUser(YnWxUser ynWxUser)
    {
        // 无通用创建字段
        return ynWxUserMapper.insertYnWxUser(ynWxUser);
    }

    @Override
    public int updateYnWxUser(YnWxUser ynWxUser)
    {
        // 无通用更新字段
        return ynWxUserMapper.updateYnWxUser(ynWxUser);
    }

    @Override
    public int deleteYnWxUserByIds(Long[] ids)
    {
        return ynWxUserMapper.deleteYnWxUserByIds(ids);
    }

    @Override
    public int deleteYnWxUserById(Long id)
    {
        return ynWxUserMapper.deleteYnWxUserById(id);
    }
}
