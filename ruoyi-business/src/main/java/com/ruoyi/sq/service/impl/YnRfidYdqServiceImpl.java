package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnRfidYdq;
import com.ruoyi.sq.mapper.YnRfidYdqMapper;
import com.ruoyi.sq.service.IYnRfidYdqService;

/**
 * YnRfidYdqService业务层处理
 */
@Service
public class YnRfidYdqServiceImpl implements IYnRfidYdqService
{
    @Autowired
    private YnRfidYdqMapper ynRfidYdqMapper;

    @Override
    public YnRfidYdq selectYnRfidYdqById(Integer id)
    {
        return ynRfidYdqMapper.selectYnRfidYdqById(id);
    }

    @Override
    public List<YnRfidYdq> selectYnRfidYdqList(YnRfidYdq ynRfidYdq)
    {
        return ynRfidYdqMapper.selectYnRfidYdqList(ynRfidYdq);
    }

    @Override
    public int insertYnRfidYdq(YnRfidYdq ynRfidYdq)
    {
        ynRfidYdq.setCreateTime(Timestamp.from(Instant.now()));
        return ynRfidYdqMapper.insertYnRfidYdq(ynRfidYdq);
    }

    @Override
    public int updateYnRfidYdq(YnRfidYdq ynRfidYdq)
    {
        // 无通用更新字段
        return ynRfidYdqMapper.updateYnRfidYdq(ynRfidYdq);
    }

    @Override
    public int deleteYnRfidYdqByIds(Integer[] ids)
    {
        return ynRfidYdqMapper.deleteYnRfidYdqByIds(ids);
    }

    @Override
    public int deleteYnRfidYdqById(Integer id)
    {
        return ynRfidYdqMapper.deleteYnRfidYdqById(id);
    }
}
