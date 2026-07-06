package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.Alert;

/**
 * AlertMapper接口
 */
public interface AlertMapper
{
    /**
     * 查询Alert
     *
     * @param id 主键
     * @return Alert
     */
    public Alert selectAlertById(Long id);

    /**
     * 查询Alert列表
     *
     * @param alert 查询条件
     * @return Alert集合
     */
    public List<Alert> selectAlertList(Alert alert);

    /**
     * 新增Alert
     *
     * @param alert Alert
     * @return 结果
     */
    public int insertAlert(Alert alert);

    /**
     * 修改Alert
     *
     * @param alert Alert
     * @return 结果
     */
    public int updateAlert(Alert alert);

    /**
     * 删除Alert
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteAlertById(Long id);

    /**
     * 批量删除Alert
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAlertByIds(Long[] ids);
}
