package com.zhy.datapersist.service;

import com.zhy.datapersist.domain.ZhySelfdevDeviceRegistrationLog;

import java.util.List;

/**
 * 设备注册日志Service接口
 *
 * @author zhy
 * @date 2023-04-22
 */
public interface IZhySelfdevDeviceRegistrationLogService
{
    /**
     * 查询设备注册日志列表
     *
     * @param zhySelfdevDeviceRegistrationLog 设备注册日志
     * @return 设备注册集合
     */
    public List<ZhySelfdevDeviceRegistrationLog> selectZhySelfdevDeviceRegistrationLogList(ZhySelfdevDeviceRegistrationLog zhySelfdevDeviceRegistrationLog);

    /**
     * 新增设备注册日志
     *
     * @param zhySelfdevDeviceRegistrationLog 设备注册日志
     * @return 结果
     */
    public int insertZhySelfdevDeviceRegistrationLog(ZhySelfdevDeviceRegistrationLog zhySelfdevDeviceRegistrationLog);


    /**
     * 删除设备注册日志
     *
     * @param id 设备注册日志主键
     * @return 结果
     */
    public int deleteZhySelfdevDeviceRegistrationLogByLogId(Integer id);

    /**
     * 批量删除设备注册日志
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZhySelfdevDeviceRegistrationLogByLogIds(Integer[] ids);
}
