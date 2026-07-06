package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.VisualMap;

/**
 * VisualMapMapper接口
 */
public interface VisualMapMapper
{
    /**
     * 查询VisualMap
     *
     * @param id 主键
     * @return VisualMap
     */
    public VisualMap selectVisualMapById(Long id);

    /**
     * 查询VisualMap列表
     *
     * @param visualMap 查询条件
     * @return VisualMap集合
     */
    public List<VisualMap> selectVisualMapList(VisualMap visualMap);

    /**
     * 新增VisualMap
     *
     * @param visualMap VisualMap
     * @return 结果
     */
    public int insertVisualMap(VisualMap visualMap);

    /**
     * 修改VisualMap
     *
     * @param visualMap VisualMap
     * @return 结果
     */
    public int updateVisualMap(VisualMap visualMap);

    /**
     * 删除VisualMap
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteVisualMapById(Long id);

    /**
     * 批量删除VisualMap
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVisualMapByIds(Long[] ids);
}
