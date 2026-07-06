package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnLogsLevel;

/**
 * YnLogsLevelMapper接口
 */
public interface YnLogsLevelMapper
{
    /**
     * 查询YnLogsLevel
     *
     * @param id 主键
     * @return YnLogsLevel
     */
    public YnLogsLevel selectYnLogsLevelById(Integer id);

    /**
     * 查询YnLogsLevel列表
     *
     * @param ynLogsLevel 查询条件
     * @return YnLogsLevel集合
     */
    public List<YnLogsLevel> selectYnLogsLevelList(YnLogsLevel ynLogsLevel);

    /**
     * 新增YnLogsLevel
     *
     * @param ynLogsLevel YnLogsLevel
     * @return 结果
     */
    public int insertYnLogsLevel(YnLogsLevel ynLogsLevel);

    /**
     * 修改YnLogsLevel
     *
     * @param ynLogsLevel YnLogsLevel
     * @return 结果
     */
    public int updateYnLogsLevel(YnLogsLevel ynLogsLevel);

    /**
     * 删除YnLogsLevel
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnLogsLevelById(Integer id);

    /**
     * 批量删除YnLogsLevel
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnLogsLevelByIds(Integer[] ids);
}
