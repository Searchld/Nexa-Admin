package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.CarsLogs;
import com.ruoyi.sq.mapper.CarsLogsMapper;
import com.ruoyi.sq.service.ICarsLogsService;

/**
 * CarsLogsService业务层处理
 */
@Service
public class CarsLogsServiceImpl implements ICarsLogsService
{
    @Autowired
    private CarsLogsMapper carsLogsMapper;

    @Override
    public CarsLogs selectCarsLogsById(Long id)
    {
        return carsLogsMapper.selectCarsLogsById(id);
    }

    @Override
    public List<CarsLogs> selectCarsLogsList(CarsLogs carsLogs)
    {
        return carsLogsMapper.selectCarsLogsList(carsLogs);
    }

    @Override
    public int insertCarsLogs(CarsLogs carsLogs)
    {
        carsLogs.setCreateTime(Timestamp.from(Instant.now()));
        carsLogs.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        carsLogs.setIsDeleted("0");
        return carsLogsMapper.insertCarsLogs(carsLogs);
    }

    @Override
    public int updateCarsLogs(CarsLogs carsLogs)
    {
        carsLogs.setUpdateTime(Timestamp.from(Instant.now()));
        carsLogs.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return carsLogsMapper.updateCarsLogs(carsLogs);
    }

    @Override
    public int deleteCarsLogsByIds(Long[] ids)
    {
        return carsLogsMapper.deleteCarsLogsByIds(ids);
    }

    @Override
    public int deleteCarsLogsById(Long id)
    {
        return carsLogsMapper.deleteCarsLogsById(id);
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
