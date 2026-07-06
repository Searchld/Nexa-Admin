package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnTask;
import com.ruoyi.sq.mapper.YnTaskMapper;
import com.ruoyi.sq.service.IYnTaskService;

/**
 * YnTaskService业务层处理
 */
@Service
public class YnTaskServiceImpl implements IYnTaskService
{
    @Autowired
    private YnTaskMapper ynTaskMapper;

    @Override
    public YnTask selectYnTaskById(Integer id)
    {
        return ynTaskMapper.selectYnTaskById(id);
    }

    @Override
    public List<YnTask> selectYnTaskList(YnTask ynTask)
    {
        return ynTaskMapper.selectYnTaskList(ynTask);
    }

    @Override
    public int insertYnTask(YnTask ynTask)
    {
        ynTask.setCreateTime(Timestamp.from(Instant.now()));
        return ynTaskMapper.insertYnTask(ynTask);
    }

    @Override
    public int updateYnTask(YnTask ynTask)
    {
        // 无通用更新字段
        return ynTaskMapper.updateYnTask(ynTask);
    }

    @Override
    public int deleteYnTaskByIds(Integer[] ids)
    {
        return ynTaskMapper.deleteYnTaskByIds(ids);
    }

    @Override
    public int deleteYnTaskById(Integer id)
    {
        return ynTaskMapper.deleteYnTaskById(id);
    }
}
