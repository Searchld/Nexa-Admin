package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.AlertInfo;

/**
 * AlertInfoMapper接口
 */
public interface AlertInfoMapper
{
    /**
     * 查询AlertInfo
     *
     * @param id 主键
     * @return AlertInfo
     */
    public AlertInfo selectAlertInfoById(Long id);

    /**
     * 查询AlertInfo列表
     *
     * @param alertInfo 查询条件
     * @return AlertInfo集合
     */
    public List<AlertInfo> selectAlertInfoList(AlertInfo alertInfo);

    /**
     * 新增AlertInfo
     *
     * @param alertInfo AlertInfo
     * @return 结果
     */
    public int insertAlertInfo(AlertInfo alertInfo);

    /**
     * 修改AlertInfo
     *
     * @param alertInfo AlertInfo
     * @return 结果
     */
    public int updateAlertInfo(AlertInfo alertInfo);

    /**
     * 删除AlertInfo
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteAlertInfoById(Long id);

    /**
     * 批量删除AlertInfo
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAlertInfoByIds(Long[] ids);
}
