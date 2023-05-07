package com.zhy.selfdev.mavlink.zhy.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2023.05.03 - 10:42
 *
 **********************************/

@MavlinkEnum(name = "DOOR_STATE")
public enum  DoorState {

	/**
	 * 关盖
	 */
	@MavlinkEnumEntry(value = 0,description = "关盖")
	DOOR_STATE_CLOSED(),

	/**
	 * 开盖
	 */
	@MavlinkEnumEntry(value = 1,description = "开盖")
	DOOR_STATE_VISIBLE_OPEN(),

	/**
	 * 开盖中
	 */
	@MavlinkEnumEntry(value = 2,description = "开盖中")
	DOOR_STATE_OPENING(),

	/**
	 * 关盖中
	 */
	@MavlinkEnumEntry(value = 3,description = "关盖中")
	DOOR_STATE_CLOSING(),
}
