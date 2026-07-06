package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.YnWxSend;
import com.ruoyi.sq.mapper.YnWxSendMapper;
import com.ruoyi.sq.service.IYnWxSendService;

/**
 * YnWxSendService业务层处理
 */
@Service
public class YnWxSendServiceImpl implements IYnWxSendService
{
    @Autowired
    private YnWxSendMapper ynWxSendMapper;

    @Override
    public YnWxSend selectYnWxSendById(Long id)
    {
        return ynWxSendMapper.selectYnWxSendById(id);
    }

    @Override
    public List<YnWxSend> selectYnWxSendList(YnWxSend ynWxSend)
    {
        return ynWxSendMapper.selectYnWxSendList(ynWxSend);
    }

    @Override
    public int insertYnWxSend(YnWxSend ynWxSend)
    {
        ynWxSend.setCreateTime(Timestamp.from(Instant.now()));
        ynWxSend.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return ynWxSendMapper.insertYnWxSend(ynWxSend);
    }

    @Override
    public int updateYnWxSend(YnWxSend ynWxSend)
    {
        ynWxSend.setUpdateTime(Timestamp.from(Instant.now()));
        ynWxSend.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return ynWxSendMapper.updateYnWxSend(ynWxSend);
    }

    @Override
    public int deleteYnWxSendByIds(Long[] ids)
    {
        return ynWxSendMapper.deleteYnWxSendByIds(ids);
    }

    @Override
    public int deleteYnWxSendById(Long id)
    {
        return ynWxSendMapper.deleteYnWxSendById(id);
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
