package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnCameraRecord;

/**
 * YnCameraRecordService接口
 */
public interface IYnCameraRecordService
{
    /** 查询YnCameraRecord */
    public YnCameraRecord selectYnCameraRecordById(Long id);

    /** 查询YnCameraRecord列表 */
    public List<YnCameraRecord> selectYnCameraRecordList(YnCameraRecord ynCameraRecord);

    /** 新增YnCameraRecord */
    public int insertYnCameraRecord(YnCameraRecord ynCameraRecord);

    /** 修改YnCameraRecord */
    public int updateYnCameraRecord(YnCameraRecord ynCameraRecord);

    /** 批量删除YnCameraRecord */
    public int deleteYnCameraRecordByIds(Long[] ids);

    /** 删除YnCameraRecord信息 */
    public int deleteYnCameraRecordById(Long id);
}
