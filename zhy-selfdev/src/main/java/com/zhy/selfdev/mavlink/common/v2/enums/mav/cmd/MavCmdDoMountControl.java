package com.zhy.selfdev.mavlink.common.v2.enums.mav.cmd;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntry;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import com.zhy.selfdev.mavlink.common.v2.enums.MavMountMode;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 205, name = "MAV_CMD_DO_MOUNT_CONTROL", hasLocation = "false", isDestination = "false", description = "Mission command to control a camera or antenna mount")
public enum MavCmdDoMountControl {

	/**
	 * pitch depending on mount mode (degrees or degrees/second depending on pitch input).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Pitch")
	PARAM_1(),

	/**
	 * roll depending on mount mode (degrees or degrees/second depending on roll input).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Roll")
	PARAM_2(),

	/**
	 * yaw depending on mount mode (degrees or degrees/second depending on yaw input).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Yaw")
	PARAM_3(),

	/**
	 * altitude depending on mount mode.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Altitude", units = "m")
	PARAM_4(),

	/**
	 * latitude, set if appropriate mount mode.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude")
	PARAM_5(),

	/**
	 * longitude, set if appropriate mount mode.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude")
	PARAM_6(),

	/**
	 * Mount mode.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Mode", enum0 = MavMountMode.class)
	PARAM_7(),
}
