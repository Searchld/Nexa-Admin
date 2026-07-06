package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.ACarsLogsHis;
import com.ruoyi.sq.mapper.ACarsLogsHisMapper;
import com.ruoyi.sq.service.IACarsLogsHisService;

/**
 * ACarsLogsHisService业务层处理
 */
@Service
public class ACarsLogsHisServiceImpl implements IACarsLogsHisService
{
    @Autowired
    private ACarsLogsHisMapper aCarsLogsHisMapper;

    @Override
    public ACarsLogsHis selectACarsLogsHisById(Long id)
    {
        return aCarsLogsHisMapper.selectACarsLogsHisById(id);
    }

    @Override
    public List<ACarsLogsHis> selectACarsLogsHisList(ACarsLogsHis aCarsLogsHis)
    {
        return aCarsLogsHisMapper.selectACarsLogsHisList(aCarsLogsHis);
    }

    @Override
    public int insertACarsLogsHis(ACarsLogsHis aCarsLogsHis)
    {
        aCarsLogsHis.setCreateTime(Timestamp.from(Instant.now()));
        aCarsLogsHis.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        aCarsLogsHis.setIsDeleted("0");
        return aCarsLogsHisMapper.insertACarsLogsHis(aCarsLogsHis);
    }

    @Override
    public int updateACarsLogsHis(ACarsLogsHis aCarsLogsHis)
    {
        aCarsLogsHis.setUpdateTime(Timestamp.from(Instant.now()));
        aCarsLogsHis.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return aCarsLogsHisMapper.updateACarsLogsHis(aCarsLogsHis);
    }

    @Override
    public int deleteACarsLogsHisByIds(Long[] ids)
    {
        return aCarsLogsHisMapper.deleteACarsLogsHisByIds(ids);
    }

    @Override
    public int deleteACarsLogsHisById(Long id)
    {
        return aCarsLogsHisMapper.deleteACarsLogsHisById(id);
    }

    private Long getUserId()
    {
        try
        {
            return SecurityUtils.getUserId();
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
