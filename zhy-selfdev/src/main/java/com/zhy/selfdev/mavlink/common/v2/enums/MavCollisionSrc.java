package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_COLLISION_SRC")
public enum  MavCollisionSrc {

	/**
	 * ID field references ADSB_VEHICLE packets
	 */
	@MavlinkEnumEntry(value = 0,description = "ID field references ADSB_VEHICLE packets")
	MAV_COLLISION_SRC_ADSB(),

	/**
	 * ID field references MAVLink SRC ID
	 */
	@MavlinkEnumEntry(value = 1,description = "ID field references MAVLink SRC ID")
	MAV_COLLISION_SRC_MAVLINK_GPS_GLOBAL_INT(),
}
