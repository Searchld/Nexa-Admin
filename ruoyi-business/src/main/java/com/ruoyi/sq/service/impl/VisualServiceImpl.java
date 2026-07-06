package com.ruoyi.sq.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.Visual;
import com.ruoyi.sq.mapper.VisualMapper;
import com.ruoyi.sq.service.IVisualService;

/**
 * VisualService业务层处理
 */
@Service
public class VisualServiceImpl implements IVisualService
{
    @Autowired
    private VisualMapper visualMapper;

    @Override
    public Visual selectVisualById(Long id)
    {
        return visualMapper.selectVisualById(id);
    }

    @Override
    public List<Visual> selectVisualList(Visual visual)
    {
        return visualMapper.selectVisualList(visual);
    }

    @Override
    public int insertVisual(Visual visual)
    {
        // 无通用创建字段
        return visualMapper.insertVisual(visual);
    }

    @Override
    public int updateVisual(Visual visual)
    {
        // 无通用更新字段
        return visualMapper.updateVisual(visual);
    }

    @Override
    public int deleteVisualByIds(Long[] ids)
    {
        return visualMapper.deleteVisualByIds(ids);
    }

    @Override
    public int deleteVisualById(Long id)
    {
        return visualMapper.deleteVisualById(id);
    }
}
