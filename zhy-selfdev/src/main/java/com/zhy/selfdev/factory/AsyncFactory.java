package com.zhy.selfdev.factory;

import com.zhy.selfdev.domain.MavlinkMessageLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author zhy
 */
public class AsyncFactory
{
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    /**
     * 记录登录信息
     *
     * @return 任务task
     */
    public static TimerTask recordDeviceRegistrationMessageLog(final MavlinkMessageLog messageLog)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                /*
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                sys_user_logger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLogininfor logininfor = new SysLogininfor();
                logininfor.setUserName(username);
                logininfor.setIpaddr(ip);
                logininfor.setLoginLocation(address);
                logininfor.setBrowser(browser);
                logininfor.setOs(os);
                logininfor.setMsg(message);
                // 日志状态
                if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER))
                {
                    logininfor.setStatus(Constants.SUCCESS);
                }
                else if (Constants.LOGIN_FAIL.equals(status))
                {
                    logininfor.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(ISysLogininforService.class).insertLogininfor(logininfor);
                */
            }
        };
    }

    /**
     * 操作日志记录
     *
     * @param messageLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordMessageLog(final MavlinkMessageLog messageLog)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                // 保存入数据库
                //SpringUtils.getBean(ISysOperLogService.class).insertOperlog(messageLog);
            }
        };
    }
}
