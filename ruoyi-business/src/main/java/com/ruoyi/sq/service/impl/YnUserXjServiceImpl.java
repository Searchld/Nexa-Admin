package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnUserXj;
import com.ruoyi.sq.mapper.YnUserXjMapper;
import com.ruoyi.sq.service.IYnUserXjService;

/**
 * YnUserXjService业务层处理
 */
@Service
public class YnUserXjServiceImpl implements IYnUserXjService
{
    @Autowired
    private YnUserXjMapper ynUserXjMapper;

    @Override
    public YnUserXj selectYnUserXjById(Long id)
    {
        return ynUserXjMapper.selectYnUserXjById(id);
    }

    @Override
    public List<YnUserXj> selectYnUserXjList(YnUserXj ynUserXj)
    {
        return ynUserXjMapper.selectYnUserXjList(ynUserXj);
    }

    @Override
    public int insertYnUserXj(YnUserXj ynUserXj)
    {
        ynUserXj.setCreateTime(Timestamp.from(Instant.now()));
        return ynUserXjMapper.insertYnUserXj(ynUserXj);
    }

    @Override
    public int updateYnUserXj(YnUserXj ynUserXj)
    {
        // 无通用更新字段
        return ynUserXjMapper.updateYnUserXj(ynUserXj);
    }

    @Override
    public int deleteYnUserXjByIds(Long[] ids)
    {
        return ynUserXjMapper.deleteYnUserXjByIds(ids);
    }

    @Override
    public int deleteYnUserXjById(Long id)
    {
        return ynUserXjMapper.deleteYnUserXjById(id);
    }
}
