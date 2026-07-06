package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.Cars;

/**
 * CarsService接口
 */
public interface ICarsService
{
    /** 查询Cars */
    public Cars selectCarsById(Long id);

    /** 查询Cars列表 */
    public List<Cars> selectCarsList(Cars cars);

    /** 新增Cars */
    public int insertCars(Cars cars);

    /** 修改Cars */
    public int updateCars(Cars cars);

    /** 批量删除Cars */
    public int deleteCarsByIds(Long[] ids);

    /** 删除Cars信息 */
    public int deleteCarsById(Long id);
}
