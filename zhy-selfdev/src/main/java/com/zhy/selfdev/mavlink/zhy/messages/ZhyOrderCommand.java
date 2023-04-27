package com.zhy.selfdev.mavlink.zhy.messages;

import com.zhy.selfdev.mavlink.annotation.MavlinkMessage;
import com.zhy.selfdev.mavlink.annotation.MavlinkMessageParam;
import com.zhy.selfdev.mavlink.common.Message;

import com.zhy.selfdev.mavlink.protocol.ByteArray;
import com.zhy.selfdev.mavlink.protocol.util.ByteModel;
import com.zhy.selfdev.mavlink.zhy.enums.MavCmd;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2023.04.25 - 01:48
 **********************************/

@MavlinkMessage(
		id = 236,
		messagePayloadLength = 260,
		description = "平台端向机巢或无人机下发命令使用，接收发执行后需要用Log接口返回执行结果，服务端到移动端参数用ZHY_ORDER_COMMAND接口传输"
)
public class ZhyOrderCommand implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System which should execute the command")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component which should execute the command, 0 for all components")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "pitch")
	private float param1;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "yaw")
	private float param2;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "roll")
	private float param3;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "verticalThrottle")
	private float param4;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "action", enum0 = MavCmd.class)
	private short param5;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1, description = "actionParam")
	private short param6;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 9, typeSize = 1, streamLength = 240, description = "data")
	private short[] param7 = new short[240];

	private final int messagePayloadLength = 260;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ZhyOrderCommand(short targetSystem, short targetComponent, float param1, float param2, float param3, float param4, short param5, short param6, short[] param7) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.param4 = param4;
		this.param5 = param5;
		this.param6 = param6;
		this.param7 = param7;
	}

	public ZhyOrderCommand(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 260！");
		}
		messagePayload(messagePayload);
	}

	public ZhyOrderCommand(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		param1 = byteArray.getFloat(2);
		param2 = byteArray.getFloat(6);
		param3 = byteArray.getFloat(10);
		param4 = byteArray.getFloat(14);
		param5 = byteArray.getUnsignedInt8(18);
		param6 = byteArray.getUnsignedInt8(19);
		param7 = byteArray.getUnsignedInt8Array(20,240);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putFloat(param1,2);
		byteArray.putFloat(param2,6);
		byteArray.putFloat(param3,10);
		byteArray.putFloat(param4,14);
		byteArray.putUnsignedInt8(param5,18);
		byteArray.putUnsignedInt8(param6,19);
		byteArray.putUnsignedInt8Array(param7,20);
		return messagePayload;
	}

	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ZhyOrderCommand setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final ZhyOrderCommand setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final ZhyOrderCommand setParam1(float param1) {
		this.param1 = param1;
		return this;
	}

	public final float getParam1() {
		return param1;
	}

	public final ZhyOrderCommand setParam2(float param2) {
		this.param2 = param2;
		return this;
	}

	public final float getParam2() {
		return param2;
	}

	public final ZhyOrderCommand setParam3(float param3) {
		this.param3 = param3;
		return this;
	}

	public final float getParam3() {
		return param3;
	}

	public final ZhyOrderCommand setParam4(float param4) {
		this.param4 = param4;
		return this;
	}

	public final float getParam4() {
		return param4;
	}

	public final ZhyOrderCommand setParam5(short param5) {
		this.param5 = param5;
		return this;
	}

	public final short getParam5() {
		return param5;
	}

	public final ZhyOrderCommand setParam6(short param6) {
		this.param6 = param6;
		return this;
	}

	public final short getParam6() {
		return param6;
	}

	public final ZhyOrderCommand setParam7(short[] param7) {
		this.param7 = param7;
		return this;
	}

	public final short[] getParam7() {
		return param7;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ZhyOrderCommand other = (ZhyOrderCommand)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.param1, other.param1)) {
				return false;
			} else if (!Objects.deepEquals(this.param2, other.param2)) {
				return false;
			} else if (!Objects.deepEquals(this.param3, other.param3)) {
				return false;
			} else if (!Objects.deepEquals(this.param4, other.param4)) {
				return false;
			} else if (!Objects.deepEquals(this.param5, other.param5)) {
				return false;
			} else if (!Objects.deepEquals(this.param6, other.param6)) {
				return false;
			} else {
				return Objects.deepEquals(this.param7, other.param7);
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
		result = 31 * result + Objects.hashCode(this.param1);
		result = 31 * result + Objects.hashCode(this.param2);
		result = 31 * result + Objects.hashCode(this.param3);
		result = 31 * result + Objects.hashCode(this.param4);
		result = 31 * result + Objects.hashCode(this.param5);
		result = 31 * result + Objects.hashCode(this.param6);
		result = 31 * result + Objects.hashCode(this.param7);
		return result;
	}

	@Override
	public String toString() {
		return "ZhyOrderCommand{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", param1=" + param1 +
				", param2=" + param2 +
				", param3=" + param3 +
				", param4=" + param4 +
				", param5=" + param5 +
				", param6=" + param6 +
				", param7=" + Arrays.toString(param7) +
				'}';
	}
}
