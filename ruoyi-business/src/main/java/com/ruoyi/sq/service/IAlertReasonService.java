package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.AlertReason;

/**
 * AlertReasonService接口
 */
public interface IAlertReasonService
{
    /** 查询AlertReason */
    public AlertReason selectAlertReasonById(Long id);

    /** 查询AlertReason列表 */
    public List<AlertReason> selectAlertReasonList(AlertReason alertReason);

    /** 新增AlertReason */
    public int insertAlertReason(AlertReason alertReason);

    /** 修改AlertReason */
    public int updateAlertReason(AlertReason alertReason);

    /** 批量删除AlertReason */
    public int deleteAlertReasonByIds(Long[] ids);

    /** 删除AlertReason信息 */
    public int deleteAlertReasonById(Long id);
}
