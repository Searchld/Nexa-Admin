package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.VisualMap;

/**
 * VisualMapService接口
 */
public interface IVisualMapService
{
    /** 查询VisualMap */
    public VisualMap selectVisualMapById(Long id);

    /** 查询VisualMap列表 */
    public List<VisualMap> selectVisualMapList(VisualMap visualMap);

    /** 新增VisualMap */
    public int insertVisualMap(VisualMap visualMap);

    /** 修改VisualMap */
    public int updateVisualMap(VisualMap visualMap);

    /** 批量删除VisualMap */
    public int deleteVisualMapByIds(Long[] ids);

    /** 删除VisualMap信息 */
    public int deleteVisualMapById(Long id);
}
