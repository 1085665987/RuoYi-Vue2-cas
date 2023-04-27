package com.zhy.web.controller.uav;

import com.zhy.common.utils.StringUtils;
import com.zhy.common.utils.SemaphoreUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 * websocket 消息处理
 *
 * @author zhy
 */
//@Component
//@ServerEndpoint("/websocket/uav/{uid}")
public class UavWebSocketServer
{
    /**
     * WebSocketServer 日志控制器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UavWebSocketServer.class);

    /**
     * 默认最多允许同时在线人数100
     */
    public static int socketMaxOnlineCount = 10;

    private static Semaphore socketSemaphore = new Semaphore(socketMaxOnlineCount);

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session,  @PathParam("uid") String uid) throws Exception
    {
        boolean semaphoreFlag = false;
        // 尝试获取信号量
        semaphoreFlag = SemaphoreUtils.tryAcquire(socketSemaphore);
        if (!semaphoreFlag)
        {
            // 未获取到信号量
            LOGGER.error("\n 当前在线人数超过限制数- {}", socketMaxOnlineCount);
            UavWebSocketUsers.sendMessageToUser(session, "当前在线人数超过限制数：" + socketMaxOnlineCount);
            session.close();
        }
        else
        {
            // 添加用户
            UavWebSocketUsers.put(uid, session);
            LOGGER.info("\n 建立连接 - {}", uid);
            LOGGER.info("\n 当前人数 - {}", UavWebSocketUsers.getUsers().size());
        }
    }

    /**
     * 连接关闭时处理
     */
    @OnClose
    public void onClose(Session session, @PathParam("uid") String uid)
    {
        LOGGER.info("\n 关闭连接 - {}", uid);
        // 移除用户
        UavWebSocketUsers.remove(session);

        // 获取到信号量则需释放
        SemaphoreUtils.release(socketSemaphore);
    }

    /**
     * 抛出异常时处理
     */
    @OnError
    public void onError(@PathParam("uid") String uid, Throwable exception) throws Exception
    {
        Session session = UavWebSocketUsers.getUsers().get(uid);
        if (StringUtils.isNotNull(session) && session.isOpen())
        {
            // 关闭连接
            session.close();
        }
        LOGGER.info("\n 连接异常 - {}", uid);
        LOGGER.info("\n 异常信息 - {}", exception.getMessage());
        // 移出用户
        UavWebSocketUsers.remove(uid);
        // 获取到信号量则需释放
        SemaphoreUtils.release(socketSemaphore);
    }

    /**
     * 服务器接收到客户端消息时调用的方法
     */
    @OnMessage
    public void onMessage(@PathParam("uid") String uid, String message)
    {
        LOGGER.info("\n 收到来自{}的信息 - {}", uid, message);
    }

    /**
     * 实现服务器主动推送(向浏览器发消息)
     */
    public void sendMessage(String message) throws IOException {
        LOGGER.info("服务器消息推送：{}", message);
        UavWebSocketUsers.sendMessageToUsers(message);
    }

    /**
     * 发送消息到指定客户端
     * @param uid           用户ID
     * @param message       发送的消息
     * @throws IOException  异常信息，需要在此捕获
     */
    public static void sendMessage(String uid, String message) throws Exception {
        LOGGER.info("推送消息到窗口{}，推送内容:{}", uid, message);
        UavWebSocketUsers.sendMessageToUser(uid, message);
    }
}
