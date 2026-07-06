package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.ACarsLogsHis;

/**
 * ACarsLogsHisService接口
 */
public interface IACarsLogsHisService
{
    /** 查询ACarsLogsHis */
    public ACarsLogsHis selectACarsLogsHisById(Long id);

    /** 查询ACarsLogsHis列表 */
    public List<ACarsLogsHis> selectACarsLogsHisList(ACarsLogsHis aCarsLogsHis);

    /** 新增ACarsLogsHis */
    public int insertACarsLogsHis(ACarsLogsHis aCarsLogsHis);

    /** 修改ACarsLogsHis */
    public int updateACarsLogsHis(ACarsLogsHis aCarsLogsHis);

    /** 批量删除ACarsLogsHis */
    public int deleteACarsLogsHisByIds(Long[] ids);

    /** 删除ACarsLogsHis信息 */
    public int deleteACarsLogsHisById(Long id);
}
