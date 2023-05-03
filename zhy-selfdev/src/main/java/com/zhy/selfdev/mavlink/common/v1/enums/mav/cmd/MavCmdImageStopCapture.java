package com.zhy.selfdev.mavlink.common.v1.enums.mav.cmd;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntry;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2001, name = "MAV_CMD_IMAGE_STOP_CAPTURE", hasLocation = "null", isDestination = "null", description = "Stop image capture sequence")
public enum MavCmdImageStopCapture {

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),
}