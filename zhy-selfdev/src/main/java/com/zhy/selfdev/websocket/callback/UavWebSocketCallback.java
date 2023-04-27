package com.zhy.selfdev.websocket.callback;

import com.zhy.common.utils.WebSocketUtils;
import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.protocol.MessageBuilder;
import com.zhy.selfdev.mavlink.protocol.Packet;
import com.zhy.selfdev.mavlink.zhy.handler.MavLinkMessageHandlerFactory;
import com.zhy.selfdev.websocket.UavWebSocketUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WebSocket回调
 */
public class UavWebSocketCallback implements IUavWebSocketCallback{

    private static Logger logger = LoggerFactory.getLogger(UavWebSocketCallback.class);

    private final static String CLASS_NAME = UavWebSocketCallback.class.getName();

    /**
     * 连接成功监听
     *
     * @param uid 用户id
     */
    @Override
    public void onOpenListener(String uid) {
        logger.info("{}::onOpenListener, {}已连接", CLASS_NAME, uid);
    }

    /**
     * 接收到消息时的监听
     *
     * @param uid     用户id
     * @param message 消息内容
     */
    @Override
    public void onMessageListener(String uid, String message) {
         logger.info("{}::onMessageListener, 接收到[{}]的消息 - {}", CLASS_NAME, uid, message);
    }

    /**
     * 接收到消息时的监听，消息分发
     *
     * @param uid     用户id
     * @param message 消息内容
     */
    @Override
    public void onMessageListener(String uid, byte[] message) {
        logger.info("{}::onMessageListener, 接收到[{}]的消息 - {}", CLASS_NAME, uid, message);
        Packet<Message> messagePacket = Packet.readV1Packet(message);
        MavLinkMessageHandlerFactory.build(messagePacket.getMessageId()).handle(uid, message);
    }


    /**
     * 连接关闭时的监听
     *
     * @param uid 用户id
     */
    @Override
    public void onCloseListener(String uid) {

    }

    /**
     * 抛出异常时的监听
     *
     * @param uid       用户id
     * @param exception 异常
     */
    @Override
    public void onErrorListener(String uid, Throwable exception) {

    }
}


interface IUavWebSocketCallback {

    /**
     * 连接成功监听
     * @param uid 用户id
     */
    void onOpenListener(String uid);

    /**
     * 接收到消息时的监听
     * @param uid      用户id
     * @param message  消息内容
     */
    void onMessageListener(String uid, String message);

    /**
     * 接收到消息时的监听
     * @param uid      用户id
     * @param message  消息内容
     */
    void onMessageListener(String uid, byte[] message);

    /**
     * 连接关闭时的监听
     * @param uid 用户id
     */
    void onCloseListener(String uid);

    /**
     * 抛出异常时的监听
     * @param uid        用户id
     * @param exception  异常
     */
    void onErrorListener(String uid, Throwable exception);
}
