package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_DO_REPOSITION_FLAGS", bitmask = "true")
public enum  MavDoRepositionFlags {

	/**
	 * The aircraft should immediately transition into guided. This should not be set for follow me applications
	 */
	@MavlinkEnumEntry(value = 1,description = "The aircraft should immediately transition into guided. This should not be set for follow me applications")
	MAV_DO_REPOSITION_FLAGS_CHANGE_MODE(),
}
