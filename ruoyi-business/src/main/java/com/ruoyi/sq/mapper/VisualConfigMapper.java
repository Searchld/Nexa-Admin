package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.VisualConfig;

/**
 * VisualConfigMapper接口
 */
public interface VisualConfigMapper
{
    /**
     * 查询VisualConfig
     *
     * @param id 主键
     * @return VisualConfig
     */
    public VisualConfig selectVisualConfigById(Long id);

    /**
     * 查询VisualConfig列表
     *
     * @param visualConfig 查询条件
     * @return VisualConfig集合
     */
    public List<VisualConfig> selectVisualConfigList(VisualConfig visualConfig);

    /**
     * 新增VisualConfig
     *
     * @param visualConfig VisualConfig
     * @return 结果
     */
    public int insertVisualConfig(VisualConfig visualConfig);

    /**
     * 修改VisualConfig
     *
     * @param visualConfig VisualConfig
     * @return 结果
     */
    public int updateVisualConfig(VisualConfig visualConfig);

    /**
     * 删除VisualConfig
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteVisualConfigById(Long id);

    /**
     * 批量删除VisualConfig
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVisualConfigByIds(Long[] ids);
}
