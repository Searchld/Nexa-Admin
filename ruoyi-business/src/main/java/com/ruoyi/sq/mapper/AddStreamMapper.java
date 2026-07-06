package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.AddStream;

/**
 * AddStreamMapper接口
 */
public interface AddStreamMapper
{
    /**
     * 查询AddStream
     *
     * @param id 主键
     * @return AddStream
     */
    public AddStream selectAddStreamById(Long id);

    /**
     * 查询AddStream列表
     *
     * @param addStream 查询条件
     * @return AddStream集合
     */
    public List<AddStream> selectAddStreamList(AddStream addStream);

    /**
     * 新增AddStream
     *
     * @param addStream AddStream
     * @return 结果
     */
    public int insertAddStream(AddStream addStream);

    /**
     * 修改AddStream
     *
     * @param addStream AddStream
     * @return 结果
     */
    public int updateAddStream(AddStream addStream);

    /**
     * 删除AddStream
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteAddStreamById(Long id);

    /**
     * 批量删除AddStream
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAddStreamByIds(Long[] ids);
}
