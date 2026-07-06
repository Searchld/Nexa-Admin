package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.VisualCategory;

/**
 * VisualCategoryMapper接口
 */
public interface VisualCategoryMapper
{
    /**
     * 查询VisualCategory
     *
     * @param id 主键
     * @return VisualCategory
     */
    public VisualCategory selectVisualCategoryById(Long id);

    /**
     * 查询VisualCategory列表
     *
     * @param visualCategory 查询条件
     * @return VisualCategory集合
     */
    public List<VisualCategory> selectVisualCategoryList(VisualCategory visualCategory);

    /**
     * 新增VisualCategory
     *
     * @param visualCategory VisualCategory
     * @return 结果
     */
    public int insertVisualCategory(VisualCategory visualCategory);

    /**
     * 修改VisualCategory
     *
     * @param visualCategory VisualCategory
     * @return 结果
     */
    public int updateVisualCategory(VisualCategory visualCategory);

    /**
     * 删除VisualCategory
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteVisualCategoryById(Long id);

    /**
     * 批量删除VisualCategory
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVisualCategoryByIds(Long[] ids);
}
