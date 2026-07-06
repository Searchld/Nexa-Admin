package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.CarsLogs;

/**
 * CarsLogsMapper接口
 */
public interface CarsLogsMapper
{
    /**
     * 查询CarsLogs
     *
     * @param id 主键
     * @return CarsLogs
     */
    public CarsLogs selectCarsLogsById(Long id);

    /**
     * 查询CarsLogs列表
     *
     * @param carsLogs 查询条件
     * @return CarsLogs集合
     */
    public List<CarsLogs> selectCarsLogsList(CarsLogs carsLogs);

    /**
     * 新增CarsLogs
     *
     * @param carsLogs CarsLogs
     * @return 结果
     */
    public int insertCarsLogs(CarsLogs carsLogs);

    /**
     * 修改CarsLogs
     *
     * @param carsLogs CarsLogs
     * @return 结果
     */
    public int updateCarsLogs(CarsLogs carsLogs);

    /**
     * 删除CarsLogs
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteCarsLogsById(Long id);

    /**
     * 批量删除CarsLogs
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarsLogsByIds(Long[] ids);
}
