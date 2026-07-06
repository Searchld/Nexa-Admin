package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnRfidRecord;

/**
 * YnRfidRecordService接口
 */
public interface IYnRfidRecordService
{
    /** 查询YnRfidRecord */
    public YnRfidRecord selectYnRfidRecordById(Integer id);

    /** 查询YnRfidRecord列表 */
    public List<YnRfidRecord> selectYnRfidRecordList(YnRfidRecord ynRfidRecord);

    /** 新增YnRfidRecord */
    public int insertYnRfidRecord(YnRfidRecord ynRfidRecord);

    /** 修改YnRfidRecord */
    public int updateYnRfidRecord(YnRfidRecord ynRfidRecord);

    /** 批量删除YnRfidRecord */
    public int deleteYnRfidRecordByIds(Integer[] ids);

    /** 删除YnRfidRecord信息 */
    public int deleteYnRfidRecordById(Integer id);
}
