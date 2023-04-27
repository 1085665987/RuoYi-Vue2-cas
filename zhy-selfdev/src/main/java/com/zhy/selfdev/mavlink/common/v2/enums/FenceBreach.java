package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "FENCE_BREACH")
public enum  FenceBreach {

	/**
	 * No last fence breach
	 */
	@MavlinkEnumEntry(value = 0,description = "No last fence breach")
	FENCE_BREACH_NONE(),

	/**
	 * Breached minimum altitude
	 */
	@MavlinkEnumEntry(value = 1,description = "Breached minimum altitude")
	FENCE_BREACH_MINALT(),

	/**
	 * Breached maximum altitude
	 */
	@MavlinkEnumEntry(value = 2,description = "Breached maximum altitude")
	FENCE_BREACH_MAXALT(),

	/**
	 * Breached fence boundary
	 */
	@MavlinkEnumEntry(value = 3,description = "Breached fence boundary")
	FENCE_BREACH_BOUNDARY(),
}
