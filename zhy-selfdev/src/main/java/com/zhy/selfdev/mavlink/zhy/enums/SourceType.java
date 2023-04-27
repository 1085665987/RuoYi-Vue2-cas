package com.zhy.selfdev.mavlink.zhy.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2023.04.16 - 03:57
 *
 **********************************/

@MavlinkEnum(name = "SOURCE_TYPE")
public enum  SourceType {

	/**
	 * MSDK-android
	 */
	@MavlinkEnumEntry(value = 1,description = "MSDK-android")
	SOURCE_TYPE_MSDK_ANDROID(),

	/**
	 * OSDK
	 */
	@MavlinkEnumEntry(value = 2,description = "OSDK")
	SOURCE_TYPE_OSDK(),

	/**
	 * SERVER
	 */
	@MavlinkEnumEntry(value = 3,description = "SERVER")
	SOURCE_TYPE_SERVER(),

	/**
	 * WEB页面
	 */
	@MavlinkEnumEntry(value = 4,description = "WEB页面")
	SOURCE_TYPE_WEB_PAGE(),
}
