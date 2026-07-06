package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.VisualConfig;

/**
 * VisualConfigService接口
 */
public interface IVisualConfigService
{
    /** 查询VisualConfig */
    public VisualConfig selectVisualConfigById(Long id);

    /** 查询VisualConfig列表 */
    public List<VisualConfig> selectVisualConfigList(VisualConfig visualConfig);

    /** 新增VisualConfig */
    public int insertVisualConfig(VisualConfig visualConfig);

    /** 修改VisualConfig */
    public int updateVisualConfig(VisualConfig visualConfig);

    /** 批量删除VisualConfig */
    public int deleteVisualConfigByIds(Long[] ids);

    /** 删除VisualConfig信息 */
    public int deleteVisualConfigById(Long id);
}
