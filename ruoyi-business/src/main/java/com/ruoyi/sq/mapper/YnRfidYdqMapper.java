package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnRfidYdq;

/**
 * YnRfidYdqMapper接口
 */
public interface YnRfidYdqMapper
{
    /**
     * 查询YnRfidYdq
     *
     * @param id 主键
     * @return YnRfidYdq
     */
    public YnRfidYdq selectYnRfidYdqById(Integer id);

    /**
     * 查询YnRfidYdq列表
     *
     * @param ynRfidYdq 查询条件
     * @return YnRfidYdq集合
     */
    public List<YnRfidYdq> selectYnRfidYdqList(YnRfidYdq ynRfidYdq);

    /**
     * 新增YnRfidYdq
     *
     * @param ynRfidYdq YnRfidYdq
     * @return 结果
     */
    public int insertYnRfidYdq(YnRfidYdq ynRfidYdq);

    /**
     * 修改YnRfidYdq
     *
     * @param ynRfidYdq YnRfidYdq
     * @return 结果
     */
    public int updateYnRfidYdq(YnRfidYdq ynRfidYdq);

    /**
     * 删除YnRfidYdq
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnRfidYdqById(Integer id);

    /**
     * 批量删除YnRfidYdq
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnRfidYdqByIds(Integer[] ids);
}
