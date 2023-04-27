package com.zhy.selfdev.mavlink.common.v1.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_BATTERY_FUNCTION")
public enum  MavBatteryFunction {

	/**
	 * Lithium polymere battery
	 */
	@MavlinkEnumEntry(value = 0,description = "Lithium polymere battery")
	MAV_BATTERY_FUNCTION_UNKNOWN(),

	/**
	 * Battery supports all flight systems
	 */
	@MavlinkEnumEntry(value = 1,description = "Battery supports all flight systems")
	MAV_BATTERY_FUNCTION_ALL(),

	/**
	 * Battery for the propulsion system
	 */
	@MavlinkEnumEntry(value = 2,description = "Battery for the propulsion system")
	MAV_BATTERY_FUNCTION_PROPULSION(),

	/**
	 * Avionics battery
	 */
	@MavlinkEnumEntry(value = 3,description = "Avionics battery")
	MAV_BATTERY_FUNCTION_AVIONICS(),

	/**
	 * Payload battery
	 */
	@MavlinkEnumEntry(value = 4,description = "Payload battery")
	MAV_BATTERY_TYPE_PAYLOAD(),
}
