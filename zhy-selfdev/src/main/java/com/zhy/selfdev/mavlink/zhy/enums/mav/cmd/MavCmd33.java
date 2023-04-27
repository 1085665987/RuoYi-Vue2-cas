package com.zhy.selfdev.mavlink.zhy.enums.mav.cmd;



import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntry;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2023.04.25 - 11:45
 **********************************/

@MavlinkEnumMavCmdEntry(value = 33, name = "MAV_CMD_33", hasLocation = "null", isDestination = "null", description = "msdk 手动飞行控制")
public enum MavCmd33 {

	/**
	 * actionParam 1: 移动，0: 停止移动；
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * actionParam=1时: roll 移动速度，roll大于0前进, roll小于0后退
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * actionParam=1时: pitch 移动速度，pitch大于0向右, pitch小于0向左
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * actionParam=1时: verticalThrottle 移动速度，verticalThrottle大于0上升，verticalThrottle小于0下降
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * actionParam=1时: yaw 移动速度， yaw大于0右转，yaw小于0左转
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),
}
