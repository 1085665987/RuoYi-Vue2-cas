package com.zhy.selfdev.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;

import java.util.Arrays;
import java.util.Date;

/**
 * 操作日志记录表 oper_log
 *
 * @author zhy
 */
public class MavlinkMessageLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日志主键，32位UUID */
    @Excel(name = "消息序号")
    private String logId;

    /** 消息描述 */
    @Excel(name = "消息描述")
    private String title;

    /** 方向：接收0/发送1 */
    @Excel(name = "方向：接收0/发送1")
    private Integer direction;

    /** socket客户端 */
    @Excel(name = "socket客户端")
    private String uid;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private byte[] messageContent;

    /** 包起始标志（0xFE） */
    @Excel(name = "包起始标志")
    private Integer stx;

    /** 有效载荷长度 */
    @Excel(name = "有效载荷长度")
    private Integer len;

    /** 包序号 */
    @Excel(name = "包序号")
    private Integer seq;

    /** 系统ID编号 */
    @Excel(name = "系统ID编号")
    private Integer sysId;

    /** 部件ID编号 */
    @Excel(name = "部件ID编号")
    private Integer compId;

    /** 消息包ID编号 */
    @Excel(name = "消息包ID编号")
    private Integer msgId;

    /** 消息包ID编号 */
    @Excel(name = "有效载荷数据")
    private byte[] payload;

    /** 消息包ID编号 */
    @Excel(name = "校验和低字节")
    private Integer cka;

    /** 消息包ID编号 */
    @Excel(name = "校验和高字节")
    private Integer ckb;

    /** 消息对象IP */
    @Excel(name = "消息对象IP")
    private String clientIp;

    /** 操作状态（0正常 1异常） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    private Integer status;

    /** 错误消息 */
    @Excel(name = "错误消息")
    private String errorMsg;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(byte[] messageContent) {
        this.messageContent = messageContent;
    }

    public Integer getStx() {
        return stx;
    }

    public void setStx(Integer stx) {
        this.stx = stx;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    public Integer getCka() {
        return cka;
    }

    public void setCka(Integer cka) {
        this.cka = cka;
    }

    public Integer getCkb() {
        return ckb;
    }

    public void setCkb(Integer ckb) {
        this.ckb = ckb;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "MavlinkMessageLog{" +
                "logId='" + logId + '\'' +
                ", title='" + title + '\'' +
                ", uid='" + uid + '\'' +
                ", messageContent=" + Arrays.toString(messageContent) +
                ", stx=" + stx +
                ", len=" + len +
                ", seq=" + seq +
                ", sysId=" + sysId +
                ", compId=" + compId +
                ", msgId=" + msgId +
                ", payload=" + Arrays.toString(payload) +
                ", cka=" + cka +
                ", ckb=" + ckb +
                ", status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
}
