package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.CarNum;

/**
 * CarNumMapper接口
 */
public interface CarNumMapper
{
    /**
     * 查询CarNum
     *
     * @param id 主键
     * @return CarNum
     */
    public CarNum selectCarNumById(Long id);

    /**
     * 查询CarNum列表
     *
     * @param carNum 查询条件
     * @return CarNum集合
     */
    public List<CarNum> selectCarNumList(CarNum carNum);

    /**
     * 新增CarNum
     *
     * @param carNum CarNum
     * @return 结果
     */
    public int insertCarNum(CarNum carNum);

    /**
     * 修改CarNum
     *
     * @param carNum CarNum
     * @return 结果
     */
    public int updateCarNum(CarNum carNum);

    /**
     * 删除CarNum
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteCarNumById(Long id);

    /**
     * 批量删除CarNum
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarNumByIds(Long[] ids);
}
