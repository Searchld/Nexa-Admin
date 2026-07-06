package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.AlertReason;

/**
 * AlertReasonMapper接口
 */
public interface AlertReasonMapper
{
    /**
     * 查询AlertReason
     *
     * @param id 主键
     * @return AlertReason
     */
    public AlertReason selectAlertReasonById(Long id);

    /**
     * 查询AlertReason列表
     *
     * @param alertReason 查询条件
     * @return AlertReason集合
     */
    public List<AlertReason> selectAlertReasonList(AlertReason alertReason);

    /**
     * 新增AlertReason
     *
     * @param alertReason AlertReason
     * @return 结果
     */
    public int insertAlertReason(AlertReason alertReason);

    /**
     * 修改AlertReason
     *
     * @param alertReason AlertReason
     * @return 结果
     */
    public int updateAlertReason(AlertReason alertReason);

    /**
     * 删除AlertReason
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteAlertReasonById(Long id);

    /**
     * 批量删除AlertReason
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAlertReasonByIds(Long[] ids);
}
