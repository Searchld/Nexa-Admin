package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.Visual;

/**
 * VisualMapper接口
 */
public interface VisualMapper
{
    /**
     * 查询Visual
     *
     * @param id 主键
     * @return Visual
     */
    public Visual selectVisualById(Long id);

    /**
     * 查询Visual列表
     *
     * @param visual 查询条件
     * @return Visual集合
     */
    public List<Visual> selectVisualList(Visual visual);

    /**
     * 新增Visual
     *
     * @param visual Visual
     * @return 结果
     */
    public int insertVisual(Visual visual);

    /**
     * 修改Visual
     *
     * @param visual Visual
     * @return 结果
     */
    public int updateVisual(Visual visual);

    /**
     * 删除Visual
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteVisualById(Long id);

    /**
     * 批量删除Visual
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVisualByIds(Long[] ids);
}
