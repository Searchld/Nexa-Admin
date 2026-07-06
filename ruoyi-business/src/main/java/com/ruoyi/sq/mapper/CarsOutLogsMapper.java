package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.CarsOutLogs;

/**
 * CarsOutLogsMapper接口
 */
public interface CarsOutLogsMapper
{
    /**
     * 查询CarsOutLogs
     *
     * @param id 主键
     * @return CarsOutLogs
     */
    public CarsOutLogs selectCarsOutLogsById(Long id);

    /**
     * 查询CarsOutLogs列表
     *
     * @param carsOutLogs 查询条件
     * @return CarsOutLogs集合
     */
    public List<CarsOutLogs> selectCarsOutLogsList(CarsOutLogs carsOutLogs);

    /**
     * 新增CarsOutLogs
     *
     * @param carsOutLogs CarsOutLogs
     * @return 结果
     */
    public int insertCarsOutLogs(CarsOutLogs carsOutLogs);

    /**
     * 修改CarsOutLogs
     *
     * @param carsOutLogs CarsOutLogs
     * @return 结果
     */
    public int updateCarsOutLogs(CarsOutLogs carsOutLogs);

    /**
     * 删除CarsOutLogs
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteCarsOutLogsById(Long id);

    /**
     * 批量删除CarsOutLogs
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarsOutLogsByIds(Long[] ids);
}
