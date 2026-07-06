package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.AddStream;

/**
 * AddStreamService接口
 */
public interface IAddStreamService
{
    /** 查询AddStream */
    public AddStream selectAddStreamById(Long id);

    /** 查询AddStream列表 */
    public List<AddStream> selectAddStreamList(AddStream addStream);

    /** 新增AddStream */
    public int insertAddStream(AddStream addStream);

    /** 修改AddStream */
    public int updateAddStream(AddStream addStream);

    /** 批量删除AddStream */
    public int deleteAddStreamByIds(Long[] ids);

    /** 删除AddStream信息 */
    public int deleteAddStreamById(Long id);
}
