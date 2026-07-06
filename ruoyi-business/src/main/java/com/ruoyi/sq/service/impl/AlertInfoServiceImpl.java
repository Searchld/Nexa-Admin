package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.AlertInfo;
import com.ruoyi.sq.mapper.AlertInfoMapper;
import com.ruoyi.sq.service.IAlertInfoService;

/**
 * AlertInfoService业务层处理
 */
@Service
public class AlertInfoServiceImpl implements IAlertInfoService
{
    @Autowired
    private AlertInfoMapper alertInfoMapper;

    @Override
    public AlertInfo selectAlertInfoById(Long id)
    {
        return alertInfoMapper.selectAlertInfoById(id);
    }

    @Override
    public List<AlertInfo> selectAlertInfoList(AlertInfo alertInfo)
    {
        return alertInfoMapper.selectAlertInfoList(alertInfo);
    }

    @Override
    public int insertAlertInfo(AlertInfo alertInfo)
    {
        alertInfo.setCreateTime(Timestamp.from(Instant.now()));
        alertInfo.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        alertInfo.setIsDeleted("0");
        return alertInfoMapper.insertAlertInfo(alertInfo);
    }

    @Override
    public int updateAlertInfo(AlertInfo alertInfo)
    {
        alertInfo.setUpdateTime(Timestamp.from(Instant.now()));
        alertInfo.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return alertInfoMapper.updateAlertInfo(alertInfo);
    }

    @Override
    public int deleteAlertInfoByIds(Long[] ids)
    {
        return alertInfoMapper.deleteAlertInfoByIds(ids);
    }

    @Override
    public int deleteAlertInfoById(Long id)
    {
        return alertInfoMapper.deleteAlertInfoById(id);
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
