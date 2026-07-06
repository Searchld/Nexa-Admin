package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnRfidYdq;

/**
 * YnRfidYdqService接口
 */
public interface IYnRfidYdqService
{
    /** 查询YnRfidYdq */
    public YnRfidYdq selectYnRfidYdqById(Integer id);

    /** 查询YnRfidYdq列表 */
    public List<YnRfidYdq> selectYnRfidYdqList(YnRfidYdq ynRfidYdq);

    /** 新增YnRfidYdq */
    public int insertYnRfidYdq(YnRfidYdq ynRfidYdq);

    /** 修改YnRfidYdq */
    public int updateYnRfidYdq(YnRfidYdq ynRfidYdq);

    /** 批量删除YnRfidYdq */
    public int deleteYnRfidYdqByIds(Integer[] ids);

    /** 删除YnRfidYdq信息 */
    public int deleteYnRfidYdqById(Integer id);
}
