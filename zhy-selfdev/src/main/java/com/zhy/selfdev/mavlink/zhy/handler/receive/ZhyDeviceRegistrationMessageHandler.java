package com.zhy.selfdev.mavlink.zhy.handler.receive;

import com.zhy.common.utils.WebSocketUtils;

import com.zhy.datapersist.domain.ZhySelfdevDeviceRegistration;
import com.zhy.datapersist.service.IZhySelfdevDeviceRegistrationService;

import com.zhy.selfdev.enums.RegistrationStatus;
import com.zhy.selfdev.factory.AsyncFactory;
import com.zhy.selfdev.mavlink.protocol.MessageBuilder;
import com.zhy.selfdev.mavlink.zhy.messages.ZhyDeviceRegistration;
import com.zhy.selfdev.websocket.UavWebSocketUsers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;

@Component
public class ZhyDeviceRegistrationMessageHandler extends ReceivedMessageHandler{

    private Logger logger = LoggerFactory.getLogger(ZhyDeviceRegistrationMessageHandler.class);

    private static final String CLASS_NAME = ZhyDeviceRegistrationMessageHandler.class.getSimpleName();

    /**
     * 异步操作任务调度线程池
     */
    @Autowired
    private ScheduledExecutorService scheduledExecutorService;

    @Resource
    private IZhySelfdevDeviceRegistrationService zhySelfdevDeviceRegistrationService;

    /**
     * 消费消息
     *
     * @param uid     socket客户端
     * @param message 消息内容
     */
    @Override
    public void consumeMessage(String uid, byte[] message) {
        com.zhy.selfdev.mavlink.zhy.messages.ZhyDeviceRegistration mavlinkMessage =
                (ZhyDeviceRegistration) MessageBuilder.readAnyMessage(message);

        assert mavlinkMessage != null;
        int count = writeRegistrationInfo(uid, new ZhySelfdevDeviceRegistration(){{
            setDeviceId(mavlinkMessage.getDeviceId());
            setDeviceName(mavlinkMessage.getDeviceName());
            setAliases(mavlinkMessage.getAliases());
            setDeviceType(mavlinkMessage.getDeviceType());
        }});

        // TODO 接下来的操作 。。。
    }

    /**
     * 写入注册表
     *
     * @param uid                        socket客户端连接id
     * @param selfdevDeviceRegistration  机巢注册信息
     * @return 返回
     */
    private int writeRegistrationInfo(String uid, ZhySelfdevDeviceRegistration selfdevDeviceRegistration){
        // 根据deviceId 查询注册表里有没有该设备的注册记录
        ZhySelfdevDeviceRegistration zhySelfdevDeviceRegistration =
                zhySelfdevDeviceRegistrationService.selectZhySelfdevDeviceRegistrationByDeviceId(selfdevDeviceRegistration.getDeviceId());
        if (null == zhySelfdevDeviceRegistration){
            // 设置状态为初始状态
            selfdevDeviceRegistration.setStatus(RegistrationStatus.DEFAULT.ordinal());
            // 设置注册时间
            selfdevDeviceRegistration.setTime(new Date());
            // 设置socket客户端IP
            String socketClientIp = WebSocketUtils.getRemoteAddress(UavWebSocketUsers.getUsers().get(uid)).getHostString();
            selfdevDeviceRegistration.setDeviceIp(socketClientIp);
            int insert = zhySelfdevDeviceRegistrationService.insertZhySelfdevDeviceRegistration(selfdevDeviceRegistration);
            // 日志记录
            scheduledExecutorService.execute(AsyncFactory.recordDeviceRegistrationMessageLog(
                    selfdevDeviceRegistration,
                    1,          // 1 开始注册
                    String.format("设备[%s,%s]开始注册", selfdevDeviceRegistration.getDeviceId(), selfdevDeviceRegistration.getDeviceName())
            ));
            return insert;
        }else if(zhySelfdevDeviceRegistration.getStatus() == RegistrationStatus.SUCCESS.ordinal()){
            logger.warn("{}::writeRegistrationInfo: 设备[{},{}]已经被注册，不能重复注册",
                    CLASS_NAME,
                    zhySelfdevDeviceRegistration.getDeviceId(),
                    zhySelfdevDeviceRegistration.getDeviceName());
            // 日志记录
            scheduledExecutorService.execute(AsyncFactory.recordDeviceRegistrationMessageLog(
                    zhySelfdevDeviceRegistration,
                    -1,         // -1 注册失败
                    String.format("设备[%s,%s]已经被注册，不能重复注册", zhySelfdevDeviceRegistration.getDeviceId(), zhySelfdevDeviceRegistration.getDeviceName())
            ));
            return -1;
        }else if(zhySelfdevDeviceRegistration.getStatus() == RegistrationStatus.DEFAULT.ordinal()){
            int update = zhySelfdevDeviceRegistrationService.updateZhySelfdevDeviceRegistration(selfdevDeviceRegistration);
            // 日志记录
            scheduledExecutorService.execute(AsyncFactory.recordDeviceRegistrationMessageLog(
                    zhySelfdevDeviceRegistration,
                    2,          // 2 注册信息更新
                    String.format("设备[%s,%s]注册信息更新", selfdevDeviceRegistration.getDeviceId(), selfdevDeviceRegistration.getDeviceName())
            ));
            return update;
        }
        return 0;
    }
}
