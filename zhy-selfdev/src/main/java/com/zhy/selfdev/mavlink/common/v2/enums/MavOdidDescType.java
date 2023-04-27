package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_DESC_TYPE")
public enum  MavOdidDescType {

	/**
	 * Free-form text description of the purpose of the flight.
	 */
	@MavlinkEnumEntry(value = 0,description = "Free-form text description of the purpose of the flight.")
	MAV_ODID_DESC_TYPE_TEXT(),
}
