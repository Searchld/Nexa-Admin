package com.ruoyi.sq.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sq.domain.YnWxDept;
import com.ruoyi.sq.mapper.YnWxDeptMapper;
import com.ruoyi.sq.service.IYnWxDeptService;

/**
 * YnWxDeptService业务层处理
 */
@Service
public class YnWxDeptServiceImpl implements IYnWxDeptService
{
    @Autowired
    private YnWxDeptMapper ynWxDeptMapper;

    @Override
    public YnWxDept selectYnWxDeptById(Long id)
    {
        return ynWxDeptMapper.selectYnWxDeptById(id);
    }

    @Override
    public List<YnWxDept> selectYnWxDeptList(YnWxDept ynWxDept)
    {
        return ynWxDeptMapper.selectYnWxDeptList(ynWxDept);
    }

    @Override
    public int insertYnWxDept(YnWxDept ynWxDept)
    {
        // 无通用创建字段
        return ynWxDeptMapper.insertYnWxDept(ynWxDept);
    }

    @Override
    public int updateYnWxDept(YnWxDept ynWxDept)
    {
        // 无通用更新字段
        return ynWxDeptMapper.updateYnWxDept(ynWxDept);
    }

    @Override
    public int deleteYnWxDeptByIds(Long[] ids)
    {
        return ynWxDeptMapper.deleteYnWxDeptByIds(ids);
    }

    @Override
    public int deleteYnWxDeptById(Long id)
    {
        return ynWxDeptMapper.deleteYnWxDeptById(id);
    }
}
