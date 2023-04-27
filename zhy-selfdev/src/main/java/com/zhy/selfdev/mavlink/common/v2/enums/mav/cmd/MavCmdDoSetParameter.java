package com.zhy.selfdev.mavlink.common.v2.enums.mav.cmd;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntry;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 180, name = "MAV_CMD_DO_SET_PARAMETER", hasLocation = "false", isDestination = "false", description = "Set a system parameter. Caution! Use of this command requires knowledge of the numeric enumeration value of the parameter.")
public enum MavCmdDoSetParameter {

	/**
	 * Parameter number
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Number", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Parameter value
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Value")
	PARAM_2(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
