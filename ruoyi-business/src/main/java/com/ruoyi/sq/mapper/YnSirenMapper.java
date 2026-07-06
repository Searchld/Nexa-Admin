package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnSiren;

/**
 * YnSirenMapper接口
 */
public interface YnSirenMapper
{
    /**
     * 查询YnSiren
     *
     * @param id 主键
     * @return YnSiren
     */
    public YnSiren selectYnSirenById(Integer id);

    /**
     * 查询YnSiren列表
     *
     * @param ynSiren 查询条件
     * @return YnSiren集合
     */
    public List<YnSiren> selectYnSirenList(YnSiren ynSiren);

    /**
     * 新增YnSiren
     *
     * @param ynSiren YnSiren
     * @return 结果
     */
    public int insertYnSiren(YnSiren ynSiren);

    /**
     * 修改YnSiren
     *
     * @param ynSiren YnSiren
     * @return 结果
     */
    public int updateYnSiren(YnSiren ynSiren);

    /**
     * 删除YnSiren
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnSirenById(Integer id);

    /**
     * 批量删除YnSiren
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnSirenByIds(Integer[] ids);
}
