package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnCameraRecord;
import com.ruoyi.sq.mapper.YnCameraRecordMapper;
import com.ruoyi.sq.service.IYnCameraRecordService;

/**
 * YnCameraRecordService业务层处理
 */
@Service
public class YnCameraRecordServiceImpl implements IYnCameraRecordService
{
    @Autowired
    private YnCameraRecordMapper ynCameraRecordMapper;

    @Override
    public YnCameraRecord selectYnCameraRecordById(Long id)
    {
        return ynCameraRecordMapper.selectYnCameraRecordById(id);
    }

    @Override
    public List<YnCameraRecord> selectYnCameraRecordList(YnCameraRecord ynCameraRecord)
    {
        return ynCameraRecordMapper.selectYnCameraRecordList(ynCameraRecord);
    }

    @Override
    public int insertYnCameraRecord(YnCameraRecord ynCameraRecord)
    {
        ynCameraRecord.setCreateTime(Timestamp.from(Instant.now()));
        return ynCameraRecordMapper.insertYnCameraRecord(ynCameraRecord);
    }

    @Override
    public int updateYnCameraRecord(YnCameraRecord ynCameraRecord)
    {
        // 无通用更新字段
        return ynCameraRecordMapper.updateYnCameraRecord(ynCameraRecord);
    }

    @Override
    public int deleteYnCameraRecordByIds(Long[] ids)
    {
        return ynCameraRecordMapper.deleteYnCameraRecordByIds(ids);
    }

    @Override
    public int deleteYnCameraRecordById(Long id)
    {
        return ynCameraRecordMapper.deleteYnCameraRecordById(id);
    }
}
