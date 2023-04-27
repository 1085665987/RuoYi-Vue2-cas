package com.zhy.selfdev.mavlink.common.v2.enums.mav.cmd;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntry;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2505, name = "MAV_CMD_REQUEST_VIDEO_STREAM_STATUS", hasLocation = "false", isDestination = "false", description = "Request video stream status (VIDEO_STREAM_STATUS)")
public enum MavCmdRequestVideoStreamStatus {

	/**
	 * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Stream ID", minValue = 0, increment = 1)
	PARAM_1(),
}
