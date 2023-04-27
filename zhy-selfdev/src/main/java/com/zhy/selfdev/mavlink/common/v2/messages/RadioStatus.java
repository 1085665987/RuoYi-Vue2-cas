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
		id = 109,
		messagePayloadLength = 9,
		description = "Status generated by radio and injected into MAVLink stream."
)
public class RadioStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Local (message sender) recieved signal strength indication in device-dependent units/scale. Values: [0-254], 255: invalid/unknown.")
	private short rssi;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Remote (message receiver) signal strength indication in device-dependent units/scale. Values: [0-254], 255: invalid/unknown.")
	private short remrssi;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Remaining free transmitter buffer space.", units = "%")
	private short txbuf;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Local background noise level. These are device dependent RSSI values (scale as approx 2x dB on SiK radios). Values: [0-254], 255: invalid/unknown.")
	private short noise;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Remote background noise level. These are device dependent RSSI values (scale as approx 2x dB on SiK radios). Values: [0-254], 255: invalid/unknown.")
	private short remnoise;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Count of radio packet receive errors (since boot).")
	private int rxerrors;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "Count of error corrected radio packets (since boot).")
	private int fixed;

	private final int messagePayloadLength = 9;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public RadioStatus(short rssi, short remrssi, short txbuf, short noise, short remnoise, int rxerrors, int fixed) {
		this.rssi = rssi;
		this.remrssi = remrssi;
		this.txbuf = txbuf;
		this.noise = noise;
		this.remnoise = remnoise;
		this.rxerrors = rxerrors;
		this.fixed = fixed;
	}

	public RadioStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 9！");
		}
		messagePayload(messagePayload);
	}

	public RadioStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		rssi = byteArray.getUnsignedInt8(0);
		remrssi = byteArray.getUnsignedInt8(1);
		txbuf = byteArray.getUnsignedInt8(2);
		noise = byteArray.getUnsignedInt8(3);
		remnoise = byteArray.getUnsignedInt8(4);
		rxerrors = byteArray.getUnsignedInt16(5);
		fixed = byteArray.getUnsignedInt16(7);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(rssi,0);
		byteArray.putUnsignedInt8(remrssi,1);
		byteArray.putUnsignedInt8(txbuf,2);
		byteArray.putUnsignedInt8(noise,3);
		byteArray.putUnsignedInt8(remnoise,4);
		byteArray.putUnsignedInt16(rxerrors,5);
		byteArray.putUnsignedInt16(fixed,7);
		return messagePayload;
	}

	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final RadioStatus setRssi(short rssi) {
		this.rssi = rssi;
		return this;
	}

	public final short getRssi() {
		return rssi;
	}

	public final RadioStatus setRemrssi(short remrssi) {
		this.remrssi = remrssi;
		return this;
	}

	public final short getRemrssi() {
		return remrssi;
	}

	public final RadioStatus setTxbuf(short txbuf) {
		this.txbuf = txbuf;
		return this;
	}

	public final short getTxbuf() {
		return txbuf;
	}

	public final RadioStatus setNoise(short noise) {
		this.noise = noise;
		return this;
	}

	public final short getNoise() {
		return noise;
	}

	public final RadioStatus setRemnoise(short remnoise) {
		this.remnoise = remnoise;
		return this;
	}

	public final short getRemnoise() {
		return remnoise;
	}

	public final RadioStatus setRxerrors(int rxerrors) {
		this.rxerrors = rxerrors;
		return this;
	}

	public final int getRxerrors() {
		return rxerrors;
	}

	public final RadioStatus setFixed(int fixed) {
		this.fixed = fixed;
		return this;
	}

	public final int getFixed() {
		return fixed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			RadioStatus other = (RadioStatus)o;
			if (!Objects.deepEquals(this.rssi, other.rssi)) {
				return false;
			} else if (!Objects.deepEquals(this.remrssi, other.remrssi)) {
				return false;
			} else if (!Objects.deepEquals(this.txbuf, other.txbuf)) {
				return false;
			} else if (!Objects.deepEquals(this.noise, other.noise)) {
				return false;
			} else if (!Objects.deepEquals(this.remnoise, other.remnoise)) {
				return false;
			} else if (!Objects.deepEquals(this.rxerrors, other.rxerrors)) {
				return false;
			} else {
				return Objects.deepEquals(this.fixed, other.fixed);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.rssi);
		result = 31 * result + Objects.hashCode(this.remrssi);
		result = 31 * result + Objects.hashCode(this.txbuf);
		result = 31 * result + Objects.hashCode(this.noise);
		result = 31 * result + Objects.hashCode(this.remnoise);
		result = 31 * result + Objects.hashCode(this.rxerrors);
		result = 31 * result + Objects.hashCode(this.fixed);
		return result;
	}

	@Override
	public String toString() {
		return "RadioStatus{" +
				"rssi=" + rssi +
				", remrssi=" + remrssi +
				", txbuf=" + txbuf +
				", noise=" + noise +
				", remnoise=" + remnoise +
				", rxerrors=" + rxerrors +
				", fixed=" + fixed +
				'}';
	}
}
