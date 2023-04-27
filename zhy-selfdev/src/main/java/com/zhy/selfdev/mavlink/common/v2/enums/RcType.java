package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "RC_TYPE")
public enum  RcType {

	/**
	 * Spektrum DSM2
	 */
	@MavlinkEnumEntry(value = 0,description = "Spektrum DSM2")
	RC_TYPE_SPEKTRUM_DSM2(),

	/**
	 * Spektrum DSMX
	 */
	@MavlinkEnumEntry(value = 1,description = "Spektrum DSMX")
	RC_TYPE_SPEKTRUM_DSMX(),
}
