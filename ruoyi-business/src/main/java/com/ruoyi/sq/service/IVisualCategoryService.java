package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.VisualCategory;

/**
 * VisualCategoryService接口
 */
public interface IVisualCategoryService
{
    /** 查询VisualCategory */
    public VisualCategory selectVisualCategoryById(Long id);

    /** 查询VisualCategory列表 */
    public List<VisualCategory> selectVisualCategoryList(VisualCategory visualCategory);

    /** 新增VisualCategory */
    public int insertVisualCategory(VisualCategory visualCategory);

    /** 修改VisualCategory */
    public int updateVisualCategory(VisualCategory visualCategory);

    /** 批量删除VisualCategory */
    public int deleteVisualCategoryByIds(Long[] ids);

    /** 删除VisualCategory信息 */
    public int deleteVisualCategoryById(Long id);
}
