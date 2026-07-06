package com.ruoyi.sq.service;

import java.util.List;
import com.ruoyi.sq.domain.Camera;

/**
 * CameraService接口
 */
public interface ICameraService
{
    /** 查询Camera */
    public Camera selectCameraById(Long id);

    /** 查询Camera列表 */
    public List<Camera> selectCameraList(Camera camera);

    /** 新增Camera */
    public int insertCamera(Camera camera);

    /** 修改Camera */
    public int updateCamera(Camera camera);

    /** 批量删除Camera */
    public int deleteCameraByIds(Long[] ids);

    /** 删除Camera信息 */
    public int deleteCameraById(Long id);
}
