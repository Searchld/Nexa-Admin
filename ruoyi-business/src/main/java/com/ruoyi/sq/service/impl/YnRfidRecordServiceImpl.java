package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnRfidRecord;
import com.ruoyi.sq.mapper.YnRfidRecordMapper;
import com.ruoyi.sq.service.IYnRfidRecordService;

/**
 * YnRfidRecordService业务层处理
 */
@Service
public class YnRfidRecordServiceImpl implements IYnRfidRecordService
{
    @Autowired
    private YnRfidRecordMapper ynRfidRecordMapper;

    @Override
    public YnRfidRecord selectYnRfidRecordById(Integer id)
    {
        return ynRfidRecordMapper.selectYnRfidRecordById(id);
    }

    @Override
    public List<YnRfidRecord> selectYnRfidRecordList(YnRfidRecord ynRfidRecord)
    {
        return ynRfidRecordMapper.selectYnRfidRecordList(ynRfidRecord);
    }

    @Override
    public int insertYnRfidRecord(YnRfidRecord ynRfidRecord)
    {
        ynRfidRecord.setCreateTime(Timestamp.from(Instant.now()));
        return ynRfidRecordMapper.insertYnRfidRecord(ynRfidRecord);
    }

    @Override
    public int updateYnRfidRecord(YnRfidRecord ynRfidRecord)
    {
        // 无通用更新字段
        return ynRfidRecordMapper.updateYnRfidRecord(ynRfidRecord);
    }

    @Override
    public int deleteYnRfidRecordByIds(Integer[] ids)
    {
        return ynRfidRecordMapper.deleteYnRfidRecordByIds(ids);
    }

    @Override
    public int deleteYnRfidRecordById(Integer id)
    {
        return ynRfidRecordMapper.deleteYnRfidRecordById(id);
    }
}
