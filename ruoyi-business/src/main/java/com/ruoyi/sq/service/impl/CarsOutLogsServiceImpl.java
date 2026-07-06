package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.CarsOutLogs;
import com.ruoyi.sq.mapper.CarsOutLogsMapper;
import com.ruoyi.sq.service.ICarsOutLogsService;

/**
 * CarsOutLogsService业务层处理
 */
@Service
public class CarsOutLogsServiceImpl implements ICarsOutLogsService
{
    @Autowired
    private CarsOutLogsMapper carsOutLogsMapper;

    @Override
    public CarsOutLogs selectCarsOutLogsById(Long id)
    {
        return carsOutLogsMapper.selectCarsOutLogsById(id);
    }

    @Override
    public List<CarsOutLogs> selectCarsOutLogsList(CarsOutLogs carsOutLogs)
    {
        return carsOutLogsMapper.selectCarsOutLogsList(carsOutLogs);
    }

    @Override
    public int insertCarsOutLogs(CarsOutLogs carsOutLogs)
    {
        carsOutLogs.setCreateTime(Timestamp.from(Instant.now()));
        carsOutLogs.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        carsOutLogs.setIsDeleted("0");
        return carsOutLogsMapper.insertCarsOutLogs(carsOutLogs);
    }

    @Override
    public int updateCarsOutLogs(CarsOutLogs carsOutLogs)
    {
        carsOutLogs.setUpdateTime(Timestamp.from(Instant.now()));
        carsOutLogs.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return carsOutLogsMapper.updateCarsOutLogs(carsOutLogs);
    }

    @Override
    public int deleteCarsOutLogsByIds(Long[] ids)
    {
        return carsOutLogsMapper.deleteCarsOutLogsByIds(ids);
    }

    @Override
    public int deleteCarsOutLogsById(Long id)
    {
        return carsOutLogsMapper.deleteCarsOutLogsById(id);
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
