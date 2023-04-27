package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_STATUS")
public enum  MavOdidStatus {

	/**
	 * The status of the (UA) Unmanned Aircraft is undefined.
	 */
	@MavlinkEnumEntry(value = 0,description = "The status of the (UA) Unmanned Aircraft is undefined.")
	MAV_ODID_STATUS_UNDECLARED(),

	/**
	 * The UA is on the ground.
	 */
	@MavlinkEnumEntry(value = 1,description = "The UA is on the ground.")
	MAV_ODID_STATUS_GROUND(),

	/**
	 * The UA is in the air.
	 */
	@MavlinkEnumEntry(value = 2,description = "The UA is in the air.")
	MAV_ODID_STATUS_AIRBORNE(),

	/**
	 * The UA is having an emergency.
	 */
	@MavlinkEnumEntry(value = 3,description = "The UA is having an emergency.")
	MAV_ODID_STATUS_EMERGENCY(),
}
