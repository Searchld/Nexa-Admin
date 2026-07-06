package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.ACarsLogsHis;

/**
 * ACarsLogsHisMapper接口
 */
public interface ACarsLogsHisMapper
{
    /**
     * 查询ACarsLogsHis
     *
     * @param id 主键
     * @return ACarsLogsHis
     */
    public ACarsLogsHis selectACarsLogsHisById(Long id);

    /**
     * 查询ACarsLogsHis列表
     *
     * @param aCarsLogsHis 查询条件
     * @return ACarsLogsHis集合
     */
    public List<ACarsLogsHis> selectACarsLogsHisList(ACarsLogsHis aCarsLogsHis);

    /**
     * 新增ACarsLogsHis
     *
     * @param aCarsLogsHis ACarsLogsHis
     * @return 结果
     */
    public int insertACarsLogsHis(ACarsLogsHis aCarsLogsHis);

    /**
     * 修改ACarsLogsHis
     *
     * @param aCarsLogsHis ACarsLogsHis
     * @return 结果
     */
    public int updateACarsLogsHis(ACarsLogsHis aCarsLogsHis);

    /**
     * 删除ACarsLogsHis
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteACarsLogsHisById(Long id);

    /**
     * 批量删除ACarsLogsHis
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteACarsLogsHisByIds(Long[] ids);
}
