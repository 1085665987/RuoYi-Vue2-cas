package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAVLINK_DATA_STREAM_TYPE")
public enum  MavlinkDataStreamType {

	/**
	 *
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_JPEG(),

	/**
	 *
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_BMP(),

	/**
	 *
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_RAW8U(),

	/**
	 *
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_RAW32U(),

	/**
	 *
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_PGM(),

	/**
	 *
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_PNG(),
}
