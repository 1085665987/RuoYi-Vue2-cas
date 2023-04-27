package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "ADSB_ALTITUDE_TYPE")
public enum  AdsbAltitudeType {

	/**
	 * Altitude reported from a Baro source using QNH reference
	 */
	@MavlinkEnumEntry(value = 0,description = "Altitude reported from a Baro source using QNH reference")
	ADSB_ALTITUDE_TYPE_PRESSURE_QNH(),

	/**
	 * Altitude reported from a GNSS source
	 */
	@MavlinkEnumEntry(value = 1,description = "Altitude reported from a GNSS source")
	ADSB_ALTITUDE_TYPE_GEOMETRIC(),
}
