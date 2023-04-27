package com.zhy.selfdev.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhy.selfdev.mavlink.zhy.messages.ZhyDeviceRegistration;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;

/**
 * 设备注册对象 zhy_selfdev_device_registration
 *
 * @author zhy
 * @date 2023-04-22
 */
public class ZhySelfdevDeviceRegistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备ID */
    private String deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 设备别名 */
    @Excel(name = "设备别名")
    private String aliases;

    /** 设备类型，MSDK-android：1，OSDK：2 */
    @Excel(name = "设备类型，MSDK-android：1，OSDK：2")
    private Short deviceType;

    /** 设备IP */
    @Excel(name = "设备IP")
    private String deviceIp;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 注册状态，注册成功：0，初始值：1 */
    @Excel(name = "注册状态，注册成功：0，初始值：1")
    private Integer status;

    /** 对应的消息日志ID */
    @Excel(name = "对应的消息日志ID")
    private String messageLogId;

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId()
    {
        return deviceId;
    }
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public void setDeviceType(Short deviceType)
    {
        this.deviceType = deviceType;
    }

    public Short getDeviceType()
    {
        return deviceType;
    }
    public void setDeviceIp(String deviceIp)
    {
        this.deviceIp = deviceIp;
    }

    public String getDeviceIp()
    {
        return deviceIp;
    }
    public void setMessageLogId(String messageLogId)
    {
        this.messageLogId = messageLogId;
    }

    public String getMessageLogId()
    {
        return messageLogId;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceId", getDeviceId())
            .append("deviceName", getDeviceName())
            .append("aliases", getAliases())
            .append("deviceType", getDeviceType())
            .append("deviceIp", getDeviceIp())
            .append("time", getTime())
            .append("status", getStatus())
            .append("messageLogId", getMessageLogId())
            .toString();
    }

    public ZhySelfdevDeviceRegistration() {}

    public ZhySelfdevDeviceRegistration(String deviceId, String deviceName, String aliases, Short deviceType, String deviceIp, Date time, Integer status, String messageLogId) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.aliases = aliases;
        this.deviceType = deviceType;
        this.deviceIp = deviceIp;
        this.time = time;
        this.status = status;
        this.messageLogId = messageLogId;
    }

    public ZhySelfdevDeviceRegistration(ZhyDeviceRegistration zhyDeviceRegistration) {
        this.deviceId = zhyDeviceRegistration.getDeviceId();
        this.deviceName = zhyDeviceRegistration.getDeviceName();
        this.aliases = zhyDeviceRegistration.getAliases();
        this.deviceType = zhyDeviceRegistration.getDeviceType();
    }
}

