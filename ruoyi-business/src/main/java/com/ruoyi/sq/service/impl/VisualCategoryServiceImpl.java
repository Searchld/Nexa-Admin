package com.ruoyi.sq.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.VisualCategory;
import com.ruoyi.sq.mapper.VisualCategoryMapper;
import com.ruoyi.sq.service.IVisualCategoryService;

/**
 * VisualCategoryService业务层处理
 */
@Service
public class VisualCategoryServiceImpl implements IVisualCategoryService
{
    @Autowired
    private VisualCategoryMapper visualCategoryMapper;

    @Override
    public VisualCategory selectVisualCategoryById(Long id)
    {
        return visualCategoryMapper.selectVisualCategoryById(id);
    }

    @Override
    public List<VisualCategory> selectVisualCategoryList(VisualCategory visualCategory)
    {
        return visualCategoryMapper.selectVisualCategoryList(visualCategory);
    }

    @Override
    public int insertVisualCategory(VisualCategory visualCategory)
    {
        visualCategory.setIsDeleted(0);
        return visualCategoryMapper.insertVisualCategory(visualCategory);
    }

    @Override
    public int updateVisualCategory(VisualCategory visualCategory)
    {
        // 无通用更新字段
        return visualCategoryMapper.updateVisualCategory(visualCategory);
    }

    @Override
    public int deleteVisualCategoryByIds(Long[] ids)
    {
        return visualCategoryMapper.deleteVisualCategoryByIds(ids);
    }

    @Override
    public int deleteVisualCategoryById(Long id)
    {
        return visualCategoryMapper.deleteVisualCategoryById(id);
    }
}
