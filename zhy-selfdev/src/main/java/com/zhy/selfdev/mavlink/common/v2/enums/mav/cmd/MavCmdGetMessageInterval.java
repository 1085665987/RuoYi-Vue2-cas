package com.zhy.selfdev.mavlink.common.v2.enums.mav.cmd;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntry;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 510, name = "MAV_CMD_GET_MESSAGE_INTERVAL", hasLocation = "false", isDestination = "false", description = "Request the interval between messages for a particular MAVLink message ID. The receiver should ACK the command and then emit its response in a MESSAGE_INTERVAL message.")
public enum MavCmdGetMessageInterval {

	/**
	 * The MAVLink message ID
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Message ID", minValue = 0, maxValue = 16777215, increment = 1)
	PARAM_1(),
}
