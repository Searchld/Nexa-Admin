package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.CarNum;

/**
 * CarNumService接口
 */
public interface ICarNumService
{
    /** 查询CarNum */
    public CarNum selectCarNumById(Long id);

    /** 查询CarNum列表 */
    public List<CarNum> selectCarNumList(CarNum carNum);

    /** 新增CarNum */
    public int insertCarNum(CarNum carNum);

    /** 修改CarNum */
    public int updateCarNum(CarNum carNum);

    /** 批量删除CarNum */
    public int deleteCarNumByIds(Long[] ids);

    /** 删除CarNum信息 */
    public int deleteCarNumById(Long id);
}
