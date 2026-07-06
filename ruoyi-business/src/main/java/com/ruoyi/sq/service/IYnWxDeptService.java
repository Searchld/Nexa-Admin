package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnWxDept;

/**
 * YnWxDeptService接口
 */
public interface IYnWxDeptService
{
    /** 查询YnWxDept */
    public YnWxDept selectYnWxDeptById(Long id);

    /** 查询YnWxDept列表 */
    public List<YnWxDept> selectYnWxDeptList(YnWxDept ynWxDept);

    /** 新增YnWxDept */
    public int insertYnWxDept(YnWxDept ynWxDept);

    /** 修改YnWxDept */
    public int updateYnWxDept(YnWxDept ynWxDept);

    /** 批量删除YnWxDept */
    public int deleteYnWxDeptByIds(Long[] ids);

    /** 删除YnWxDept信息 */
    public int deleteYnWxDeptById(Long id);
}
