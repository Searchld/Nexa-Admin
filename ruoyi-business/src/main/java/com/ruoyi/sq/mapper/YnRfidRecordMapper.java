package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnRfidRecord;

/**
 * YnRfidRecordMapper接口
 */
public interface YnRfidRecordMapper
{
    /**
     * 查询YnRfidRecord
     *
     * @param id 主键
     * @return YnRfidRecord
     */
    public YnRfidRecord selectYnRfidRecordById(Integer id);

    /**
     * 查询YnRfidRecord列表
     *
     * @param ynRfidRecord 查询条件
     * @return YnRfidRecord集合
     */
    public List<YnRfidRecord> selectYnRfidRecordList(YnRfidRecord ynRfidRecord);

    /**
     * 新增YnRfidRecord
     *
     * @param ynRfidRecord YnRfidRecord
     * @return 结果
     */
    public int insertYnRfidRecord(YnRfidRecord ynRfidRecord);

    /**
     * 修改YnRfidRecord
     *
     * @param ynRfidRecord YnRfidRecord
     * @return 结果
     */
    public int updateYnRfidRecord(YnRfidRecord ynRfidRecord);

    /**
     * 删除YnRfidRecord
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnRfidRecordById(Integer id);

    /**
     * 批量删除YnRfidRecord
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnRfidRecordByIds(Integer[] ids);
}
