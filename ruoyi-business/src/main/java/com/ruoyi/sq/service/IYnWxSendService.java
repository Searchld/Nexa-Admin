package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnWxSend;

/**
 * YnWxSendService接口
 */
public interface IYnWxSendService
{
    /** 查询YnWxSend */
    public YnWxSend selectYnWxSendById(Long id);

    /** 查询YnWxSend列表 */
    public List<YnWxSend> selectYnWxSendList(YnWxSend ynWxSend);

    /** 新增YnWxSend */
    public int insertYnWxSend(YnWxSend ynWxSend);

    /** 修改YnWxSend */
    public int updateYnWxSend(YnWxSend ynWxSend);

    /** 批量删除YnWxSend */
    public int deleteYnWxSendByIds(Long[] ids);

    /** 删除YnWxSend信息 */
    public int deleteYnWxSendById(Long id);
}
