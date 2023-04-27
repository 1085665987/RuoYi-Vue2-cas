package com.zhy.selfdev.mavlink.common.v1.messages;

import com.zhy.selfdev.mavlink.annotation.MavlinkMessage;
import com.zhy.selfdev.mavlink.annotation.MavlinkMessageParam;
import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.protocol.ByteArray;
import com.zhy.selfdev.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 100,
		messagePayloadLength = 26,
		description = "Optical flow from a flow sensor (e.g. optical mouse sensor)"
)
public class OpticalFlow implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX)")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Sensor ID")
	private short sensorId;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2, description = "Flow in pixels * 10 in x-sensor direction (dezi-pixels)")
	private short flowX;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "Flow in pixels * 10 in y-sensor direction (dezi-pixels)")
	private short flowY;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Flow in meters in x-sensor direction, angular-speed compensated")
	private float flowCompMX;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Flow in meters in y-sensor direction, angular-speed compensated")
	private float flowCompMY;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "Optical flow quality / confidence. 0: bad, 255: maximum quality")
	private short quality;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Ground distance in meters. Positive value: distance known. Negative value: Unknown distance")
	private float groundDistance;

	private final int messagePayloadLength = 26;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OpticalFlow(BigInteger timeUsec, short sensorId, short flowX, short flowY, float flowCompMX, float flowCompMY, short quality, float groundDistance) {
		this.timeUsec = timeUsec;
		this.sensorId = sensorId;
		this.flowX = flowX;
		this.flowY = flowY;
		this.flowCompMX = flowCompMX;
		this.flowCompMY = flowCompMY;
		this.quality = quality;
		this.groundDistance = groundDistance;
	}

	public OpticalFlow(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 26！");
		}
		messagePayload(messagePayload);
	}

	public OpticalFlow(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		sensorId = byteArray.getUnsignedInt8(8);
		flowX = byteArray.getInt16(9);
		flowY = byteArray.getInt16(11);
		flowCompMX = byteArray.getFloat(13);
		flowCompMY = byteArray.getFloat(17);
		quality = byteArray.getUnsignedInt8(21);
		groundDistance = byteArray.getFloat(22);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(sensorId,8);
		byteArray.putInt16(flowX,9);
		byteArray.putInt16(flowY,11);
		byteArray.putFloat(flowCompMX,13);
		byteArray.putFloat(flowCompMY,17);
		byteArray.putUnsignedInt8(quality,21);
		byteArray.putFloat(groundDistance,22);
		return messagePayload;
	}

	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OpticalFlow setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final OpticalFlow setSensorId(short sensorId) {
		this.sensorId = sensorId;
		return this;
	}

	public final short getSensorId() {
		return sensorId;
	}

	public final OpticalFlow setFlowX(short flowX) {
		this.flowX = flowX;
		return this;
	}

	public final short getFlowX() {
		return flowX;
	}

	public final OpticalFlow setFlowY(short flowY) {
		this.flowY = flowY;
		return this;
	}

	public final short getFlowY() {
		return flowY;
	}

	public final OpticalFlow setFlowCompMX(float flowCompMX) {
		this.flowCompMX = flowCompMX;
		return this;
	}

	public final float getFlowCompMX() {
		return flowCompMX;
	}

	public final OpticalFlow setFlowCompMY(float flowCompMY) {
		this.flowCompMY = flowCompMY;
		return this;
	}

	public final float getFlowCompMY() {
		return flowCompMY;
	}

	public final OpticalFlow setQuality(short quality) {
		this.quality = quality;
		return this;
	}

	public final short getQuality() {
		return quality;
	}

	public final OpticalFlow setGroundDistance(float groundDistance) {
		this.groundDistance = groundDistance;
		return this;
	}

	public final float getGroundDistance() {
		return groundDistance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			OpticalFlow other = (OpticalFlow)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.sensorId, other.sensorId)) {
				return false;
			} else if (!Objects.deepEquals(this.flowX, other.flowX)) {
				return false;
			} else if (!Objects.deepEquals(this.flowY, other.flowY)) {
				return false;
			} else if (!Objects.deepEquals(this.flowCompMX, other.flowCompMX)) {
				return false;
			} else if (!Objects.deepEquals(this.flowCompMY, other.flowCompMY)) {
				return false;
			} else if (!Objects.deepEquals(this.quality, other.quality)) {
				return false;
			} else {
				return Objects.deepEquals(this.groundDistance, other.groundDistance);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.sensorId);
		result = 31 * result + Objects.hashCode(this.flowX);
		result = 31 * result + Objects.hashCode(this.flowY);
		result = 31 * result + Objects.hashCode(this.flowCompMX);
		result = 31 * result + Objects.hashCode(this.flowCompMY);
		result = 31 * result + Objects.hashCode(this.quality);
		result = 31 * result + Objects.hashCode(this.groundDistance);
		return result;
	}

	@Override
	public String toString() {
		return "OpticalFlow{" +
				"timeUsec=" + timeUsec +
				", sensorId=" + sensorId +
				", flowX=" + flowX +
				", flowY=" + flowY +
				", flowCompMX=" + flowCompMX +
				", flowCompMY=" + flowCompMY +
				", quality=" + quality +
				", groundDistance=" + groundDistance +
				'}';
	}
}
