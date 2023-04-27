package com.zhy.selfdev.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.selfdev.mapper.ZhySelfdevDeviceRegistrationMapper;
import com.zhy.selfdev.domain.ZhySelfdevDeviceRegistration;
import com.zhy.selfdev.service.IZhySelfdevDeviceRegistrationService;

/**
 * 设备注册Service业务层处理
 *
 * @author zhy
 * @date 2023-04-22
 */
@Service
public class ZhySelfdevDeviceRegistrationServiceImpl implements IZhySelfdevDeviceRegistrationService
{
    @Autowired
    private ZhySelfdevDeviceRegistrationMapper zhySelfdevDeviceRegistrationMapper;

    /**
     * 查询设备注册
     *
     * @param deviceId 设备注册主键
     * @return 设备注册
     */
    @Override
    public ZhySelfdevDeviceRegistration selectZhySelfdevDeviceRegistrationByDeviceId(String deviceId)
    {
        return zhySelfdevDeviceRegistrationMapper.selectZhySelfdevDeviceRegistrationByDeviceId(deviceId);
    }

    /**
     * 查询设备注册列表
     *
     * @param zhySelfdevDeviceRegistration 设备注册
     * @return 设备注册
     */
    @Override
    public List<ZhySelfdevDeviceRegistration> selectZhySelfdevDeviceRegistrationList(ZhySelfdevDeviceRegistration zhySelfdevDeviceRegistration)
    {
        return zhySelfdevDeviceRegistrationMapper.selectZhySelfdevDeviceRegistrationList(zhySelfdevDeviceRegistration);
    }

    /**
     * 新增设备注册
     *
     * @param zhySelfdevDeviceRegistration 设备注册
     * @return 结果
     */
    @Override
    public int insertZhySelfdevDeviceRegistration(ZhySelfdevDeviceRegistration zhySelfdevDeviceRegistration)
    {
        return zhySelfdevDeviceRegistrationMapper.insertZhySelfdevDeviceRegistration(zhySelfdevDeviceRegistration);
    }

    /**
     * 修改设备注册
     *
     * @param zhySelfdevDeviceRegistration 设备注册
     * @return 结果
     */
    @Override
    public int updateZhySelfdevDeviceRegistration(ZhySelfdevDeviceRegistration zhySelfdevDeviceRegistration)
    {
        return zhySelfdevDeviceRegistrationMapper.updateZhySelfdevDeviceRegistration(zhySelfdevDeviceRegistration);
    }

    /**
     * 批量删除设备注册
     *
     * @param deviceIds 需要删除的设备注册主键
     * @return 结果
     */
    @Override
    public int deleteZhySelfdevDeviceRegistrationByDeviceIds(String[] deviceIds)
    {
        return zhySelfdevDeviceRegistrationMapper.deleteZhySelfdevDeviceRegistrationByDeviceIds(deviceIds);
    }

    /**
     * 删除设备注册信息
     *
     * @param deviceId 设备注册主键
     * @return 结果
     */
    @Override
    public int deleteZhySelfdevDeviceRegistrationByDeviceId(String deviceId)
    {
        return zhySelfdevDeviceRegistrationMapper.deleteZhySelfdevDeviceRegistrationByDeviceId(deviceId);
    }
}
