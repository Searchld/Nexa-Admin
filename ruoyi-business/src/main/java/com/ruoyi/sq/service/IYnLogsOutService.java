package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnLogsOut;

/**
 * YnLogsOutService接口
 */
public interface IYnLogsOutService
{
    /** 查询YnLogsOut */
    public YnLogsOut selectYnLogsOutById(Long id);

    /** 查询YnLogsOut列表 */
    public List<YnLogsOut> selectYnLogsOutList(YnLogsOut ynLogsOut);

    /** 新增YnLogsOut */
    public int insertYnLogsOut(YnLogsOut ynLogsOut);

    /** 修改YnLogsOut */
    public int updateYnLogsOut(YnLogsOut ynLogsOut);

    /** 批量删除YnLogsOut */
    public int deleteYnLogsOutByIds(Long[] ids);

    /** 删除YnLogsOut信息 */
    public int deleteYnLogsOutById(Long id);
}
