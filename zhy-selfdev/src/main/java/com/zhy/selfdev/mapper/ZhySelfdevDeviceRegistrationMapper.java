package com.zhy.selfdev.mapper;

import java.util.List;
import com.zhy.selfdev.domain.ZhySelfdevDeviceRegistration;

/**
 * 设备注册Mapper接口
 * 
 * @author zhy
 * @date 2023-04-22
 */
public interface ZhySelfdevDeviceRegistrationMapper 
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
     * 删除设备注册
     * 
     * @param deviceId 设备注册主键
     * @return 结果
     */
    public int deleteZhySelfdevDeviceRegistrationByDeviceId(String deviceId);

    /**
     * 批量删除设备注册
     * 
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZhySelfdevDeviceRegistrationByDeviceIds(String[] deviceIds);
}
