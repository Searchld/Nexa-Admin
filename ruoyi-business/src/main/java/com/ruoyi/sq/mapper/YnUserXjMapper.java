package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnUserXj;

/**
 * YnUserXjMapper接口
 */
public interface YnUserXjMapper
{
    /**
     * 查询YnUserXj
     *
     * @param id 主键
     * @return YnUserXj
     */
    public YnUserXj selectYnUserXjById(Long id);

    /**
     * 查询YnUserXj列表
     *
     * @param ynUserXj 查询条件
     * @return YnUserXj集合
     */
    public List<YnUserXj> selectYnUserXjList(YnUserXj ynUserXj);

    /**
     * 新增YnUserXj
     *
     * @param ynUserXj YnUserXj
     * @return 结果
     */
    public int insertYnUserXj(YnUserXj ynUserXj);

    /**
     * 修改YnUserXj
     *
     * @param ynUserXj YnUserXj
     * @return 结果
     */
    public int updateYnUserXj(YnUserXj ynUserXj);

    /**
     * 删除YnUserXj
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnUserXjById(Long id);

    /**
     * 批量删除YnUserXj
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnUserXjByIds(Long[] ids);
}
