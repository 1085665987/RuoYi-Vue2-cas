package com.zhy.selfdev.mavlink.common.v2.enums.mav.cmd;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntry;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 31007, name = "MAV_CMD_SPATIAL_USER_3", hasLocation = "true", isDestination = "false", description = "User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.")
public enum MavCmdSpatialUser3 {

	/**
	 * User defined
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * User defined
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * User defined
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * User defined
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Latitude unscaled
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude")
	PARAM_5(),

	/**
	 * Longitude unscaled
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude")
	PARAM_6(),

	/**
	 * Altitude (MSL)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Altitude", units = "m")
	PARAM_7(),
}