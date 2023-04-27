package com.zhy.selfdev.mavlink.zhy.messages;

import com.zhy.selfdev.mavlink.annotation.MavlinkMessage;
import com.zhy.selfdev.mavlink.annotation.MavlinkMessageParam;
import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.protocol.ByteArray;
import com.zhy.selfdev.mavlink.protocol.util.ByteModel;
import com.zhy.selfdev.mavlink.zhy.enums.LogLevel;
import com.zhy.selfdev.mavlink.zhy.enums.SourceType;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2023.04.16 - 03:57
 **********************************/

@MavlinkMessage(
		id = 239,
		messagePayloadLength = 238,
		description = "安卓执行指令返回结果信息"
)
public class ZhyOperationLog implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "时间戳")
	private long timestamp;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "来源: MSDK-android 1, OSDK 2, SERVER 3, webPage 4. See SOURCE_TYPE enum", enum0 = SourceType.class)
	private short sourceType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "执行指令")
	private short action;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "返回信息等级. See LOG_LEVEL enum", enum0 = LogLevel.class)
	private short logLevels;

	@MavlinkMessageParam(mavlinkType = "char", position = 5, typeSize = 1, streamLength = 24, description = "时间")
	private String time;

	@MavlinkMessageParam(mavlinkType = "char", position = 6, typeSize = 1, streamLength = 1, description = "执行结果: 1 success, 0 failed")
	private String isSuccess;

	@MavlinkMessageParam(mavlinkType = "char", position = 7, typeSize = 1, streamLength = 170, description = "返回结果信息 根据action区别解析")
	private String message;

	@MavlinkMessageParam(mavlinkType = "char", position = 8, typeSize = 1, streamLength = 36, description = "设备id")
	private String deviceId;

	private final int messagePayloadLength = 238;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ZhyOperationLog(long timestamp, short sourceType, short action, short logLevels, String time, String isSuccess, String message, String deviceId) {
		this.timestamp = timestamp;
		this.sourceType = sourceType;
		this.action = action;
		this.logLevels = logLevels;
		this.time = time;
		this.isSuccess = isSuccess;
		this.message = message;
		this.deviceId = deviceId;
	}

	public ZhyOperationLog(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 238！");
		}
		messagePayload(messagePayload);
	}

	public ZhyOperationLog(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timestamp = byteArray.getUnsignedInt32(0);
		sourceType = byteArray.getUnsignedInt8(4);
		action = byteArray.getUnsignedInt8(5);
		logLevels = byteArray.getUnsignedInt8(6);
		time = byteArray.getChars(7,24);
		isSuccess = byteArray.getChars(31,1);
		message = byteArray.getChars(32,170);
		deviceId = byteArray.getChars(202,36);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timestamp,0);
		byteArray.putUnsignedInt8(sourceType,4);
		byteArray.putUnsignedInt8(action,5);
		byteArray.putUnsignedInt8(logLevels,6);
		byteArray.putChars(time,7);
		byteArray.putChars(isSuccess,31);
		byteArray.putChars(message,32);
		byteArray.putChars(deviceId,202);
		return messagePayload;
	}

	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ZhyOperationLog setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public final long getTimestamp() {
		return timestamp;
	}

	public final ZhyOperationLog setSourceType(short sourceType) {
		this.sourceType = sourceType;
		return this;
	}

	public final short getSourceType() {
		return sourceType;
	}

	public final ZhyOperationLog setAction(short action) {
		this.action = action;
		return this;
	}

	public final short getAction() {
		return action;
	}

	public final ZhyOperationLog setLogLevels(short logLevels) {
		this.logLevels = logLevels;
		return this;
	}

	public final short getLogLevels() {
		return logLevels;
	}

	public final ZhyOperationLog setTime(String time) {
		this.time = time;
		return this;
	}

	public final String getTime() {
		return time;
	}

	public final ZhyOperationLog setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
		return this;
	}

	public final String getIsSuccess() {
		return isSuccess;
	}

	public final ZhyOperationLog setMessage(String message) {
		this.message = message;
		return this;
	}

	public final String getMessage() {
		return message;
	}

	public final ZhyOperationLog setDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	public final String getDeviceId() {
		return deviceId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ZhyOperationLog other = (ZhyOperationLog)o;
			if (!Objects.deepEquals(this.timestamp, other.timestamp)) {
				return false;
			} else if (!Objects.deepEquals(this.sourceType, other.sourceType)) {
				return false;
			} else if (!Objects.deepEquals(this.action, other.action)) {
				return false;
			} else if (!Objects.deepEquals(this.logLevels, other.logLevels)) {
				return false;
			} else if (!Objects.deepEquals(this.time, other.time)) {
				return false;
			} else if (!Objects.deepEquals(this.isSuccess, other.isSuccess)) {
				return false;
			} else if (!Objects.deepEquals(this.message, other.message)) {
				return false;
			} else {
				return Objects.deepEquals(this.deviceId, other.deviceId);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timestamp);
		result = 31 * result + Objects.hashCode(this.sourceType);
		result = 31 * result + Objects.hashCode(this.action);
		result = 31 * result + Objects.hashCode(this.logLevels);
		result = 31 * result + Objects.hashCode(this.time);
		result = 31 * result + Objects.hashCode(this.isSuccess);
		result = 31 * result + Objects.hashCode(this.message);
		result = 31 * result + Objects.hashCode(this.deviceId);
		return result;
	}

	@Override
	public String toString() {
		return "ZhyOperationLog{" +
				"timestamp=" + timestamp +
				", sourceType=" + sourceType +
				", action=" + action +
				", logLevels=" + logLevels +
				", time=" + time +
				", isSuccess=" + isSuccess +
				", message=" + message +
				", deviceId=" + deviceId +
				'}';
	}
}
