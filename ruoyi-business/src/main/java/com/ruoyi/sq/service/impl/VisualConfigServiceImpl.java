package com.ruoyi.sq.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.VisualConfig;
import com.ruoyi.sq.mapper.VisualConfigMapper;
import com.ruoyi.sq.service.IVisualConfigService;

/**
 * VisualConfigService业务层处理
 */
@Service
public class VisualConfigServiceImpl implements IVisualConfigService
{
    @Autowired
    private VisualConfigMapper visualConfigMapper;

    @Override
    public VisualConfig selectVisualConfigById(Long id)
    {
        return visualConfigMapper.selectVisualConfigById(id);
    }

    @Override
    public List<VisualConfig> selectVisualConfigList(VisualConfig visualConfig)
    {
        return visualConfigMapper.selectVisualConfigList(visualConfig);
    }

    @Override
    public int insertVisualConfig(VisualConfig visualConfig)
    {
        // 无通用创建字段
        return visualConfigMapper.insertVisualConfig(visualConfig);
    }

    @Override
    public int updateVisualConfig(VisualConfig visualConfig)
    {
        // 无通用更新字段
        return visualConfigMapper.updateVisualConfig(visualConfig);
    }

    @Override
    public int deleteVisualConfigByIds(Long[] ids)
    {
        return visualConfigMapper.deleteVisualConfigByIds(ids);
    }

    @Override
    public int deleteVisualConfigById(Long id)
    {
        return visualConfigMapper.deleteVisualConfigById(id);
    }
}
