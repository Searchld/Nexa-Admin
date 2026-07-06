package com.ruoyi.sq.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnLogsOut;
import com.ruoyi.sq.mapper.YnLogsOutMapper;
import com.ruoyi.sq.service.IYnLogsOutService;

/**
 * YnLogsOutService业务层处理
 */
@Service
public class YnLogsOutServiceImpl implements IYnLogsOutService
{
    @Autowired
    private YnLogsOutMapper ynLogsOutMapper;

    @Override
    public YnLogsOut selectYnLogsOutById(Long id)
    {
        return ynLogsOutMapper.selectYnLogsOutById(id);
    }

    @Override
    public List<YnLogsOut> selectYnLogsOutList(YnLogsOut ynLogsOut)
    {
        return ynLogsOutMapper.selectYnLogsOutList(ynLogsOut);
    }

    @Override
    public int insertYnLogsOut(YnLogsOut ynLogsOut)
    {
        // 无通用创建字段
        return ynLogsOutMapper.insertYnLogsOut(ynLogsOut);
    }

    @Override
    public int updateYnLogsOut(YnLogsOut ynLogsOut)
    {
        // 无通用更新字段
        return ynLogsOutMapper.updateYnLogsOut(ynLogsOut);
    }

    @Override
    public int deleteYnLogsOutByIds(Long[] ids)
    {
        return ynLogsOutMapper.deleteYnLogsOutByIds(ids);
    }

    @Override
    public int deleteYnLogsOutById(Long id)
    {
        return ynLogsOutMapper.deleteYnLogsOutById(id);
    }
}
