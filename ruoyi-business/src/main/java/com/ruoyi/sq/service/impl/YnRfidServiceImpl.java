package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnRfid;
import com.ruoyi.sq.mapper.YnRfidMapper;
import com.ruoyi.sq.service.IYnRfidService;

/**
 * YnRfidService业务层处理
 */
@Service
public class YnRfidServiceImpl implements IYnRfidService
{
    @Autowired
    private YnRfidMapper ynRfidMapper;

    @Override
    public YnRfid selectYnRfidById(Integer id)
    {
        return ynRfidMapper.selectYnRfidById(id);
    }

    @Override
    public List<YnRfid> selectYnRfidList(YnRfid ynRfid)
    {
        return ynRfidMapper.selectYnRfidList(ynRfid);
    }

    @Override
    public int insertYnRfid(YnRfid ynRfid)
    {
        ynRfid.setCreateTime(Timestamp.from(Instant.now()));
        return ynRfidMapper.insertYnRfid(ynRfid);
    }

    @Override
    public int updateYnRfid(YnRfid ynRfid)
    {
        // 无通用更新字段
        return ynRfidMapper.updateYnRfid(ynRfid);
    }

    @Override
    public int deleteYnRfidByIds(Integer[] ids)
    {
        return ynRfidMapper.deleteYnRfidByIds(ids);
    }

    @Override
    public int deleteYnRfidById(Integer id)
    {
        return ynRfidMapper.deleteYnRfidById(id);
    }
}
