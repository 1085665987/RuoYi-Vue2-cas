package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CAMERA_MODE")
public enum  CameraMode {

	/**
	 * Camera is in image/photo capture mode.
	 */
	@MavlinkEnumEntry(value = 0,description = "Camera is in image/photo capture mode.")
	CAMERA_MODE_IMAGE(),

	/**
	 * Camera is in video capture mode.
	 */
	@MavlinkEnumEntry(value = 1,description = "Camera is in video capture mode.")
	CAMERA_MODE_VIDEO(),

	/**
	 * Camera is in image survey capture mode. It allows for camera controller to do specific settings for surveys.
	 */
	@MavlinkEnumEntry(value = 2,description = "Camera is in image survey capture mode. It allows for camera controller to do specific settings for surveys.")
	CAMERA_MODE_IMAGE_SURVEY(),
}
