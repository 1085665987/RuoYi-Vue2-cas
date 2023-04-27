package com.zhy.selfdev.mavlink.common.v1.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_DISTANCE_SENSOR")
public enum  MavDistanceSensor {

	/**
	 * Laser altimeter, e.g. LightWare SF02/F or PulsedLight units
	 */
	@MavlinkEnumEntry(value = 0,description = "Laser altimeter, e.g. LightWare SF02/F or PulsedLight units")
	MAV_DISTANCE_SENSOR_LASER(),

	/**
	 * Ultrasound altimeter, e.g. MaxBotix units
	 */
	@MavlinkEnumEntry(value = 1,description = "Ultrasound altimeter, e.g. MaxBotix units")
	MAV_DISTANCE_SENSOR_ULTRASOUND(),
}
