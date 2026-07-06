package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.CarNum;
import com.ruoyi.sq.mapper.CarNumMapper;
import com.ruoyi.sq.service.ICarNumService;

/**
 * CarNumService业务层处理
 */
@Service
public class CarNumServiceImpl implements ICarNumService
{
    @Autowired
    private CarNumMapper carNumMapper;

    @Override
    public CarNum selectCarNumById(Long id)
    {
        return carNumMapper.selectCarNumById(id);
    }

    @Override
    public List<CarNum> selectCarNumList(CarNum carNum)
    {
        return carNumMapper.selectCarNumList(carNum);
    }

    @Override
    public int insertCarNum(CarNum carNum)
    {
        carNum.setCreateTime(Timestamp.from(Instant.now()));
        return carNumMapper.insertCarNum(carNum);
    }

    @Override
    public int updateCarNum(CarNum carNum)
    {
        // 无通用更新字段
        return carNumMapper.updateCarNum(carNum);
    }

    @Override
    public int deleteCarNumByIds(Long[] ids)
    {
        return carNumMapper.deleteCarNumByIds(ids);
    }

    @Override
    public int deleteCarNumById(Long id)
    {
        return carNumMapper.deleteCarNumById(id);
    }
}
