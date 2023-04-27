package com.zhy.selfdev.mavlink.zhy.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2023.04.16 - 03:57
 *
 **********************************/

@MavlinkEnum(name = "LOG_LEVEL")
public enum  LogLevel {

	/**
	 * INFO
	 */
	@MavlinkEnumEntry(value = 0,description = "INFO")
	LOG_LEVEL_INFO(),

	/**
	 * LOG_LEVEL_NOTICE
	 */
	@MavlinkEnumEntry(value = 1,description = "LOG_LEVEL_NOTICE")
	LOG_LEVEL_NOTICE(),

	/**
	 * LOG_LEVEL_WARNING
	 */
	@MavlinkEnumEntry(value = 2,description = "LOG_LEVEL_WARNING")
	LOG_LEVEL_WARNING(),

	/**
	 * LOG_LEVEL_DEBUG
	 */
	@MavlinkEnumEntry(value = 3,description = "LOG_LEVEL_DEBUG")
	LOG_LEVEL_DEBUG(),

	/**
	 * LOG_LEVEL_ERROR
	 */
	@MavlinkEnumEntry(value = 4,description = "LOG_LEVEL_ERROR")
	LOG_LEVEL_ERROR(),

	/**
	 * LOG_LEVEL_CRITICAL，重要
	 */
	@MavlinkEnumEntry(value = 5,description = "LOG_LEVEL_CRITICAL，重要")
	LOG_LEVEL_CRITICAL(),

	/**
	 * LOG_LEVEL_ALERT，告警
	 */
	@MavlinkEnumEntry(value = 6,description = "LOG_LEVEL_ALERT，告警")
	LOG_LEVEL_ALERT(),

	/**
	 * LOG_LEVEL_EMERGENCY，紧急
	 */
	@MavlinkEnumEntry(value = 7,description = "LOG_LEVEL_EMERGENCY，紧急")
	LOG_LEVEL_EMERGENCY(),
}
