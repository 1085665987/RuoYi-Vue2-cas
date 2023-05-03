package com.zhy.selfdev.aspectj;

import com.alibaba.fastjson.JSON;
import com.zhy.common.enums.BusinessStatus;
import com.zhy.common.utils.StringUtils;
import com.zhy.common.utils.WebSocketUtils;
import com.zhy.common.utils.uuid.UUID;
import com.zhy.selfdev.annotation.MavLinkMessageLog;
import com.zhy.datapersist.domain.ZhySelfdevMessageLog;
import com.zhy.selfdev.enums.MessageDirection;
import com.zhy.selfdev.factory.AsyncFactory;
import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.protocol.MavlinkConfig;
import com.zhy.selfdev.mavlink.protocol.Packet;
import com.zhy.selfdev.websocket.UavWebSocketUsers;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 消息日志记录处理
 *
 * @author zhy
 */
@Aspect
@Component
public class MavLinkMessageLogAspect
{
    private static final Logger log = LoggerFactory.getLogger(MavLinkMessageLogAspect.class);

    /**
     * 异步操作任务调度线程池
     */
    @Autowired
    private ScheduledExecutorService scheduledExecutorService;

    // 配置织入点
    @Pointcut("@annotation(com.zhy.selfdev.annotation.MavLinkMessageLog)")
    //@Pointcut("execution(public * com.zhy.selfdev.mavlink.zhy.handler.receive.*.handle(..))")
    public void logPointCut()
    {
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult)
    {
        handleMessageLog(joinPoint, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e)
    {
        handleMessageLog(joinPoint, e, null);
    }

    protected void handleMessageLog(final JoinPoint joinPoint, final Exception e, Object jsonResult)
    {
        try
        {
            // 获得注解
            MavLinkMessageLog mavLinkMessageLog = getAnnotationLog(joinPoint);
            if (mavLinkMessageLog == null)
            {
                return;
            }
            // *========数据库日志=========*//
            ZhySelfdevMessageLog logEntity = new ZhySelfdevMessageLog();
            logEntity.setStatus(BusinessStatus.SUCCESS.ordinal());
            // 设置时间
            logEntity.setCreateTime(new Date());

            if (e != null)
            {
                logEntity.setStatus(BusinessStatus.FAIL.ordinal());
                logEntity.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }
            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, mavLinkMessageLog, logEntity);
            // 保存数据库
            scheduledExecutorService.execute(AsyncFactory.recordMessageLog(logEntity));
        }
        catch (Exception exp)
        {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param log 日志
     * @param mavlinkMessageLog 消息日志
     * @throws Exception
     */
    public void getControllerMethodDescription(JoinPoint joinPoint, MavLinkMessageLog log, ZhySelfdevMessageLog mavlinkMessageLog) throws Exception
    {
        // 设置标题
        mavlinkMessageLog.setTitle(log.title());
        // 设置消息方向是发送还是接收
        mavlinkMessageLog.setDirection(log.direction().ordinal());
        // 获取参数的信息，传入到数据库中。
        setRequestValue(joinPoint, mavlinkMessageLog);
    }

    /**
     * 获取请求的参数，放到log中
     *
     * @param messageLog 操作日志
     * @throws Exception 异常
     */
    private void setRequestValue(JoinPoint joinPoint, ZhySelfdevMessageLog messageLog) throws Exception
    {
        Object[] args = joinPoint.getArgs();
        // 接收消息，只有一个入口
        // if (messageLog.getDirection() == MessageDirection.RECEIVE.ordinal())
        {
            String uid = (String)args[0];
            // 设置socket客户端ID
            messageLog.setUid(uid);
            String ip = WebSocketUtils.getRemoteAddress(UavWebSocketUsers.getUsers().get(uid)).getHostString();
            // 设置socket客户端ip地址
            messageLog.setClientIp(ip);
            byte[] message = (byte[])args[1];
            // 设置消息内容
            messageLog.setMessageContent(message);
            Packet<Message> messagePacket = Packet.readV1Packet(message);
            // 设置起始位(版本标志)
            messageLog.setStx(messagePacket.getVersionMarker());
            // 设置有效载荷长度
            messageLog.setLen(messagePacket.getPayload().length);
            // 设置包序号
            messageLog.setSeq(messagePacket.getSequence());
            // 设置系统ID编号
            messageLog.setSysId(messagePacket.getSystemId());
            // 设置部件ID编号
            messageLog.setCompId(messagePacket.getComponentId());
            // 设置消息包ID编号
            messageLog.setMsgId(messagePacket.getMessageId());
            // 设置有效载荷数据
            messageLog.setPayload(messagePacket.getPayload());
            // 设置校验和低字节
            messageLog.setCka(messagePacket.getChecksum());
            // 设置校验和高字节
            messageLog.setCkb(Packet.generateCrc(message, MavlinkConfig.getCrcBox().get(messagePacket.getMessageId())));
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private MavLinkMessageLog getAnnotationLog(JoinPoint joinPoint) throws Exception
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(MavLinkMessageLog.class);
        }
        return null;
    }

    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray)
    {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0)
        {
            for (int i = 0; i < paramsArray.length; i++)
            {
                if (StringUtils.isNotNull(paramsArray[i]) && !isFilterObject(paramsArray[i]))
                {
                    Object jsonObj = JSON.toJSON(paramsArray[i]);
                    params += jsonObj.toString() + " ";
                }
            }
        }
        return params.trim();
    }

    /**
     * 判断是否需要过滤的对象。
     *
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    @SuppressWarnings("rawtypes")
    public boolean isFilterObject(final Object o)
    {
        Class<?> clazz = o.getClass();
        if (clazz.isArray())
        {
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        }
        else if (Collection.class.isAssignableFrom(clazz))
        {
            Collection collection = (Collection) o;
            for (Iterator iter = collection.iterator(); iter.hasNext();)
            {
                return iter.next() instanceof MultipartFile;
            }
        }
        else if (Map.class.isAssignableFrom(clazz))
        {
            Map map = (Map) o;
            for (Iterator iter = map.entrySet().iterator(); iter.hasNext();)
            {
                Map.Entry entry = (Map.Entry) iter.next();
                return entry.getValue() instanceof MultipartFile;
            }
        }
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse
                || o instanceof BindingResult;
    }
}
