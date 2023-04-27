package com.zhy.selfdev.mavlink.zhy.messages;

import com.zhy.selfdev.mavlink.annotation.MavlinkMessage;
import com.zhy.selfdev.mavlink.annotation.MavlinkMessageParam;
import com.zhy.selfdev.mavlink.common.Message;

import com.zhy.selfdev.mavlink.protocol.ByteArray;
import com.zhy.selfdev.mavlink.protocol.util.ByteModel;
import com.zhy.selfdev.mavlink.zhy.enums.DeviceType;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2023.04.16 - 04:05
 **********************************/

@MavlinkMessage(
		id = 240,
		messagePayloadLength = 199,
		description = "安卓侧主动向平台发送注册信息，移动端到服务端参数接口用 ZHY_DEVICE_REGISTRATION 接口传输"
)
public class ZhyDeviceRegistration implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "device type; MSDK-android:1 OSDK:2，机巢:3. See DEVICE_TYPE enum", enum0 = DeviceType.class)
	private short deviceType;

	@MavlinkMessageParam(mavlinkType = "char", position = 2, typeSize = 1, streamLength = 50, description = "Equipment unique identification code")
	private String deviceId;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 80, description = "device or airCaft name")
	private String deviceName;

	@MavlinkMessageParam(mavlinkType = "char", position = 4, typeSize = 1, streamLength = 68, description = "别名 Device aliases user set,if any")
	private String aliases;

	private final int messagePayloadLength = 199;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ZhyDeviceRegistration(short deviceType, String deviceId, String deviceName, String aliases) {
		this.deviceType = deviceType;
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.aliases = aliases;
	}

	public ZhyDeviceRegistration(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 199！");
		}
		messagePayload(messagePayload);
	}

	public ZhyDeviceRegistration(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		deviceType = byteArray.getUnsignedInt8(0);
		deviceId = byteArray.getChars(1,50);
		deviceName = byteArray.getChars(51,80);
		aliases = byteArray.getChars(131,68);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(deviceType,0);
		byteArray.putChars(deviceId,1);
		byteArray.putChars(deviceName,51);
		byteArray.putChars(aliases,131);
		return messagePayload;
	}

	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ZhyDeviceRegistration setDeviceType(short deviceType) {
		this.deviceType = deviceType;
		return this;
	}

	public final short getDeviceType() {
		return deviceType;
	}

	public final ZhyDeviceRegistration setDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	public final String getDeviceId() {
		return deviceId;
	}

	public final ZhyDeviceRegistration setDeviceName(String deviceName) {
		this.deviceName = deviceName;
		return this;
	}

	public final String getDeviceName() {
		return deviceName;
	}

	public final ZhyDeviceRegistration setAliases(String aliases) {
		this.aliases = aliases;
		return this;
	}

	public final String getAliases() {
		return aliases;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ZhyDeviceRegistration other = (ZhyDeviceRegistration)o;
			if (!Objects.deepEquals(this.deviceType, other.deviceType)) {
				return false;
			} else if (!Objects.deepEquals(this.deviceId, other.deviceId)) {
				return false;
			} else if (!Objects.deepEquals(this.deviceName, other.deviceName)) {
				return false;
			} else {
				return Objects.deepEquals(this.aliases, other.aliases);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.deviceType);
		result = 31 * result + Objects.hashCode(this.deviceId);
		result = 31 * result + Objects.hashCode(this.deviceName);
		result = 31 * result + Objects.hashCode(this.aliases);
		return result;
	}

	@Override
	public String toString() {
		return "ZhyDeviceRegistration{" +
				"deviceType=" + deviceType +
				", deviceId=" + deviceId +
				", deviceName=" + deviceName +
				", aliases=" + aliases +
				'}';
	}
}
