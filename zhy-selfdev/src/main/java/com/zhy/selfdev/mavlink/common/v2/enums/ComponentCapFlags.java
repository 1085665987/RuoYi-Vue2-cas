package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "COMPONENT_CAP_FLAGS", bitmask = "true")
public enum  ComponentCapFlags {

	/**
	 * Component has parameters, and supports the parameter protocol (PARAM messages).
	 */
	@MavlinkEnumEntry(value = 1,description = "Component has parameters, and supports the parameter protocol (PARAM messages).")
	COMPONENT_CAP_FLAGS_PARAM(),

	/**
	 * Component has parameters, and supports the extended parameter protocol (PARAM_EXT messages).
	 */
	@MavlinkEnumEntry(value = 2,description = "Component has parameters, and supports the extended parameter protocol (PARAM_EXT messages).")
	COMPONENT_CAP_FLAGS_PARAM_EXT(),
}
