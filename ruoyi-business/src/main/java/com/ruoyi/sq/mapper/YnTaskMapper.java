package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnTask;

/**
 * YnTaskMapper接口
 */
public interface YnTaskMapper
{
    /**
     * 查询YnTask
     *
     * @param id 主键
     * @return YnTask
     */
    public YnTask selectYnTaskById(Integer id);

    /**
     * 查询YnTask列表
     *
     * @param ynTask 查询条件
     * @return YnTask集合
     */
    public List<YnTask> selectYnTaskList(YnTask ynTask);

    /**
     * 新增YnTask
     *
     * @param ynTask YnTask
     * @return 结果
     */
    public int insertYnTask(YnTask ynTask);

    /**
     * 修改YnTask
     *
     * @param ynTask YnTask
     * @return 结果
     */
    public int updateYnTask(YnTask ynTask);

    /**
     * 删除YnTask
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnTaskById(Integer id);

    /**
     * 批量删除YnTask
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnTaskByIds(Integer[] ids);
}
