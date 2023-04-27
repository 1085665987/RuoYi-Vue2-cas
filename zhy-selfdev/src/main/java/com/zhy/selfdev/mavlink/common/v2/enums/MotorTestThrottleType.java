package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MOTOR_TEST_THROTTLE_TYPE")
public enum  MotorTestThrottleType {

	/**
	 * throttle as a percentage from 0 ~ 100
	 */
	@MavlinkEnumEntry(value = 0,description = "throttle as a percentage from 0 ~ 100")
	MOTOR_TEST_THROTTLE_PERCENT(),

	/**
	 * throttle as an absolute PWM value (normally in range of 1000~2000)
	 */
	@MavlinkEnumEntry(value = 1,description = "throttle as an absolute PWM value (normally in range of 1000~2000)")
	MOTOR_TEST_THROTTLE_PWM(),

	/**
	 * throttle pass-through from pilot's transmitter
	 */
	@MavlinkEnumEntry(value = 2,description = "throttle pass-through from pilot's transmitter")
	MOTOR_TEST_THROTTLE_PILOT(),

	/**
	 * per-motor compass calibration test
	 */
	@MavlinkEnumEntry(value = 3,description = "per-motor compass calibration test")
	MOTOR_TEST_COMPASS_CAL(),
}
