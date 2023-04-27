package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "RTK_BASELINE_COORDINATE_SYSTEM")
public enum  RtkBaselineCoordinateSystem {

	/**
	 * Earth-centered, Earth-fixed
	 */
	@MavlinkEnumEntry(value = 0,description = "Earth-centered, Earth-fixed")
	RTK_BASELINE_COORDINATE_SYSTEM_ECEF(),

	/**
	 * RTK basestation centered, north, east, down
	 */
	@MavlinkEnumEntry(value = 1,description = "RTK basestation centered, north, east, down")
	RTK_BASELINE_COORDINATE_SYSTEM_NED(),
}
