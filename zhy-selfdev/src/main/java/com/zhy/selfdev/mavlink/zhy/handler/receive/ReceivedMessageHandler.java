package com.zhy.selfdev.mavlink.zhy.handler.receive;

import com.zhy.selfdev.annotation.MavLinkMessageLog;
import com.zhy.selfdev.enums.MessageDirection;

/**
 * 公共处理接口
 */
public abstract class ReceivedMessageHandler implements IReceivedMessageHandler{

    /**
     * 写入数据库日志
     *
     * @param uid           客户端ID
     * @param message 消息内容
     */
    private void writeLog(String uid, byte[] message){

    }

    /**
     * 消费消息
     * @param message 消息内容
     */
    @Override
    @MavLinkMessageLog(title = "收到机巢消息", direction = MessageDirection.RECEIVE)
    public void handle(String uid, byte[] message){
        // 消费消息
        consumeMessage(uid, message);
        // 写入数据库日志
        writeLog(uid, message);
    }

    /**
     * 消费消息
     *
     * @param uid     socket客户端ID
     * @param message 消息内容
     */
     protected abstract void consumeMessage(String uid, byte[] message);
}
