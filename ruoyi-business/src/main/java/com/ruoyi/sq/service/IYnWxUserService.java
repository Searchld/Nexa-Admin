package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnWxUser;

/**
 * YnWxUserService接口
 */
public interface IYnWxUserService
{
    /** 查询YnWxUser */
    public YnWxUser selectYnWxUserById(Long id);

    /** 查询YnWxUser列表 */
    public List<YnWxUser> selectYnWxUserList(YnWxUser ynWxUser);

    /** 新增YnWxUser */
    public int insertYnWxUser(YnWxUser ynWxUser);

    /** 修改YnWxUser */
    public int updateYnWxUser(YnWxUser ynWxUser);

    /** 批量删除YnWxUser */
    public int deleteYnWxUserByIds(Long[] ids);

    /** 删除YnWxUser信息 */
    public int deleteYnWxUserById(Long id);
}
