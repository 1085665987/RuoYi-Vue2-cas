package com.zhy.selfdev.annotation;

import com.zhy.selfdev.domain.enums.MessageDirection;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 *
 * @author zhy
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MavLinkMessageLog
{
    /**
     * 消息描述
     */
    public String title() default "";

    /**
     * 消息方向：接收0/发送1
     */
    public MessageDirection direction();
}
