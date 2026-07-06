package com.ruoyi.sq.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.sq.domain.SqTableEntity;

public interface SqCrudService
{
    List<?> list(String entityKey, Map<String, ?> params);
    List<Map<String, Object>> mapList(String entityKey, Map<String, ?> params);
    Object get(String entityKey, Object id);
    Object create(String entityKey, Map<String, ?> body);
    int update(String entityKey, Map<String, ?> body);
    int delete(String entityKey, Object[] ids);
    Object special(String entityKey, String operation, Map<String, ?> params, Map<String, ?> body, Map<String, String> pathVars);
}
