package com.zhy.datapersist.service;

import java.util.List;
import com.zhy.datapersist.domain.ZhySelfdevDeviceRegistration;

/**
 * 设备注册Service接口
 *
 * @author zhy
 * @date 2023-04-22
 */
public interface IZhySelfdevDeviceRegistrationService
{
    /**
     * 查询设备注册
     *
     * @param deviceId 设备注册主键
     * @return 设备注册
     */
    public ZhySelfdevDeviceRegistration selectZhySelfdevDeviceRegistrationByDeviceId(String deviceId);

    /**
     * 查询设备注册列表
     *
     * @param zhySelfdevDeviceRegistration 设备注册
     * @return 设备注册集合
     */
    public List<ZhySelfdevDeviceRegistration> selectZhySelfdevDeviceRegistrationList(ZhySelfdevDeviceRegistration zhySelfdevDeviceRegistration);

    /**
     * 新增设备注册
     *
     * @param zhySelfdevDeviceRegistration 设备注册
     * @return 结果
     */
    public int insertZhySelfdevDeviceRegistration(ZhySelfdevDeviceRegistration zhySelfdevDeviceRegistration);

    /**
     * 修改设备注册
     *
     * @param zhySelfdevDeviceRegistration 设备注册
     * @return 结果
     */
    public int updateZhySelfdevDeviceRegistration(ZhySelfdevDeviceRegistration zhySelfdevDeviceRegistration);

    /**
     * 批量删除设备注册
     *
     * @param deviceIds 需要删除的设备注册主键集合
     * @return 结果
     */
    public int deleteZhySelfdevDeviceRegistrationByDeviceIds(String[] deviceIds);

    /**
     * 删除设备注册信息
     *
     * @param deviceId 设备注册主键
     * @return 结果
     */
    public int deleteZhySelfdevDeviceRegistrationByDeviceId(String deviceId);
}
