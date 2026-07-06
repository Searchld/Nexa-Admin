package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnRfid;

/**
 * YnRfidMapper接口
 */
public interface YnRfidMapper
{
    /**
     * 查询YnRfid
     *
     * @param id 主键
     * @return YnRfid
     */
    public YnRfid selectYnRfidById(Integer id);

    /**
     * 查询YnRfid列表
     *
     * @param ynRfid 查询条件
     * @return YnRfid集合
     */
    public List<YnRfid> selectYnRfidList(YnRfid ynRfid);

    /**
     * 新增YnRfid
     *
     * @param ynRfid YnRfid
     * @return 结果
     */
    public int insertYnRfid(YnRfid ynRfid);

    /**
     * 修改YnRfid
     *
     * @param ynRfid YnRfid
     * @return 结果
     */
    public int updateYnRfid(YnRfid ynRfid);

    /**
     * 删除YnRfid
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnRfidById(Integer id);

    /**
     * 批量删除YnRfid
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnRfidByIds(Integer[] ids);
}
