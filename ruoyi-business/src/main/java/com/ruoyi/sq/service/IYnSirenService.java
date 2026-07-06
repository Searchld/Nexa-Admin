package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnSiren;

/**
 * YnSirenService接口
 */
public interface IYnSirenService
{
    /** 查询YnSiren */
    public YnSiren selectYnSirenById(Integer id);

    /** 查询YnSiren列表 */
    public List<YnSiren> selectYnSirenList(YnSiren ynSiren);

    /** 新增YnSiren */
    public int insertYnSiren(YnSiren ynSiren);

    /** 修改YnSiren */
    public int updateYnSiren(YnSiren ynSiren);

    /** 批量删除YnSiren */
    public int deleteYnSirenByIds(Integer[] ids);

    /** 删除YnSiren信息 */
    public int deleteYnSirenById(Integer id);
}
