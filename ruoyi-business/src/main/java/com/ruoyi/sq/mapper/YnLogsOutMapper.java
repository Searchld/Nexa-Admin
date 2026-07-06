package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnLogsOut;

/**
 * YnLogsOutMapper接口
 */
public interface YnLogsOutMapper
{
    /**
     * 查询YnLogsOut
     *
     * @param id 主键
     * @return YnLogsOut
     */
    public YnLogsOut selectYnLogsOutById(Long id);

    /**
     * 查询YnLogsOut列表
     *
     * @param ynLogsOut 查询条件
     * @return YnLogsOut集合
     */
    public List<YnLogsOut> selectYnLogsOutList(YnLogsOut ynLogsOut);

    /**
     * 新增YnLogsOut
     *
     * @param ynLogsOut YnLogsOut
     * @return 结果
     */
    public int insertYnLogsOut(YnLogsOut ynLogsOut);

    /**
     * 修改YnLogsOut
     *
     * @param ynLogsOut YnLogsOut
     * @return 结果
     */
    public int updateYnLogsOut(YnLogsOut ynLogsOut);

    /**
     * 删除YnLogsOut
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnLogsOutById(Long id);

    /**
     * 批量删除YnLogsOut
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnLogsOutByIds(Long[] ids);
}
