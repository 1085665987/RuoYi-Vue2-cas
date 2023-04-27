package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_OPERATOR_LOCATION_TYPE")
public enum  MavOdidOperatorLocationType {

	/**
	 * The location of the operator is the same as the take-off location.
	 */
	@MavlinkEnumEntry(value = 0,description = "The location of the operator is the same as the take-off location.")
	MAV_ODID_OPERATOR_LOCATION_TYPE_TAKEOFF(),

	/**
	 * The location of the operator is based on live GNSS data.
	 */
	@MavlinkEnumEntry(value = 1,description = "The location of the operator is based on live GNSS data.")
	MAV_ODID_OPERATOR_LOCATION_TYPE_LIVE_GNSS(),

	/**
	 * The location of the operator is a fixed location.
	 */
	@MavlinkEnumEntry(value = 2,description = "The location of the operator is a fixed location.")
	MAV_ODID_OPERATOR_LOCATION_TYPE_FIXED(),
}
