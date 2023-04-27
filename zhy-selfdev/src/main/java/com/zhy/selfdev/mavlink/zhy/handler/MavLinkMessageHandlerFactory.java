package com.zhy.selfdev.mavlink.zhy.handler;

import com.zhy.selfdev.mavlink.zhy.handler.receive.HeartbeatMessageHandler;
import com.zhy.selfdev.mavlink.zhy.handler.receive.ReceivedMessageHandler;
import com.zhy.selfdev.mavlink.zhy.handler.receive.ZhyDeviceRegistrationMessageHandler;
import com.zhy.selfdev.mavlink.zhy.handler.receive.ZhyOperationLogMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MavLinkMessageHandlerFactory {

    private static Map<Integer, ReceivedMessageHandler> messageHandlerMap = new HashMap<>();

    @Autowired
    public void setHeartbeatMessageHandler(HeartbeatMessageHandler handler){
        messageHandlerMap.put(0, handler);
    }

    @Autowired
    public void setZhyOperationLogMessageHandler(ZhyOperationLogMessageHandler handler){
        messageHandlerMap.put(239, handler);
    }

    @Autowired
    public void setZhyDeviceRegistrationMessageHandler(ZhyDeviceRegistrationMessageHandler handler){
        messageHandlerMap.put(240, handler);
    }

    public static ReceivedMessageHandler build(Integer messageId){
        return messageHandlerMap.get(messageId);
    }


}
