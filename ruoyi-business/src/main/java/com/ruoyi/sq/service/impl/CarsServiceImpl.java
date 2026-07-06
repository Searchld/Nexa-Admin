package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.Cars;
import com.ruoyi.sq.mapper.CarsMapper;
import com.ruoyi.sq.service.ICarsService;

/**
 * CarsService业务层处理
 */
@Service
public class CarsServiceImpl implements ICarsService
{
    @Autowired
    private CarsMapper carsMapper;

    @Override
    public Cars selectCarsById(Long id)
    {
        return carsMapper.selectCarsById(id);
    }

    @Override
    public List<Cars> selectCarsList(Cars cars)
    {
        return carsMapper.selectCarsList(cars);
    }

    @Override
    public int insertCars(Cars cars)
    {
        cars.setCreateTime(Timestamp.from(Instant.now()));
        cars.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        cars.setIsDeleted("0");
        return carsMapper.insertCars(cars);
    }

    @Override
    public int updateCars(Cars cars)
    {
        cars.setUpdateTime(Timestamp.from(Instant.now()));
        cars.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return carsMapper.updateCars(cars);
    }

    @Override
    public int deleteCarsByIds(Long[] ids)
    {
        return carsMapper.deleteCarsByIds(ids);
    }

    @Override
    public int deleteCarsById(Long id)
    {
        return carsMapper.deleteCarsById(id);
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
