package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnUser;

/**
 * YnUserMapper接口
 */
public interface YnUserMapper
{
    /**
     * 查询YnUser
     *
     * @param id 主键
     * @return YnUser
     */
    public YnUser selectYnUserById(Long id);

    /**
     * 查询YnUser列表
     *
     * @param ynUser 查询条件
     * @return YnUser集合
     */
    public List<YnUser> selectYnUserList(YnUser ynUser);

    /**
     * 新增YnUser
     *
     * @param ynUser YnUser
     * @return 结果
     */
    public int insertYnUser(YnUser ynUser);

    /**
     * 修改YnUser
     *
     * @param ynUser YnUser
     * @return 结果
     */
    public int updateYnUser(YnUser ynUser);

    /**
     * 删除YnUser
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnUserById(Long id);

    /**
     * 批量删除YnUser
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnUserByIds(Long[] ids);
}
