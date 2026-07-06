package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnRfid;

/**
 * YnRfidService接口
 */
public interface IYnRfidService
{
    /** 查询YnRfid */
    public YnRfid selectYnRfidById(Integer id);

    /** 查询YnRfid列表 */
    public List<YnRfid> selectYnRfidList(YnRfid ynRfid);

    /** 新增YnRfid */
    public int insertYnRfid(YnRfid ynRfid);

    /** 修改YnRfid */
    public int updateYnRfid(YnRfid ynRfid);

    /** 批量删除YnRfid */
    public int deleteYnRfidByIds(Integer[] ids);

    /** 删除YnRfid信息 */
    public int deleteYnRfidById(Integer id);
}
