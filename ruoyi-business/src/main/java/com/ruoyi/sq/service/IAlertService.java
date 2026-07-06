package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.Alert;

/**
 * AlertService接口
 */
public interface IAlertService
{
    /** 查询Alert */
    public Alert selectAlertById(Long id);

    /** 查询Alert列表 */
    public List<Alert> selectAlertList(Alert alert);

    /** 新增Alert */
    public int insertAlert(Alert alert);

    /** 修改Alert */
    public int updateAlert(Alert alert);

    /** 批量删除Alert */
    public int deleteAlertByIds(Long[] ids);

    /** 删除Alert信息 */
    public int deleteAlertById(Long id);
}
