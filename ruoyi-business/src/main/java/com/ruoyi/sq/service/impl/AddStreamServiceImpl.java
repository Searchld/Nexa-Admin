package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.AddStream;
import com.ruoyi.sq.mapper.AddStreamMapper;
import com.ruoyi.sq.service.IAddStreamService;

/**
 * AddStreamService业务层处理
 */
@Service
public class AddStreamServiceImpl implements IAddStreamService
{
    @Autowired
    private AddStreamMapper addStreamMapper;

    @Override
    public AddStream selectAddStreamById(Long id)
    {
        return addStreamMapper.selectAddStreamById(id);
    }

    @Override
    public List<AddStream> selectAddStreamList(AddStream addStream)
    {
        return addStreamMapper.selectAddStreamList(addStream);
    }

    @Override
    public int insertAddStream(AddStream addStream)
    {
        addStream.setCreateTime(Timestamp.from(Instant.now()));
        addStream.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        addStream.setIsDeleted("0");
        return addStreamMapper.insertAddStream(addStream);
    }

    @Override
    public int updateAddStream(AddStream addStream)
    {
        addStream.setUpdateTime(Timestamp.from(Instant.now()));
        addStream.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return addStreamMapper.updateAddStream(addStream);
    }

    @Override
    public int deleteAddStreamByIds(Long[] ids)
    {
        return addStreamMapper.deleteAddStreamByIds(ids);
    }

    @Override
    public int deleteAddStreamById(Long id)
    {
        return addStreamMapper.deleteAddStreamById(id);
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
