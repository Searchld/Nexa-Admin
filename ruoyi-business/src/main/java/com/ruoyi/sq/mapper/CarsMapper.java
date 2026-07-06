package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.Cars;

/**
 * CarsMapper接口
 */
public interface CarsMapper
{
    /**
     * 查询Cars
     *
     * @param id 主键
     * @return Cars
     */
    public Cars selectCarsById(Long id);

    /**
     * 查询Cars列表
     *
     * @param cars 查询条件
     * @return Cars集合
     */
    public List<Cars> selectCarsList(Cars cars);

    /**
     * 新增Cars
     *
     * @param cars Cars
     * @return 结果
     */
    public int insertCars(Cars cars);

    /**
     * 修改Cars
     *
     * @param cars Cars
     * @return 结果
     */
    public int updateCars(Cars cars);

    /**
     * 删除Cars
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteCarsById(Long id);

    /**
     * 批量删除Cars
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarsByIds(Long[] ids);
}
