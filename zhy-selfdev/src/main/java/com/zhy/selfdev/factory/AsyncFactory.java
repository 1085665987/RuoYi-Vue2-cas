package com.zhy.selfdev.factory;

import com.zhy.common.utils.spring.SpringUtils;
import com.zhy.datapersist.domain.ZhySelfdevMessageLog;
import com.zhy.datapersist.domain.ZhySelfdevDeviceRegistration;
import com.zhy.datapersist.domain.ZhySelfdevDeviceRegistrationLog;
import com.zhy.datapersist.service.IZhySelfdevDeviceRegistrationLogService;
import com.zhy.datapersist.service.IZhySelfdevMessageLogService;
import com.zhy.selfdev.enums.MessageDirection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author zhy
 */
public class AsyncFactory
{
    private static final Logger zhyuav_sys_user_logger = LoggerFactory.getLogger("zhyuav-sys-user");

    /**
     * 记录设备注册信息
     *
     * @return 任务task
     */
    public static TimerTask recordDeviceRegistrationMessageLog(
            final ZhySelfdevDeviceRegistration selfdevDeviceRegistration,
            final int regStatus,
            final String content)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                // 设备IP
                String deviceIp = selfdevDeviceRegistration.getDeviceIp();
                // 名称
                String deviceName = selfdevDeviceRegistration.getDeviceName();
                // 设备id
                String deviceId = selfdevDeviceRegistration.getDeviceId();
                // 设备类型
                Short deviceType = selfdevDeviceRegistration.getDeviceType();
                // 别名
                String aliases = selfdevDeviceRegistration.getAliases();
                // 状态
                Integer status = selfdevDeviceRegistration.getStatus();
                // 注册时间
                Date time = selfdevDeviceRegistration.getTime();
                // 创造时间
                Date createTime = new Date();

                ZhySelfdevDeviceRegistrationLog registrationLog = new ZhySelfdevDeviceRegistrationLog();
                registrationLog.setDeviceId(deviceId);
                registrationLog.setDeviceIp(deviceIp);
                registrationLog.setDeviceName(deviceName);
                registrationLog.setStatus(status);
                registrationLog.setDeviceType(deviceType);
                registrationLog.setAliases(aliases);
                registrationLog.setTime(time);
                registrationLog.setCreateTime(createTime);
                registrationLog.setRegStatus(regStatus);
                registrationLog.setRegContent(content);
                // 日志存储
                zhyuav_sys_user_logger.info("接收到注册消息: {}", registrationLog.toString());
                // 保存入数据库
                SpringUtils.getBean(IZhySelfdevDeviceRegistrationLogService.class).insertZhySelfdevDeviceRegistrationLog(registrationLog);
            }
        };
    }

    /**
     * 接收设备信息日志记录
     *
     * @param messageLog 消息日志信息
     * @return 任务task
     */
    public static TimerTask recordMessageLog(final ZhySelfdevMessageLog messageLog)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                Integer direction = messageLog.getDirection();
                String direStr = MessageDirection.RECEIVE.ordinal() == direction ? "接收" : "发送";
                // 日志存储
                zhyuav_sys_user_logger.info("{}消息: {}", direStr, messageLog.toString());
                // 保存入数据库
                SpringUtils.getBean(IZhySelfdevMessageLogService.class).insertZhySelfdevMessageLog(messageLog);
            }
        };
    }
}
