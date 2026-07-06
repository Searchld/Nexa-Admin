package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.SqTableEntity;
import com.ruoyi.sq.mapper.SqEntityMapper;
import com.ruoyi.sq.service.SqCrudService;
import com.ruoyi.sq.domain.ACarsLogsHis;
import com.ruoyi.sq.mapper.ACarsLogsHisMapper;
import com.ruoyi.sq.domain.AddStream;
import com.ruoyi.sq.mapper.AddStreamMapper;
import com.ruoyi.sq.domain.Alert;
import com.ruoyi.sq.mapper.AlertMapper;
import com.ruoyi.sq.domain.AlertInfo;
import com.ruoyi.sq.mapper.AlertInfoMapper;
import com.ruoyi.sq.domain.AlertReason;
import com.ruoyi.sq.mapper.AlertReasonMapper;
import com.ruoyi.sq.domain.Camera;
import com.ruoyi.sq.mapper.CameraMapper;
import com.ruoyi.sq.domain.CarNum;
import com.ruoyi.sq.mapper.CarNumMapper;
import com.ruoyi.sq.domain.Cars;
import com.ruoyi.sq.mapper.CarsMapper;
import com.ruoyi.sq.domain.CarsLogs;
import com.ruoyi.sq.mapper.CarsLogsMapper;
import com.ruoyi.sq.domain.CarsOutLogs;
import com.ruoyi.sq.mapper.CarsOutLogsMapper;
import com.ruoyi.sq.domain.Team;
import com.ruoyi.sq.mapper.TeamMapper;
import com.ruoyi.sq.domain.Visual;
import com.ruoyi.sq.mapper.VisualMapper;
import com.ruoyi.sq.domain.VisualCategory;
import com.ruoyi.sq.mapper.VisualCategoryMapper;
import com.ruoyi.sq.domain.VisualConfig;
import com.ruoyi.sq.mapper.VisualConfigMapper;
import com.ruoyi.sq.domain.VisualMap;
import com.ruoyi.sq.mapper.VisualMapMapper;
import com.ruoyi.sq.domain.YnCameraRecord;
import com.ruoyi.sq.mapper.YnCameraRecordMapper;
import com.ruoyi.sq.domain.YnLogsLevel;
import com.ruoyi.sq.mapper.YnLogsLevelMapper;
import com.ruoyi.sq.domain.YnLogsOut;
import com.ruoyi.sq.mapper.YnLogsOutMapper;
import com.ruoyi.sq.domain.YnRfid;
import com.ruoyi.sq.mapper.YnRfidMapper;
import com.ruoyi.sq.domain.YnRfidRecord;
import com.ruoyi.sq.mapper.YnRfidRecordMapper;
import com.ruoyi.sq.domain.YnRfidYdq;
import com.ruoyi.sq.mapper.YnRfidYdqMapper;
import com.ruoyi.sq.domain.YnSiren;
import com.ruoyi.sq.mapper.YnSirenMapper;
import com.ruoyi.sq.domain.YnTask;
import com.ruoyi.sq.mapper.YnTaskMapper;
import com.ruoyi.sq.domain.YnUser;
import com.ruoyi.sq.mapper.YnUserMapper;
import com.ruoyi.sq.domain.YnUserXj;
import com.ruoyi.sq.mapper.YnUserXjMapper;
import com.ruoyi.sq.domain.YnWxDept;
import com.ruoyi.sq.mapper.YnWxDeptMapper;
import com.ruoyi.sq.domain.YnWxSend;
import com.ruoyi.sq.mapper.YnWxSendMapper;
import com.ruoyi.sq.domain.YnWxUser;
import com.ruoyi.sq.mapper.YnWxUserMapper;

@Service
public class SqCrudServiceImpl implements SqCrudService
{
    private static class EntityOps
    {
        private final String code;
        private final String title;
        private final Class<?> type;
        private final SqEntityMapper mapper;

        private EntityOps(String code, String title, Class<?> type, SqEntityMapper mapper)
        {
            this.code = code;
            this.title = title;
            this.type = type;
            this.mapper = mapper;
        }
    }

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Map<String, EntityOps> registry = new HashMap<>();
    private final ACarsLogsHisMapper aCarsLogsHisMapper;
    private final AddStreamMapper addStreamMapper;
    private final AlertMapper alertMapper;
    private final AlertInfoMapper alertInfoMapper;
    private final AlertReasonMapper alertReasonMapper;
    private final CameraMapper cameraMapper;
    private final CarNumMapper carNumMapper;
    private final CarsMapper carsMapper;
    private final CarsLogsMapper carsLogsMapper;
    private final CarsOutLogsMapper carsOutLogsMapper;
    private final TeamMapper teamMapper;
    private final VisualMapper visualMapper;
    private final VisualCategoryMapper visualCategoryMapper;
    private final VisualConfigMapper visualConfigMapper;
    private final VisualMapMapper visualMapMapper;
    private final YnCameraRecordMapper ynCameraRecordMapper;
    private final YnLogsLevelMapper ynLogsLevelMapper;
    private final YnLogsOutMapper ynLogsOutMapper;
    private final YnRfidMapper ynRfidMapper;
    private final YnRfidRecordMapper ynRfidRecordMapper;
    private final YnRfidYdqMapper ynRfidYdqMapper;
    private final YnSirenMapper ynSirenMapper;
    private final YnTaskMapper ynTaskMapper;
    private final YnUserMapper ynUserMapper;
    private final YnUserXjMapper ynUserXjMapper;
    private final YnWxDeptMapper ynWxDeptMapper;
    private final YnWxSendMapper ynWxSendMapper;
    private final YnWxUserMapper ynWxUserMapper;

    public SqCrudServiceImpl(ACarsLogsHisMapper aCarsLogsHisMapper,
            AddStreamMapper addStreamMapper,
            AlertMapper alertMapper,
            AlertInfoMapper alertInfoMapper,
            AlertReasonMapper alertReasonMapper,
            CameraMapper cameraMapper,
            CarNumMapper carNumMapper,
            CarsMapper carsMapper,
            CarsLogsMapper carsLogsMapper,
            CarsOutLogsMapper carsOutLogsMapper,
            TeamMapper teamMapper,
            VisualMapper visualMapper,
            VisualCategoryMapper visualCategoryMapper,
            VisualConfigMapper visualConfigMapper,
            VisualMapMapper visualMapMapper,
            YnCameraRecordMapper ynCameraRecordMapper,
            YnLogsLevelMapper ynLogsLevelMapper,
            YnLogsOutMapper ynLogsOutMapper,
            YnRfidMapper ynRfidMapper,
            YnRfidRecordMapper ynRfidRecordMapper,
            YnRfidYdqMapper ynRfidYdqMapper,
            YnSirenMapper ynSirenMapper,
            YnTaskMapper ynTaskMapper,
            YnUserMapper ynUserMapper,
            YnUserXjMapper ynUserXjMapper,
            YnWxDeptMapper ynWxDeptMapper,
            YnWxSendMapper ynWxSendMapper,
            YnWxUserMapper ynWxUserMapper)
    {
        this.aCarsLogsHisMapper = aCarsLogsHisMapper;
        this.addStreamMapper = addStreamMapper;
        this.alertMapper = alertMapper;
        this.alertInfoMapper = alertInfoMapper;
        this.alertReasonMapper = alertReasonMapper;
        this.cameraMapper = cameraMapper;
        this.carNumMapper = carNumMapper;
        this.carsMapper = carsMapper;
        this.carsLogsMapper = carsLogsMapper;
        this.carsOutLogsMapper = carsOutLogsMapper;
        this.teamMapper = teamMapper;
        this.visualMapper = visualMapper;
        this.visualCategoryMapper = visualCategoryMapper;
        this.visualConfigMapper = visualConfigMapper;
        this.visualMapMapper = visualMapMapper;
        this.ynCameraRecordMapper = ynCameraRecordMapper;
        this.ynLogsLevelMapper = ynLogsLevelMapper;
        this.ynLogsOutMapper = ynLogsOutMapper;
        this.ynRfidMapper = ynRfidMapper;
        this.ynRfidRecordMapper = ynRfidRecordMapper;
        this.ynRfidYdqMapper = ynRfidYdqMapper;
        this.ynSirenMapper = ynSirenMapper;
        this.ynTaskMapper = ynTaskMapper;
        this.ynUserMapper = ynUserMapper;
        this.ynUserXjMapper = ynUserXjMapper;
        this.ynWxDeptMapper = ynWxDeptMapper;
        this.ynWxSendMapper = ynWxSendMapper;
        this.ynWxUserMapper = ynWxUserMapper;
        register("aCarsLogsHis", "ACarsLogsHis", ACarsLogsHis.class, aCarsLogsHisMapper);
        register("addStream", "AddStream", AddStream.class, addStreamMapper);
        register("alert", "Alert", Alert.class, alertMapper);
        register("alertInfo", "AlertInfo", AlertInfo.class, alertInfoMapper);
        register("alertReason", "AlertReason", AlertReason.class, alertReasonMapper);
        register("camera", "Camera", Camera.class, cameraMapper);
        register("carNum", "CarNum", CarNum.class, carNumMapper);
        register("cars", "Cars", Cars.class, carsMapper);
        register("carsLogs", "CarsLogs", CarsLogs.class, carsLogsMapper);
        register("carsOutLogs", "CarsOutLogs", CarsOutLogs.class, carsOutLogsMapper);
        register("team", "Team", Team.class, teamMapper);
        register("visual", "Visual", Visual.class, visualMapper);
        register("visualCategory", "VisualCategory", VisualCategory.class, visualCategoryMapper);
        register("visualConfig", "VisualConfig", VisualConfig.class, visualConfigMapper);
        register("visualMap", "VisualMap", VisualMap.class, visualMapMapper);
        register("ynCameraRecord", "YnCameraRecord", YnCameraRecord.class, ynCameraRecordMapper);
        register("ynLogsLevel", "YnLogsLevel", YnLogsLevel.class, ynLogsLevelMapper);
        register("ynLogsOut", "YnLogsOut", YnLogsOut.class, ynLogsOutMapper);
        register("ynRfid", "YnRfid", YnRfid.class, ynRfidMapper);
        register("ynRfidRecord", "YnRfidRecord", YnRfidRecord.class, ynRfidRecordMapper);
        register("ynRfidYdq", "YnRfidYdq", YnRfidYdq.class, ynRfidYdqMapper);
        register("ynSiren", "YnSiren", YnSiren.class, ynSirenMapper);
        register("ynTask", "YnTask", YnTask.class, ynTaskMapper);
        register("ynUser", "YnUser", YnUser.class, ynUserMapper);
        register("ynUserXj", "YnUserXj", YnUserXj.class, ynUserXjMapper);
        register("ynWxDept", "YnWxDept", YnWxDept.class, ynWxDeptMapper);
        register("ynWxSend", "YnWxSend", YnWxSend.class, ynWxSendMapper);
        register("ynWxUser", "YnWxUser", YnWxUser.class, ynWxUserMapper);
    }

    private void register(String code, String title, Class<?> type, SqEntityMapper mapper)
    {
        EntityOps ops = new EntityOps(code, title, type, mapper);
        registry.put(code, ops);
        registry.put(title, ops);
    }

    private EntityOps ops(String entityKey)
    {
        EntityOps ops = registry.get(entityKey);
        if (ops == null)
        {
            throw new IllegalArgumentException("未知 sq 实体: " + entityKey);
        }
        return ops;
    }

    private Object convert(EntityOps ops, Map<String, ?> source)
    {
        Map<String, Object> copy = new LinkedHashMap<>();
        if (source != null)
        {
            source.forEach((key, value) -> {
                if (value != null && !"".equals(value)) copy.put(key, value);
            });
        }
        return objectMapper.convertValue(copy, ops.type);
    }

    @Override
    public List<?> list(String entityKey, Map<String, ?> params)
    {
        EntityOps ops = ops(entityKey);
        return ops.mapper.selectList(convert(ops, params));
    }

    @Override
    public List<Map<String, Object>> mapList(String entityKey, Map<String, ?> params)
    {
        EntityOps ops = ops(entityKey);
        return ops.mapper.selectMapList(convert(ops, params));
    }

    @Override
    public Object get(String entityKey, Object id)
    {
        return ops(entityKey).mapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object create(String entityKey, Map<String, ?> body)
    {
        EntityOps ops = ops(entityKey);
        Object entity = convert(ops, body);
        fillCreate(entity);
        ops.mapper.insert(entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(String entityKey, Map<String, ?> body)
    {
        EntityOps ops = ops(entityKey);
        Object entity = convert(ops, body);
        fillUpdate(entity);
        return ops.mapper.update(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(String entityKey, Object[] ids)
    {
        EntityOps ops = ops(entityKey);
        try
        {
            return ops.mapper.softDeleteByIds(ids);
        }
        catch (Exception ignored)
        {
            return ops.mapper.deleteByIds(ids);
        }
    }

    @Override
    public Object special(String entityKey, String operation, Map<String, ?> params, Map<String, ?> body, Map<String, String> pathVars)
    {
        if ("select".equals(operation) || "all".equals(operation) || "listAll".equals(operation))
        {
            return mapList(entityKey, params);
        }
        if ("detail".equals(operation) && params != null && params.get("id") != null)
        {
            return get(entityKey, params.get("id"));
        }
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("operation", operation);
        result.put("entity", entityKey);
        result.put("params", params == null ? Collections.emptyMap() : params);
        result.put("pathVars", pathVars == null ? Collections.emptyMap() : pathVars);
        result.put("message", "该旧系统专项接口已迁入 RuoYi 路径，业务细节需配置外部服务后启用");
        return result;
    }

    private void fillCreate(Object entity)
    {
        setIfPresent(entity, "setCreateUser", String.valueOf(SecurityUtils.getUserId()));
        setIfPresent(entity, "setCreateTime", new Timestamp(System.currentTimeMillis()));
        setIfPresent(entity, "setIsDeleted", "0");
    }

    private void fillUpdate(Object entity)
    {
        setIfPresent(entity, "setUpdateUser", String.valueOf(SecurityUtils.getUserId()));
        setIfPresent(entity, "setUpdateTime", new Timestamp(System.currentTimeMillis()));
    }

    private void setIfPresent(Object entity, String methodName, Object value)
    {
        for (java.lang.reflect.Method method : entity.getClass().getMethods())
        {
            if (!method.getName().equals(methodName) || method.getParameterCount() != 1) continue;
            try
            {
                method.invoke(entity, value);
            }
            catch (Exception ignored)
            {
            }
            return;
        }
    }
}
