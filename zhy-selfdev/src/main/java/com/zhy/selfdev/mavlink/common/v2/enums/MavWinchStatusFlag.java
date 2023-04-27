package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_WINCH_STATUS_FLAG", bitmask = "true")
public enum  MavWinchStatusFlag {

	/**
	 * Winch is healthy
	 */
	@MavlinkEnumEntry(value = 1,description = "Winch is healthy")
	MAV_WINCH_STATUS_HEALTHY(),

	/**
	 * Winch thread is fully retracted
	 */
	@MavlinkEnumEntry(value = 2,description = "Winch thread is fully retracted")
	MAV_WINCH_STATUS_FULLY_RETRACTED(),

	/**
	 * Winch motor is moving
	 */
	@MavlinkEnumEntry(value = 4,description = "Winch motor is moving")
	MAV_WINCH_STATUS_MOVING(),

	/**
	 * Winch clutch is engaged allowing motor to move freely
	 */
	@MavlinkEnumEntry(value = 8,description = "Winch clutch is engaged allowing motor to move freely")
	MAV_WINCH_STATUS_CLUTCH_ENGAGED(),
}
