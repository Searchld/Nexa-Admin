package com.ruoyi.sq.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.sq.domain.Camera;
import com.ruoyi.sq.mapper.CameraMapper;
import com.ruoyi.sq.service.ICameraService;

/**
 * CameraService业务层处理
 */
@Service
public class CameraServiceImpl implements ICameraService
{
    @Autowired
    private CameraMapper cameraMapper;

    @Override
    public Camera selectCameraById(Long id)
    {
        return cameraMapper.selectCameraById(id);
    }

    @Override
    public List<Camera> selectCameraList(Camera camera)
    {
        return cameraMapper.selectCameraList(camera);
    }

    @Override
    public int insertCamera(Camera camera)
    {
        camera.setCreateTime(Timestamp.from(Instant.now()));
        camera.setCreateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        camera.setIsDeleted("0");
        return cameraMapper.insertCamera(camera);
    }

    @Override
    public int updateCamera(Camera camera)
    {
        camera.setUpdateTime(Timestamp.from(Instant.now()));
        camera.setUpdateUser(getUserId() == null ? null : String.valueOf(getUserId()));
        return cameraMapper.updateCamera(camera);
    }

    @Override
    public int deleteCameraByIds(Long[] ids)
    {
        return cameraMapper.deleteCameraByIds(ids);
    }

    @Override
    public int deleteCameraById(Long id)
    {
        return cameraMapper.deleteCameraById(id);
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
