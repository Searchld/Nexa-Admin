package com.ruoyi.sq.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface SqEntityMapper<T>
{
    T selectById(@Param("id") Object id);
    List<T> selectList(T criteria);
    int insert(T entity);
    int update(T entity);
    int deleteByIds(@Param("ids") Object[] ids);
    int softDeleteByIds(@Param("ids") Object[] ids);
    List<Map<String, Object>> selectMapList(T criteria);
}
