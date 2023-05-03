package com.zhy.datapersist.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 设备注册对象 zhy_selfdev_device_registration
 *
 * @author zhy
 * @date 2023-04-22
 */
public class ZhySelfdevDeviceRegistrationLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 注册状态，注册成功：0，初始值：1 */
    private Integer logId;

    /** 设备ID */
    @Excel(name = "设备ID")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /** 注册状态，注册成功：0，初始值：1 */
    @Excel(name = "注册状态，注册成功：0，初始值：1")
    private Integer status;

    /** 对应的消息日志ID */
    @Excel(name = "对应的消息日志ID")
    private String messageLogId;

    /** 注册状态，注册失败：-1，注册成功：0，开始注册：1 */
    @Excel(name = "注册状态，注册失败：-1，注册成功：0，开始注册：1 ")
    private Integer regStatus;

    /** 注册状态消息 */
    @Excel(name = "注册状态消息")
    private String regContent;

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

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(Integer regStatus) {
        this.regStatus = regStatus;
    }

    public String getRegContent() {
        return regContent;
    }

    public void setRegContent(String regContent) {
        this.regContent = regContent;
    }

    @Override
    public String toString() {
        return "ZhySelfdevDeviceRegistrationLog{" +
                "logId=" + logId +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", aliases='" + aliases + '\'' +
                ", deviceType=" + deviceType +
                ", deviceIp='" + deviceIp + '\'' +
                ", time=" + time +
                ", status=" + status +
                ", messageLogId='" + messageLogId + '\'' +
                ", regStatus=" + regStatus +
                ", regContent='" + regContent + '\'' +
                '}';
    }
}

