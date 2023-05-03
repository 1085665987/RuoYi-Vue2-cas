package com.zhy.datapersist.service.impl;

import com.zhy.datapersist.domain.ZhySelfdevDeviceRegistrationLog;
import com.zhy.datapersist.mapper.ZhySelfdevDeviceRegistrationLogMapper;
import com.zhy.datapersist.service.IZhySelfdevDeviceRegistrationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZhySelfdevDeviceRegistrationLogServiceImpl implements IZhySelfdevDeviceRegistrationLogService {

    @Autowired
    private ZhySelfdevDeviceRegistrationLogMapper zhySelfdevDeviceRegistrationLogMapper;

    /**
     * 查询设备注册日志列表
     *
     * @param zhySelfdevDeviceRegistrationLog 设备注册日志
     * @return 设备注册集合
     */
    @Override
    public List<ZhySelfdevDeviceRegistrationLog> selectZhySelfdevDeviceRegistrationLogList(ZhySelfdevDeviceRegistrationLog zhySelfdevDeviceRegistrationLog) {
        return zhySelfdevDeviceRegistrationLogMapper.selectZhySelfdevDeviceRegistrationLogList(zhySelfdevDeviceRegistrationLog);
    }

    /**
     * 新增设备注册日志
     *
     * @param zhySelfdevDeviceRegistrationLog 设备注册日志
     * @return 结果
     */
    @Override
    public int insertZhySelfdevDeviceRegistrationLog(ZhySelfdevDeviceRegistrationLog zhySelfdevDeviceRegistrationLog) {
        return zhySelfdevDeviceRegistrationLogMapper.insertZhySelfdevDeviceRegistrationLog(zhySelfdevDeviceRegistrationLog);
    }

    /**
     * 删除设备注册日志
     *
     * @param id 设备注册日志主键
     * @return 结果
     */
    @Override
    public int deleteZhySelfdevDeviceRegistrationLogByLogId(Integer id) {
        return zhySelfdevDeviceRegistrationLogMapper.deleteZhySelfdevDeviceRegistrationLogByLogId(id);
    }

    /**
     * 批量删除设备注册日志
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    @Override
    public int deleteZhySelfdevDeviceRegistrationLogByLogIds(Integer[] ids) {
        return zhySelfdevDeviceRegistrationLogMapper.deleteZhySelfdevDeviceRegistrationLogByLogIds(ids);
    }
}
