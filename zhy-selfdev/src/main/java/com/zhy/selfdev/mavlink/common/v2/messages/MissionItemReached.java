package com.zhy.selfdev.mavlink.common.v2.messages;

import com.zhy.selfdev.mavlink.annotation.MavlinkMessage;
import com.zhy.selfdev.mavlink.annotation.MavlinkMessageParam;
import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.protocol.ByteArray;
import com.zhy.selfdev.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 46,
		messagePayloadLength = 2,
		description = "A certain mission item has been reached. The system will either hold this position (or circle on the orbit) or (if the autocontinue on the WP was set) continue to the next waypoint."
)
public class MissionItemReached implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "Sequence")
	private int seq;

	private final int messagePayloadLength = 2;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MissionItemReached(int seq) {
		this.seq = seq;
	}

	public MissionItemReached(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 2！");
		}
		messagePayload(messagePayload);
	}

	public MissionItemReached(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		seq = byteArray.getUnsignedInt16(0);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(seq,0);
		return messagePayload;
	}

	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MissionItemReached setSeq(int seq) {
		this.seq = seq;
		return this;
	}

	public final int getSeq() {
		return seq;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			MissionItemReached other = (MissionItemReached)o;
			return Objects.deepEquals(this.seq, other.seq);		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.seq);
		return result;
	}

	@Override
	public String toString() {
		return "MissionItemReached{" +
				"seq=" + seq +
				'}';
	}
}
