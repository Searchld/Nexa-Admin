package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.CarsOutLogs;

/**
 * CarsOutLogsService接口
 */
public interface ICarsOutLogsService
{
    /** 查询CarsOutLogs */
    public CarsOutLogs selectCarsOutLogsById(Long id);

    /** 查询CarsOutLogs列表 */
    public List<CarsOutLogs> selectCarsOutLogsList(CarsOutLogs carsOutLogs);

    /** 新增CarsOutLogs */
    public int insertCarsOutLogs(CarsOutLogs carsOutLogs);

    /** 修改CarsOutLogs */
    public int updateCarsOutLogs(CarsOutLogs carsOutLogs);

    /** 批量删除CarsOutLogs */
    public int deleteCarsOutLogsByIds(Long[] ids);

    /** 删除CarsOutLogs信息 */
    public int deleteCarsOutLogsById(Long id);
}
