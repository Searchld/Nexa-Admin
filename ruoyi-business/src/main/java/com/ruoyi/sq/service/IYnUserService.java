package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.YnUser;

/**
 * YnUserService接口
 */
public interface IYnUserService
{
    /** 查询YnUser */
    public YnUser selectYnUserById(Long id);

    /** 查询YnUser列表 */
    public List<YnUser> selectYnUserList(YnUser ynUser);

    /** 新增YnUser */
    public int insertYnUser(YnUser ynUser);

    /** 修改YnUser */
    public int updateYnUser(YnUser ynUser);

    /** 批量删除YnUser */
    public int deleteYnUserByIds(Long[] ids);

    /** 删除YnUser信息 */
    public int deleteYnUserById(Long id);
}
