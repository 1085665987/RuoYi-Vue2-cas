package com.zhy.selfdev.mavlink.common.v1.messages;

import com.zhy.selfdev.mavlink.annotation.MavlinkMessage;
import com.zhy.selfdev.mavlink.annotation.MavlinkMessageParam;
import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.common.v1.enums.MavParamType;
import com.zhy.selfdev.mavlink.protocol.ByteArray;
import com.zhy.selfdev.mavlink.protocol.util.ByteModel;

import java.util.Objects;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 23,
		messagePayloadLength = 23,
		description = "Set a parameter value TEMPORARILY to RAM. It will be reset to default on system reboot. Send the ACTION MAV_ACTION_STORAGE_WRITE to PERMANENTLY write the RAM contents to EEPROM. IMPORTANT: The receiving component should acknowledge the new parameter value by sending a param_value message to all communication partners. This will also ensure that multiple GCS all have an up-to-date list of all parameters. If the sending GCS did not receive a PARAM_VALUE message within its timeout time, it should re-send the PARAM_SET message."
)
public class ParamSet implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 16, description = "Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Onboard parameter value")
	private float paramValue;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Onboard parameter type: see the MAV_PARAM_TYPE enum for supported data types.", enum0 = MavParamType.class)
	private short paramType;

	private final int messagePayloadLength = 23;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamSet(short targetSystem, short targetComponent, String paramId, float paramValue, short paramType) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.paramId = paramId;
		this.paramValue = paramValue;
		this.paramType = paramType;
	}

	public ParamSet(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 23！");
		}
		messagePayload(messagePayload);
	}

	public ParamSet(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		paramId = byteArray.getChars(2,16);
		paramValue = byteArray.getFloat(18);
		paramType = byteArray.getUnsignedInt8(22);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putChars(paramId,2);
		byteArray.putFloat(paramValue,18);
		byteArray.putUnsignedInt8(paramType,22);
		return messagePayload;
	}

	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamSet setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final ParamSet setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final ParamSet setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamSet setParamValue(float paramValue) {
		this.paramValue = paramValue;
		return this;
	}

	public final float getParamValue() {
		return paramValue;
	}

	public final ParamSet setParamType(short paramType) {
		this.paramType = paramType;
		return this;
	}

	public final short getParamType() {
		return paramType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ParamSet other = (ParamSet)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.paramId, other.paramId)) {
				return false;
			} else if (!Objects.deepEquals(this.paramValue, other.paramValue)) {
				return false;
			} else {
				return Objects.deepEquals(this.paramType, other.paramType);
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
		result = 31 * result + Objects.hashCode(this.paramId);
		result = 31 * result + Objects.hashCode(this.paramValue);
		result = 31 * result + Objects.hashCode(this.paramType);
		return result;
	}

	@Override
	public String toString() {
		return "ParamSet{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", paramId=" + paramId +
				", paramValue=" + paramValue +
				", paramType=" + paramType +
				'}';
	}
}
