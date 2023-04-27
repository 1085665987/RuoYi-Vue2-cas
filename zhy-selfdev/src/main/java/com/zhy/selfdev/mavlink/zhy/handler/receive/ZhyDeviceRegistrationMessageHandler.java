package com.zhy.selfdev.mavlink.zhy.handler.receive;

import com.zhy.common.utils.WebSocketUtils;
import com.zhy.selfdev.domain.ZhySelfdevDeviceRegistration;
import com.zhy.selfdev.domain.enums.RegistrationStatus;
import com.zhy.selfdev.mavlink.protocol.MessageBuilder;
import com.zhy.selfdev.service.IZhySelfdevDeviceRegistrationService;
import com.zhy.selfdev.websocket.UavWebSocketUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class ZhyDeviceRegistrationMessageHandler extends ReceivedMessageHandler{

    private Logger logger = LoggerFactory.getLogger(ZhyDeviceRegistrationMessageHandler.class);

    private static final String CLASS_NAME = ZhyDeviceRegistrationMessageHandler.class.getSimpleName();

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
                (com.zhy.selfdev.mavlink.zhy.messages.ZhyDeviceRegistration)MessageBuilder.readAnyMessage(message);

        assert mavlinkMessage != null;
        int count = writeRegistrationInfo(uid, new ZhySelfdevDeviceRegistration(mavlinkMessage));
    }

    private int writeRegistrationInfo(String uid, ZhySelfdevDeviceRegistration mavlinkMessage){
        // 根据deviceId 查询注册表里有没有该设备的注册记录
        ZhySelfdevDeviceRegistration zhySelfdevDeviceRegistration =
                zhySelfdevDeviceRegistrationService.selectZhySelfdevDeviceRegistrationByDeviceId(mavlinkMessage.getDeviceId());
        if (null == zhySelfdevDeviceRegistration){
            // 设置状态为初始状态
            mavlinkMessage.setStatus(RegistrationStatus.DEFAULT.ordinal());
            // 设置注册时间
            mavlinkMessage.setTime(new Date());
            // 设置socket客户端IP
            String socketClientIp = WebSocketUtils.getRemoteAddress(UavWebSocketUsers.getUsers().get(uid)).getHostString();
            mavlinkMessage.setDeviceIp(socketClientIp);
            return zhySelfdevDeviceRegistrationService.insertZhySelfdevDeviceRegistration(mavlinkMessage);
        }else if(zhySelfdevDeviceRegistration.getStatus() == RegistrationStatus.SUCCESS.ordinal()){
            logger.warn("{}::writeRegistrationInfo: 该设备[{},{}]已经被注册，不能重复注册", CLASS_NAME, mavlinkMessage.getDeviceId(), mavlinkMessage.getDeviceName());
            return -1;
        }else if(zhySelfdevDeviceRegistration.getStatus() == RegistrationStatus.DEFAULT.ordinal()){
            return zhySelfdevDeviceRegistrationService.updateZhySelfdevDeviceRegistration(mavlinkMessage);
        }
        return 0;
    }
}
