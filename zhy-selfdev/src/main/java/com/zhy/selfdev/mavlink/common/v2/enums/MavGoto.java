package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_GOTO")
public enum  MavGoto {

	/**
	 * Hold at the current position.
	 */
	@MavlinkEnumEntry(value = 0,description = "Hold at the current position.")
	MAV_GOTO_DO_HOLD(),

	/**
	 * Continue with the next item in mission execution.
	 */
	@MavlinkEnumEntry(value = 1,description = "Continue with the next item in mission execution.")
	MAV_GOTO_DO_CONTINUE(),

	/**
	 * Hold at the current position of the system
	 */
	@MavlinkEnumEntry(value = 2,description = "Hold at the current position of the system")
	MAV_GOTO_HOLD_AT_CURRENT_POSITION(),

	/**
	 * Hold at the position specified in the parameters of the DO_HOLD action
	 */
	@MavlinkEnumEntry(value = 3,description = "Hold at the position specified in the parameters of the DO_HOLD action")
	MAV_GOTO_HOLD_AT_SPECIFIED_POSITION(),
}
