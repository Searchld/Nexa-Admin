package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnCameraRecord;

/**
 * YnCameraRecordMapper接口
 */
public interface YnCameraRecordMapper
{
    /**
     * 查询YnCameraRecord
     *
     * @param id 主键
     * @return YnCameraRecord
     */
    public YnCameraRecord selectYnCameraRecordById(Long id);

    /**
     * 查询YnCameraRecord列表
     *
     * @param ynCameraRecord 查询条件
     * @return YnCameraRecord集合
     */
    public List<YnCameraRecord> selectYnCameraRecordList(YnCameraRecord ynCameraRecord);

    /**
     * 新增YnCameraRecord
     *
     * @param ynCameraRecord YnCameraRecord
     * @return 结果
     */
    public int insertYnCameraRecord(YnCameraRecord ynCameraRecord);

    /**
     * 修改YnCameraRecord
     *
     * @param ynCameraRecord YnCameraRecord
     * @return 结果
     */
    public int updateYnCameraRecord(YnCameraRecord ynCameraRecord);

    /**
     * 删除YnCameraRecord
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnCameraRecordById(Long id);

    /**
     * 批量删除YnCameraRecord
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnCameraRecordByIds(Long[] ids);
}
