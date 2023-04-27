package com.zhy.selfdev.mavlink.common.v1.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_ROI")
public enum  MavRoi {

	/**
	 * No region of interest.
	 */
	@MavlinkEnumEntry(value = 0,description = "No region of interest.")
	MAV_ROI_NONE(),

	/**
	 * Point toward next MISSION.
	 */
	@MavlinkEnumEntry(value = 1,description = "Point toward next MISSION.")
	MAV_ROI_WPNEXT(),

	/**
	 * Point toward given MISSION.
	 */
	@MavlinkEnumEntry(value = 2,description = "Point toward given MISSION.")
	MAV_ROI_WPINDEX(),

	/**
	 * Point toward fixed location.
	 */
	@MavlinkEnumEntry(value = 3,description = "Point toward fixed location.")
	MAV_ROI_LOCATION(),

	/**
	 * Point toward of given id.
	 */
	@MavlinkEnumEntry(value = 4,description = "Point toward of given id.")
	MAV_ROI_TARGET(),
}
