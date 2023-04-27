package com.zhy.selfdev.mavlink.zhy.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2023.04.16 - 03:57
 *
 **********************************/

@MavlinkEnum(name = "DEVICE_TYPE")
public enum  DeviceType {

	/**
	 * MSDK-android
	 */
	@MavlinkEnumEntry(value = 1,description = "MSDK-android")
	DEVICE_TYPE_MSDK_ANDROID(),

	/**
	 * OSDK
	 */
	@MavlinkEnumEntry(value = 2,description = "OSDK")
	DEVICE_TYPE_OSDK(),

	/**
	 * 机巢
	 */
	@MavlinkEnumEntry(value = 3,description = "机巢")
	DEVICE_TYPE_DEVICE(),
}
