package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.AlertInfo;

/**
 * AlertInfoService接口
 */
public interface IAlertInfoService
{
    /** 查询AlertInfo */
    public AlertInfo selectAlertInfoById(Long id);

    /** 查询AlertInfo列表 */
    public List<AlertInfo> selectAlertInfoList(AlertInfo alertInfo);

    /** 新增AlertInfo */
    public int insertAlertInfo(AlertInfo alertInfo);

    /** 修改AlertInfo */
    public int updateAlertInfo(AlertInfo alertInfo);

    /** 批量删除AlertInfo */
    public int deleteAlertInfoByIds(Long[] ids);

    /** 删除AlertInfo信息 */
    public int deleteAlertInfoById(Long id);
}
