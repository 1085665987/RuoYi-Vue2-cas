package com.zhy.selfdev.mavlink.common.v1.messages;

import com.zhy.selfdev.mavlink.annotation.MavlinkMessage;
import com.zhy.selfdev.mavlink.annotation.MavlinkMessageParam;
import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.protocol.ByteArray;
import com.zhy.selfdev.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 45,
		messagePayloadLength = 2,
		description = "Delete all mission items at once."
)
public class MissionClearAll implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	private final int messagePayloadLength = 2;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MissionClearAll(short targetSystem, short targetComponent) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
	}

	public MissionClearAll(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 2！");
		}
		messagePayload(messagePayload);
	}

	public MissionClearAll(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		return messagePayload;
	}

	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MissionClearAll setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final MissionClearAll setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			MissionClearAll other = (MissionClearAll)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else {
				return Objects.deepEquals(this.targetComponent, other.targetComponent);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		return result;
	}

	@Override
	public String toString() {
		return "MissionClearAll{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				'}';
	}
}
