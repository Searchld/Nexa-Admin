package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnLogsLevel;

/**
 * YnLogsLevelService接口
 */
public interface IYnLogsLevelService
{
    /** 查询YnLogsLevel */
    public YnLogsLevel selectYnLogsLevelById(Integer id);

    /** 查询YnLogsLevel列表 */
    public List<YnLogsLevel> selectYnLogsLevelList(YnLogsLevel ynLogsLevel);

    /** 新增YnLogsLevel */
    public int insertYnLogsLevel(YnLogsLevel ynLogsLevel);

    /** 修改YnLogsLevel */
    public int updateYnLogsLevel(YnLogsLevel ynLogsLevel);

    /** 批量删除YnLogsLevel */
    public int deleteYnLogsLevelByIds(Integer[] ids);

    /** 删除YnLogsLevel信息 */
    public int deleteYnLogsLevelById(Integer id);
}
