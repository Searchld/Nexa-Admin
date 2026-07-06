package com.ruoyi.sq.mapper;

import java.util.List;
import com.ruoyi.sq.domain.Camera;

/**
 * CameraMapper接口
 */
public interface CameraMapper
{
    /**
     * 查询Camera
     *
     * @param id 主键
     * @return Camera
     */
    public Camera selectCameraById(Long id);

    /**
     * 查询Camera列表
     *
     * @param camera 查询条件
     * @return Camera集合
     */
    public List<Camera> selectCameraList(Camera camera);

    /**
     * 新增Camera
     *
     * @param camera Camera
     * @return 结果
     */
    public int insertCamera(Camera camera);

    /**
     * 修改Camera
     *
     * @param camera Camera
     * @return 结果
     */
    public int updateCamera(Camera camera);

    /**
     * 删除Camera
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteCameraById(Long id);

    /**
     * 批量删除Camera
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCameraByIds(Long[] ids);
}
