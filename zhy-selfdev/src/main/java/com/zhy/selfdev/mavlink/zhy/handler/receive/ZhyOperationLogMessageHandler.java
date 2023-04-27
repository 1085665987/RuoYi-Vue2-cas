package com.zhy.selfdev.mavlink.zhy.handler.receive;

import org.springframework.stereotype.Component;

@Component
public class ZhyOperationLogMessageHandler extends ReceivedMessageHandler{

    /**
     * 消费消息
     *
     * @param uid
     * @param message
     */
    @Override
    public void consumeMessage(String uid, byte[] message) {

    }
}
