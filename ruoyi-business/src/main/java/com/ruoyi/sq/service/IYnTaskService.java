package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnTask;

/**
 * YnTaskService接口
 */
public interface IYnTaskService
{
    /** 查询YnTask */
    public YnTask selectYnTaskById(Integer id);

    /** 查询YnTask列表 */
    public List<YnTask> selectYnTaskList(YnTask ynTask);

    /** 新增YnTask */
    public int insertYnTask(YnTask ynTask);

    /** 修改YnTask */
    public int updateYnTask(YnTask ynTask);

    /** 批量删除YnTask */
    public int deleteYnTaskByIds(Integer[] ids);

    /** 删除YnTask信息 */
    public int deleteYnTaskById(Integer id);
}
