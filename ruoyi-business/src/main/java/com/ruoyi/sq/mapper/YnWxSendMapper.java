package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnWxSend;

/**
 * YnWxSendMapper接口
 */
public interface YnWxSendMapper
{
    /**
     * 查询YnWxSend
     *
     * @param id 主键
     * @return YnWxSend
     */
    public YnWxSend selectYnWxSendById(Long id);

    /**
     * 查询YnWxSend列表
     *
     * @param ynWxSend 查询条件
     * @return YnWxSend集合
     */
    public List<YnWxSend> selectYnWxSendList(YnWxSend ynWxSend);

    /**
     * 新增YnWxSend
     *
     * @param ynWxSend YnWxSend
     * @return 结果
     */
    public int insertYnWxSend(YnWxSend ynWxSend);

    /**
     * 修改YnWxSend
     *
     * @param ynWxSend YnWxSend
     * @return 结果
     */
    public int updateYnWxSend(YnWxSend ynWxSend);

    /**
     * 删除YnWxSend
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnWxSendById(Long id);

    /**
     * 批量删除YnWxSend
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnWxSendByIds(Long[] ids);
}
