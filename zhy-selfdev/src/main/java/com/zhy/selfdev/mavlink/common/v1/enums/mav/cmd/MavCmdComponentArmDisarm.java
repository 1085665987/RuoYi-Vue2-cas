package com.zhy.selfdev.mavlink.common.v1.enums.mav.cmd;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntry;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkEnumMavCmdEntry(value = 400, name = "MAV_CMD_COMPONENT_ARM_DISARM", hasLocation = "null", isDestination = "null", description = "Arms / Disarms a component")
public enum MavCmdComponentArmDisarm {

	/**
	 * 1 to arm, 0 to disarm
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),
}
