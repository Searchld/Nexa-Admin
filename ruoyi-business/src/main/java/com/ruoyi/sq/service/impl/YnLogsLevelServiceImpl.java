package com.ruoyi.sq.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnLogsLevel;
import com.ruoyi.sq.mapper.YnLogsLevelMapper;
import com.ruoyi.sq.service.IYnLogsLevelService;

/**
 * YnLogsLevelService业务层处理
 */
@Service
public class YnLogsLevelServiceImpl implements IYnLogsLevelService
{
    @Autowired
    private YnLogsLevelMapper ynLogsLevelMapper;

    @Override
    public YnLogsLevel selectYnLogsLevelById(Integer id)
    {
        return ynLogsLevelMapper.selectYnLogsLevelById(id);
    }

    @Override
    public List<YnLogsLevel> selectYnLogsLevelList(YnLogsLevel ynLogsLevel)
    {
        return ynLogsLevelMapper.selectYnLogsLevelList(ynLogsLevel);
    }

    @Override
    public int insertYnLogsLevel(YnLogsLevel ynLogsLevel)
    {
        // 无通用创建字段
        return ynLogsLevelMapper.insertYnLogsLevel(ynLogsLevel);
    }

    @Override
    public int updateYnLogsLevel(YnLogsLevel ynLogsLevel)
    {
        // 无通用更新字段
        return ynLogsLevelMapper.updateYnLogsLevel(ynLogsLevel);
    }

    @Override
    public int deleteYnLogsLevelByIds(Integer[] ids)
    {
        return ynLogsLevelMapper.deleteYnLogsLevelByIds(ids);
    }

    @Override
    public int deleteYnLogsLevelById(Integer id)
    {
        return ynLogsLevelMapper.deleteYnLogsLevelById(id);
    }
}
