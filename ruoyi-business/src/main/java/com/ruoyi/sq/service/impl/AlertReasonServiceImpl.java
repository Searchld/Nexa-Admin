package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.AlertReason;
import com.ruoyi.sq.mapper.AlertReasonMapper;
import com.ruoyi.sq.service.IAlertReasonService;

/**
 * AlertReasonService业务层处理
 */
@Service
public class AlertReasonServiceImpl implements IAlertReasonService
{
    @Autowired
    private AlertReasonMapper alertReasonMapper;

    @Override
    public AlertReason selectAlertReasonById(Long id)
    {
        return alertReasonMapper.selectAlertReasonById(id);
    }

    @Override
    public List<AlertReason> selectAlertReasonList(AlertReason alertReason)
    {
        return alertReasonMapper.selectAlertReasonList(alertReason);
    }

    @Override
    public int insertAlertReason(AlertReason alertReason)
    {
        alertReason.setCreateTime(Timestamp.from(Instant.now()));
        alertReason.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        alertReason.setIsDeleted("0");
        return alertReasonMapper.insertAlertReason(alertReason);
    }

    @Override
    public int updateAlertReason(AlertReason alertReason)
    {
        alertReason.setUpdateTime(Timestamp.from(Instant.now()));
        alertReason.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return alertReasonMapper.updateAlertReason(alertReason);
    }

    @Override
    public int deleteAlertReasonByIds(Long[] ids)
    {
        return alertReasonMapper.deleteAlertReasonByIds(ids);
    }

    @Override
    public int deleteAlertReasonById(Long id)
    {
        return alertReasonMapper.deleteAlertReasonById(id);
    }

    private Long getUserId()
    {
        try
        {
            return SecurityUtils.getUserId();
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
