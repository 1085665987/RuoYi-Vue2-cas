package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "VIDEO_STREAM_STATUS_FLAGS", bitmask = "true")
public enum  VideoStreamStatusFlags {

	/**
	 * Stream is active (running)
	 */
	@MavlinkEnumEntry(value = 1,description = "Stream is active (running)")
	VIDEO_STREAM_STATUS_FLAGS_RUNNING(),

	/**
	 * Stream is thermal imaging
	 */
	@MavlinkEnumEntry(value = 2,description = "Stream is thermal imaging")
	VIDEO_STREAM_STATUS_FLAGS_THERMAL(),
}
