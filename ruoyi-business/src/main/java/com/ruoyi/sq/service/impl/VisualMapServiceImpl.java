package com.ruoyi.sq.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.VisualMap;
import com.ruoyi.sq.mapper.VisualMapMapper;
import com.ruoyi.sq.service.IVisualMapService;

/**
 * VisualMapService业务层处理
 */
@Service
public class VisualMapServiceImpl implements IVisualMapService
{
    @Autowired
    private VisualMapMapper visualMapMapper;

    @Override
    public VisualMap selectVisualMapById(Long id)
    {
        return visualMapMapper.selectVisualMapById(id);
    }

    @Override
    public List<VisualMap> selectVisualMapList(VisualMap visualMap)
    {
        return visualMapMapper.selectVisualMapList(visualMap);
    }

    @Override
    public int insertVisualMap(VisualMap visualMap)
    {
        // 无通用创建字段
        return visualMapMapper.insertVisualMap(visualMap);
    }

    @Override
    public int updateVisualMap(VisualMap visualMap)
    {
        // 无通用更新字段
        return visualMapMapper.updateVisualMap(visualMap);
    }

    @Override
    public int deleteVisualMapByIds(Long[] ids)
    {
        return visualMapMapper.deleteVisualMapByIds(ids);
    }

    @Override
    public int deleteVisualMapById(Long id)
    {
        return visualMapMapper.deleteVisualMapById(id);
    }
}
