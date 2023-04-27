package com.zhy.selfdev.mavlink.zhy.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2023.04.16 - 03:57
 *
 **********************************/

@MavlinkEnum(name = "SHOT_CHANGE")
public enum  ShotChange {

	/**
	 * 循环
	 */
	@MavlinkEnumEntry(value = -1,description = "循环")
	SHOT_CHANGE_LOOP(),

	/**
	 * 可见光
	 */
	@MavlinkEnumEntry(value = 1,description = "可见光")
	SHOT_CHANGE_VISIBLE_LIGHT(),

	/**
	 * 红外
	 */
	@MavlinkEnumEntry(value = 2,description = "红外")
	SHOT_CHANGE_INFRARED(),

	/**
	 * 双光
	 */
	@MavlinkEnumEntry(value = 3,description = "双光")
	SHOT_CHANGE_BIFOCAL(),

	/**
	 * 变焦(M300)
	 */
	@MavlinkEnumEntry(value = 4,description = "变焦(M300)")
	SHOT_CHANGE_ZOOM(),
}
