package com.zhy.selfdev.mavlink.zhy.messages;

import com.zhy.selfdev.mavlink.annotation.MavlinkMessage;
import com.zhy.selfdev.mavlink.annotation.MavlinkMessageParam;
import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.zhy.enums.DoorState;
import com.zhy.selfdev.mavlink.protocol.ByteArray;
import com.zhy.selfdev.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2023.05.03 - 10:42
 **********************************/

@MavlinkMessage(
		id = 235,
		messagePayloadLength = 212,
		description = "安卓端定时向平台推送机巢状态数据，移动端到服务端参数 用 ZHY_NEST_STATUS接口传输"
)
public class ZhyNestStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "char", position = 1, typeSize = 1, streamLength = 50, description = "设备id")
	private String deviceId;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "时间戳")
	private long timestamp;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "机巢温度")
	private float nesttemp;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "机巢湿度")
	private float nesthumidity;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "传感器气压")
	private float pressure;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "传感器雨量")
	private float rainFall;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "传感器湿度")
	private float humidity;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 8, typeSize = 1, streamLength = 1, description = "传感器风速")
	private short windspeed;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 9, typeSize = 1, streamLength = 1, description = "风向")
	private short windHeading;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 10, typeSize = 1, streamLength = 1, description = "传感器温度")
	private short temperatureAir;

	@MavlinkMessageParam(mavlinkType = "char", position = 11, typeSize = 1, streamLength = 1, description = "是否连接无人机 1连接 0未连接")
	private String isConnectAircaft;

	@MavlinkMessageParam(mavlinkType = "char", position = 12, typeSize = 1, streamLength = 128, description = "无人机名称")
	private String aircaftName;

	@MavlinkMessageParam(mavlinkType = "char", position = 13, typeSize = 1, streamLength = 1, description = "机巢舱门状态 0关盖 1开关 2开盖中 3关盖中", enum0 = DoorState.class)
	private String doorstate;

	@MavlinkMessageParam(mavlinkType = "char", position = 14, typeSize = 1, streamLength = 1, description = "(暂时不用)")
	private String closedoor;

	@MavlinkMessageParam(mavlinkType = "char", position = 15, typeSize = 1, streamLength = 1, description = "机巢充电 1打开 0关闭")
	private String charge;

	@MavlinkMessageParam(mavlinkType = "char", position = 16, typeSize = 1, streamLength = 1, description = "机巢降温 1打开 0关闭")
	private String cooling;

	@MavlinkMessageParam(mavlinkType = "char", position = 17, typeSize = 1, streamLength = 1, description = "机巢加热 1打开 0关闭")
	private String heat;

	@MavlinkMessageParam(mavlinkType = "char", position = 18, typeSize = 1, streamLength = 1, description = "遥控器开关状态 1打开 0关闭")
	private String remotstatus;

	private final int messagePayloadLength = 212;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ZhyNestStatus(String deviceId, long timestamp, float nesttemp, float nesthumidity, float pressure, float rainFall, float humidity, short windspeed, short windHeading, short temperatureAir, String isConnectAircaft, String aircaftName, String doorstate, String closedoor, String charge, String cooling, String heat, String remotstatus) {
		this.deviceId = deviceId;
		this.timestamp = timestamp;
		this.nesttemp = nesttemp;
		this.nesthumidity = nesthumidity;
		this.pressure = pressure;
		this.rainFall = rainFall;
		this.humidity = humidity;
		this.windspeed = windspeed;
		this.windHeading = windHeading;
		this.temperatureAir = temperatureAir;
		this.isConnectAircaft = isConnectAircaft;
		this.aircaftName = aircaftName;
		this.doorstate = doorstate;
		this.closedoor = closedoor;
		this.charge = charge;
		this.cooling = cooling;
		this.heat = heat;
		this.remotstatus = remotstatus;
	}

	public ZhyNestStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 212！");
		}
		messagePayload(messagePayload);
	}

	public ZhyNestStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		deviceId = byteArray.getChars(0,50);
		timestamp = byteArray.getUnsignedInt32(50);
		nesttemp = byteArray.getFloat(54);
		nesthumidity = byteArray.getFloat(58);
		pressure = byteArray.getFloat(62);
		rainFall = byteArray.getFloat(66);
		humidity = byteArray.getFloat(70);
		windspeed = byteArray.getUnsignedInt8(74);
		windHeading = byteArray.getUnsignedInt8(75);
		temperatureAir = byteArray.getUnsignedInt8(76);
		isConnectAircaft = byteArray.getChars(77,1);
		aircaftName = byteArray.getChars(78,128);
		doorstate = byteArray.getChars(206,1);
		closedoor = byteArray.getChars(207,1);
		charge = byteArray.getChars(208,1);
		cooling = byteArray.getChars(209,1);
		heat = byteArray.getChars(210,1);
		remotstatus = byteArray.getChars(211,1);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putChars(deviceId,0);
		byteArray.putUnsignedInt32(timestamp,50);
		byteArray.putFloat(nesttemp,54);
		byteArray.putFloat(nesthumidity,58);
		byteArray.putFloat(pressure,62);
		byteArray.putFloat(rainFall,66);
		byteArray.putFloat(humidity,70);
		byteArray.putUnsignedInt8(windspeed,74);
		byteArray.putUnsignedInt8(windHeading,75);
		byteArray.putUnsignedInt8(temperatureAir,76);
		byteArray.putChars(isConnectAircaft,77);
		byteArray.putChars(aircaftName,78);
		byteArray.putChars(doorstate,206);
		byteArray.putChars(closedoor,207);
		byteArray.putChars(charge,208);
		byteArray.putChars(cooling,209);
		byteArray.putChars(heat,210);
		byteArray.putChars(remotstatus,211);
		return messagePayload;
	}

	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ZhyNestStatus setDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	public final String getDeviceId() {
		return deviceId;
	}

	public final ZhyNestStatus setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public final long getTimestamp() {
		return timestamp;
	}

	public final ZhyNestStatus setNesttemp(float nesttemp) {
		this.nesttemp = nesttemp;
		return this;
	}

	public final float getNesttemp() {
		return nesttemp;
	}

	public final ZhyNestStatus setNesthumidity(float nesthumidity) {
		this.nesthumidity = nesthumidity;
		return this;
	}

	public final float getNesthumidity() {
		return nesthumidity;
	}

	public final ZhyNestStatus setPressure(float pressure) {
		this.pressure = pressure;
		return this;
	}

	public final float getPressure() {
		return pressure;
	}

	public final ZhyNestStatus setRainFall(float rainFall) {
		this.rainFall = rainFall;
		return this;
	}

	public final float getRainFall() {
		return rainFall;
	}

	public final ZhyNestStatus setHumidity(float humidity) {
		this.humidity = humidity;
		return this;
	}

	public final float getHumidity() {
		return humidity;
	}

	public final ZhyNestStatus setWindspeed(short windspeed) {
		this.windspeed = windspeed;
		return this;
	}

	public final short getWindspeed() {
		return windspeed;
	}

	public final ZhyNestStatus setWindHeading(short windHeading) {
		this.windHeading = windHeading;
		return this;
	}

	public final short getWindHeading() {
		return windHeading;
	}

	public final ZhyNestStatus setTemperatureAir(short temperatureAir) {
		this.temperatureAir = temperatureAir;
		return this;
	}

	public final short getTemperatureAir() {
		return temperatureAir;
	}

	public final ZhyNestStatus setIsConnectAircaft(String isConnectAircaft) {
		this.isConnectAircaft = isConnectAircaft;
		return this;
	}

	public final String getIsConnectAircaft() {
		return isConnectAircaft;
	}

	public final ZhyNestStatus setAircaftName(String aircaftName) {
		this.aircaftName = aircaftName;
		return this;
	}

	public final String getAircaftName() {
		return aircaftName;
	}

	public final ZhyNestStatus setDoorstate(String doorstate) {
		this.doorstate = doorstate;
		return this;
	}

	public final String getDoorstate() {
		return doorstate;
	}

	public final ZhyNestStatus setClosedoor(String closedoor) {
		this.closedoor = closedoor;
		return this;
	}

	public final String getClosedoor() {
		return closedoor;
	}

	public final ZhyNestStatus setCharge(String charge) {
		this.charge = charge;
		return this;
	}

	public final String getCharge() {
		return charge;
	}

	public final ZhyNestStatus setCooling(String cooling) {
		this.cooling = cooling;
		return this;
	}

	public final String getCooling() {
		return cooling;
	}

	public final ZhyNestStatus setHeat(String heat) {
		this.heat = heat;
		return this;
	}

	public final String getHeat() {
		return heat;
	}

	public final ZhyNestStatus setRemotstatus(String remotstatus) {
		this.remotstatus = remotstatus;
		return this;
	}

	public final String getRemotstatus() {
		return remotstatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ZhyNestStatus other = (ZhyNestStatus)o;
			if (!Objects.deepEquals(this.deviceId, other.deviceId)) {
				return false;
			} else if (!Objects.deepEquals(this.timestamp, other.timestamp)) {
				return false;
			} else if (!Objects.deepEquals(this.nesttemp, other.nesttemp)) {
				return false;
			} else if (!Objects.deepEquals(this.nesthumidity, other.nesthumidity)) {
				return false;
			} else if (!Objects.deepEquals(this.pressure, other.pressure)) {
				return false;
			} else if (!Objects.deepEquals(this.rainFall, other.rainFall)) {
				return false;
			} else if (!Objects.deepEquals(this.humidity, other.humidity)) {
				return false;
			} else if (!Objects.deepEquals(this.windspeed, other.windspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.windHeading, other.windHeading)) {
				return false;
			} else if (!Objects.deepEquals(this.temperatureAir, other.temperatureAir)) {
				return false;
			} else if (!Objects.deepEquals(this.isConnectAircaft, other.isConnectAircaft)) {
				return false;
			} else if (!Objects.deepEquals(this.aircaftName, other.aircaftName)) {
				return false;
			} else if (!Objects.deepEquals(this.doorstate, other.doorstate)) {
				return false;
			} else if (!Objects.deepEquals(this.closedoor, other.closedoor)) {
				return false;
			} else if (!Objects.deepEquals(this.charge, other.charge)) {
				return false;
			} else if (!Objects.deepEquals(this.cooling, other.cooling)) {
				return false;
			} else if (!Objects.deepEquals(this.heat, other.heat)) {
				return false;
			} else {
				return Objects.deepEquals(this.remotstatus, other.remotstatus);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.deviceId);
		result = 31 * result + Objects.hashCode(this.timestamp);
		result = 31 * result + Objects.hashCode(this.nesttemp);
		result = 31 * result + Objects.hashCode(this.nesthumidity);
		result = 31 * result + Objects.hashCode(this.pressure);
		result = 31 * result + Objects.hashCode(this.rainFall);
		result = 31 * result + Objects.hashCode(this.humidity);
		result = 31 * result + Objects.hashCode(this.windspeed);
		result = 31 * result + Objects.hashCode(this.windHeading);
		result = 31 * result + Objects.hashCode(this.temperatureAir);
		result = 31 * result + Objects.hashCode(this.isConnectAircaft);
		result = 31 * result + Objects.hashCode(this.aircaftName);
		result = 31 * result + Objects.hashCode(this.doorstate);
		result = 31 * result + Objects.hashCode(this.closedoor);
		result = 31 * result + Objects.hashCode(this.charge);
		result = 31 * result + Objects.hashCode(this.cooling);
		result = 31 * result + Objects.hashCode(this.heat);
		result = 31 * result + Objects.hashCode(this.remotstatus);
		return result;
	}

	@Override
	public String toString() {
		return "ZhyNestStatus{" +
				"deviceId=" + deviceId +
				", timestamp=" + timestamp +
				", nesttemp=" + nesttemp +
				", nesthumidity=" + nesthumidity +
				", pressure=" + pressure +
				", rainFall=" + rainFall +
				", humidity=" + humidity +
				", windspeed=" + windspeed +
				", windHeading=" + windHeading +
				", temperatureAir=" + temperatureAir +
				", isConnectAircaft=" + isConnectAircaft +
				", aircaftName=" + aircaftName +
				", doorstate=" + doorstate +
				", closedoor=" + closedoor +
				", charge=" + charge +
				", cooling=" + cooling +
				", heat=" + heat +
				", remotstatus=" + remotstatus +
				'}';
	}
}
