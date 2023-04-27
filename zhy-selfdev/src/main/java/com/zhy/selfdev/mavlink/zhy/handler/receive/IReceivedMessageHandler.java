package com.zhy.selfdev.mavlink.zhy.handler.receive;

import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.protocol.Packet;

/**
 * 公共处理接口
 */
public interface IReceivedMessageHandler {

    /**
     * 处理消息
     *
     * @param uid     客户端ID
     * @param message 消息内容
     */
    public void handle(String uid, byte[] message);
}
