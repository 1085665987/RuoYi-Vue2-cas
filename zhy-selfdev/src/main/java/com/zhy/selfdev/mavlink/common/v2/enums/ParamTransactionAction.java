package com.zhy.selfdev.mavlink.common.v2.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "PARAM_TRANSACTION_ACTION")
public enum  ParamTransactionAction {

	/**
	 * Commit the current parameter transaction.
	 */
	@MavlinkEnumEntry(value = 0,description = "Commit the current parameter transaction.")
	PARAM_TRANSACTION_ACTION_START(),

	/**
	 * Commit the current parameter transaction.
	 */
	@MavlinkEnumEntry(value = 1,description = "Commit the current parameter transaction.")
	PARAM_TRANSACTION_ACTION_COMMIT(),

	/**
	 * Cancel the current parameter transaction.
	 */
	@MavlinkEnumEntry(value = 2,description = "Cancel the current parameter transaction.")
	PARAM_TRANSACTION_ACTION_CANCEL(),
}
