package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.CarsLogs;

/**
 * CarsLogsService接口
 */
public interface ICarsLogsService
{
    /** 查询CarsLogs */
    public CarsLogs selectCarsLogsById(Long id);

    /** 查询CarsLogs列表 */
    public List<CarsLogs> selectCarsLogsList(CarsLogs carsLogs);

    /** 新增CarsLogs */
    public int insertCarsLogs(CarsLogs carsLogs);

    /** 修改CarsLogs */
    public int updateCarsLogs(CarsLogs carsLogs);

    /** 批量删除CarsLogs */
    public int deleteCarsLogsByIds(Long[] ids);

    /** 删除CarsLogs信息 */
    public int deleteCarsLogsById(Long id);
}
