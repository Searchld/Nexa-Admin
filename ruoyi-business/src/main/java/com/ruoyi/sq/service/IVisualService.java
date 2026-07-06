package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.Visual;

/**
 * VisualService接口
 */
public interface IVisualService
{
    /** 查询Visual */
    public Visual selectVisualById(Long id);

    /** 查询Visual列表 */
    public List<Visual> selectVisualList(Visual visual);

    /** 新增Visual */
    public int insertVisual(Visual visual);

    /** 修改Visual */
    public int updateVisual(Visual visual);

    /** 批量删除Visual */
    public int deleteVisualByIds(Long[] ids);

    /** 删除Visual信息 */
    public int deleteVisualById(Long id);
}
