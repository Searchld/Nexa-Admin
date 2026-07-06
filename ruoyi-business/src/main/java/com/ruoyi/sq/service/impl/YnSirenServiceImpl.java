package com.ruoyi.sq.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnSiren;
import com.ruoyi.sq.mapper.YnSirenMapper;
import com.ruoyi.sq.service.IYnSirenService;

/**
 * YnSirenService业务层处理
 */
@Service
public class YnSirenServiceImpl implements IYnSirenService
{
    @Autowired
    private YnSirenMapper ynSirenMapper;

    @Override
    public YnSiren selectYnSirenById(Integer id)
    {
        return ynSirenMapper.selectYnSirenById(id);
    }

    @Override
    public List<YnSiren> selectYnSirenList(YnSiren ynSiren)
    {
        return ynSirenMapper.selectYnSirenList(ynSiren);
    }

    @Override
    public int insertYnSiren(YnSiren ynSiren)
    {
        // 无通用创建字段
        return ynSirenMapper.insertYnSiren(ynSiren);
    }

    @Override
    public int updateYnSiren(YnSiren ynSiren)
    {
        // 无通用更新字段
        return ynSirenMapper.updateYnSiren(ynSiren);
    }

    @Override
    public int deleteYnSirenByIds(Integer[] ids)
    {
        return ynSirenMapper.deleteYnSirenByIds(ids);
    }

    @Override
    public int deleteYnSirenById(Integer id)
    {
        return ynSirenMapper.deleteYnSirenById(id);
    }
}
