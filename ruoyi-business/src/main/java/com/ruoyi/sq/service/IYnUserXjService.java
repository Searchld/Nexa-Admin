package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnUserXj;

/**
 * YnUserXjService接口
 */
public interface IYnUserXjService
{
    /** 查询YnUserXj */
    public YnUserXj selectYnUserXjById(Long id);

    /** 查询YnUserXj列表 */
    public List<YnUserXj> selectYnUserXjList(YnUserXj ynUserXj);

    /** 新增YnUserXj */
    public int insertYnUserXj(YnUserXj ynUserXj);

    /** 修改YnUserXj */
    public int updateYnUserXj(YnUserXj ynUserXj);

    /** 批量删除YnUserXj */
    public int deleteYnUserXjByIds(Long[] ids);

    /** 删除YnUserXj信息 */
    public int deleteYnUserXjById(Long id);
}
