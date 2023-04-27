package com.zhy.selfdev.mavlink.zhy.enums;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnum;
import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2023.04.25 - 11:19
 *
 **********************************/

@MavlinkEnum(name = "ZHY_MAV_CMD")
public enum  ZhyMavCmd {

	/**
	 * 执行二维任务（平台未使用）
	 */
	@MavlinkEnumEntry(value = 0,description = "执行二维任务（平台未使用）")
	ZHY_MAV_CMD_0(),

	/**
	 * 执行三维任务（旧）,现在平台执行三维任务使用action指令41
	 */
	@MavlinkEnumEntry(value = 1,description = "执行三维任务（旧）,现在平台执行三维任务使用action指令41")
	ZHY_MAV_CMD_1(),

	/**
	 * 暂停
	 */
	@MavlinkEnumEntry(value = 2,description = "暂停")
	ZHY_MAV_CMD_2(),

	/**
	 * 恢复
	 */
	@MavlinkEnumEntry(value = 3,description = "恢复")
	ZHY_MAV_CMD_3(),

	/**
	 * 终止
	 */
	@MavlinkEnumEntry(value = 4,description = "终止")
	ZHY_MAV_CMD_4(),

	/**
	 * 回程
	 */
	@MavlinkEnumEntry(value = 5,description = "回程")
	ZHY_MAV_CMD_5(),

	/**
	 * 拍照
	 */
	@MavlinkEnumEntry(value = 6,description = "拍照")
	ZHY_MAV_CMD_6(),

	/**
	 * 开始录像
	 */
	@MavlinkEnumEntry(value = 7,description = "开始录像")
	ZHY_MAV_CMD_7(),

	/**
	 * 结束录像
	 */
	@MavlinkEnumEntry(value = 8,description = "结束录像")
	ZHY_MAV_CMD_8(),

	/**
	 * 镜头切换
	 */
	@MavlinkEnumEntry(value = 9,description = "镜头切换")
	ZHY_MAV_CMD_9(),

	/**
	 * 云台上升
	 */
	@MavlinkEnumEntry(value = 10,description = "云台上升")
	ZHY_MAV_CMD_10(),

	/**
	 * 云台下降
	 */
	@MavlinkEnumEntry(value = 11,description = "云台下降")
	ZHY_MAV_CMD_11(),

	/**
	 * 云台向左
	 */
	@MavlinkEnumEntry(value = 12,description = "云台向左")
	ZHY_MAV_CMD_12(),

	/**
	 * 云台向右
	 */
	@MavlinkEnumEntry(value = 13,description = "云台向右")
	ZHY_MAV_CMD_13(),

	/**
	 * 云台轴向顺时针旋转(平台未使用)
	 */
	@MavlinkEnumEntry(value = 14,description = "云台轴向顺时针旋转(平台未使用)")
	ZHY_MAV_CMD_14(),

	/**
	 * 云台轴向逆时针旋转(平台未使用)
	 */
	@MavlinkEnumEntry(value = 15,description = "云台轴向逆时针旋转(平台未使用)")
	ZHY_MAV_CMD_15(),

	/**
	 * 云台复位
	 */
	@MavlinkEnumEntry(value = 16,description = "云台复位")
	ZHY_MAV_CMD_16(),

	/**
	 * 云台转动停止
	 */
	@MavlinkEnumEntry(value = 17,description = "云台转动停止")
	ZHY_MAV_CMD_17(),

	/**
	 * 云台调远，焦距放大
	 */
	@MavlinkEnumEntry(value = 18,description = "云台调远，焦距放大")
	ZHY_MAV_CMD_18(),

	/**
	 * 云台拉近，焦距缩小
	 */
	@MavlinkEnumEntry(value = 19,description = "云台拉近，焦距缩小")
	ZHY_MAV_CMD_19(),

	/**
	 * 云台停止，停止焦距变化
	 */
	@MavlinkEnumEntry(value = 20,description = "云台停止，停止焦距变化")
	ZHY_MAV_CMD_20(),

	/**
	 * 云台控制(平台未使用)
	 */
	@MavlinkEnumEntry(value = 21,description = "云台控制(平台未使用)")
	ZHY_MAV_CMD_21(),

	/**
	 * 取消回程，取消返航
	 */
	@MavlinkEnumEntry(value = 22,description = "取消回程，取消返航")
	ZHY_MAV_CMD_22(),

	/**
	 * 开始跟随目标(平台未使用)
	 */
	@MavlinkEnumEntry(value = 23,description = "开始跟随目标(平台未使用)")
	ZHY_MAV_CMD_23(),

	/**
	 * 结束跟随目标(平台未使用)
	 */
	@MavlinkEnumEntry(value = 24,description = "结束跟随目标(平台未使用)")
	ZHY_MAV_CMD_24(),

	/**
	 * 开始直播
	 */
	@MavlinkEnumEntry(value = 25,description = "开始直播")
	ZHY_MAV_CMD_25(),

	/**
	 * 结束直播
	 */
	@MavlinkEnumEntry(value = 26,description = "结束直播")
	ZHY_MAV_CMD_26(),

	/**
	 * 机巢向服务器注册
	 */
	@MavlinkEnumEntry(value = 27,description = "机巢向服务器注册")
	ZHY_MAV_CMD_27(),

	/**
	 * 机巢准备
	 */
	@MavlinkEnumEntry(value = 28,description = "机巢准备")
	ZHY_MAV_CMD_28(),

	/**
	 * 机巢复位
	 */
	@MavlinkEnumEntry(value = 29,description = "机巢复位")
	ZHY_MAV_CMD_29(),

	/**
	 * 重启直播/修改飞机直播流媒体地址(未实现)
	 */
	@MavlinkEnumEntry(value = 30,description = "重启直播/修改飞机直播流媒体地址(未实现)")
	ZHY_MAV_CMD_30(),

	/**
	 * 到达航点
	 */
	@MavlinkEnumEntry(value = 31,description = "到达航点")
	ZHY_MAV_CMD_31(),

	/**
	 * 机巢重启
	 */
	@MavlinkEnumEntry(value = 32,description = "机巢重启")
	ZHY_MAV_CMD_32(),

	/**
	 * msdk 手动飞行控制
	 */
	@MavlinkEnumEntry(value = 33,description = "msdk 手动飞行控制")
	ZHY_MAV_CMD_33(),

	/**
	 * 无人机起飞
	 */
	@MavlinkEnumEntry(value = 34,description = "无人机起飞")
	ZHY_MAV_CMD_34(),

	/**
	 * 无人机降落
	 */
	@MavlinkEnumEntry(value = 35,description = "无人机降落")
	ZHY_MAV_CMD_35(),
}
