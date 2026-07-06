package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.Alert;
import com.ruoyi.sq.mapper.AlertMapper;
import com.ruoyi.sq.service.IAlertService;

/**
 * AlertService业务层处理
 */
@Service
public class AlertServiceImpl implements IAlertService
{
    @Autowired
    private AlertMapper alertMapper;

    @Override
    public Alert selectAlertById(Long id)
    {
        return alertMapper.selectAlertById(id);
    }

    @Override
    public List<Alert> selectAlertList(Alert alert)
    {
        return alertMapper.selectAlertList(alert);
    }

    @Override
    public int insertAlert(Alert alert)
    {
        alert.setCreateTime(Timestamp.from(Instant.now()));
        alert.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        alert.setIsDeleted("0");
        return alertMapper.insertAlert(alert);
    }

    @Override
    public int updateAlert(Alert alert)
    {
        alert.setUpdateTime(Timestamp.from(Instant.now()));
        alert.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return alertMapper.updateAlert(alert);
    }

    @Override
    public int deleteAlertByIds(Long[] ids)
    {
        return alertMapper.deleteAlertByIds(ids);
    }

    @Override
    public int deleteAlertById(Long id)
    {
        return alertMapper.deleteAlertById(id);
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
