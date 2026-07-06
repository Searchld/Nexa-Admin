package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnWxDept;

/**
 * YnWxDeptMapper接口
 */
public interface YnWxDeptMapper
{
    /**
     * 查询YnWxDept
     *
     * @param id 主键
     * @return YnWxDept
     */
    public YnWxDept selectYnWxDeptById(Long id);

    /**
     * 查询YnWxDept列表
     *
     * @param ynWxDept 查询条件
     * @return YnWxDept集合
     */
    public List<YnWxDept> selectYnWxDeptList(YnWxDept ynWxDept);

    /**
     * 新增YnWxDept
     *
     * @param ynWxDept YnWxDept
     * @return 结果
     */
    public int insertYnWxDept(YnWxDept ynWxDept);

    /**
     * 修改YnWxDept
     *
     * @param ynWxDept YnWxDept
     * @return 结果
     */
    public int updateYnWxDept(YnWxDept ynWxDept);

    /**
     * 删除YnWxDept
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnWxDeptById(Long id);

    /**
     * 批量删除YnWxDept
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnWxDeptByIds(Long[] ids);
}
