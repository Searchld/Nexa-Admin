package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.YnWxUser;

/**
 * YnWxUserMapper接口
 */
public interface YnWxUserMapper
{
    /**
     * 查询YnWxUser
     *
     * @param id 主键
     * @return YnWxUser
     */
    public YnWxUser selectYnWxUserById(Long id);

    /**
     * 查询YnWxUser列表
     *
     * @param ynWxUser 查询条件
     * @return YnWxUser集合
     */
    public List<YnWxUser> selectYnWxUserList(YnWxUser ynWxUser);

    /**
     * 新增YnWxUser
     *
     * @param ynWxUser YnWxUser
     * @return 结果
     */
    public int insertYnWxUser(YnWxUser ynWxUser);

    /**
     * 修改YnWxUser
     *
     * @param ynWxUser YnWxUser
     * @return 结果
     */
    public int updateYnWxUser(YnWxUser ynWxUser);

    /**
     * 删除YnWxUser
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteYnWxUserById(Long id);

    /**
     * 批量删除YnWxUser
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYnWxUserByIds(Long[] ids);
}
