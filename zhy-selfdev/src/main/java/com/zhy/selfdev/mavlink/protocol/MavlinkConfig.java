package com.zhy.selfdev.mavlink.protocol;

import com.zhy.selfdev.mavlink.annotation.MavlinkEnumEntry;
import com.zhy.selfdev.mavlink.annotation.MavlinkMessage;
import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.common.v2.messages.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.04 - 20:01
 **********************************/

public class MavlinkConfig {
	private static final HashSet<Class<? extends Message>> FILTER_MESSAGE = new HashSet<>();
	private static final HashMap<Integer,Integer> CRC_BOX = new HashMap<>();
	private static final HashMap<Integer,Class<? extends Message>> MESSAGE_BOX = new HashMap<>();

	static {
		setVersion(Version.MAVLINK_V1);
		setCrcBox();
	}

	public static void setVersion(Version version){
		MESSAGE_BOX.clear();
		if (version.equals(Version.MAVLINK_V1)){
			setMessageBoxVersion1();
		}else if (version.equals(Version.MAVLINK_V2)){
			setMessageBoxVersion2();
		}
	}

	public static void registerMessage(Class<? extends Message> messageClass){
		Type[] genericInterfaces = messageClass.getGenericInterfaces();
		if (Arrays.asList(genericInterfaces).contains(Message.class)){
			int id = messageClass.getAnnotation(MavlinkMessage.class).id();
			MESSAGE_BOX.put(id,messageClass);
		}
	}

	public static HashMap<Integer,Class<? extends Message>> allType(){
		return MESSAGE_BOX;
	}

	public static boolean isContainsType(int id){
		return MESSAGE_BOX.containsKey(id);
	}

	public static boolean isContainsType(Class<?> messageType){
		return MESSAGE_BOX.containsValue(messageType);
	}

	@SafeVarargs
	public static HashSet<Class<? extends Message>> addFilter(Class<? extends Message>... messageType) {
		if (Objects.nonNull(messageType)) {
			FILTER_MESSAGE.addAll(Arrays.asList(messageType));
		}
		return FILTER_MESSAGE;
	}

	public static HashMap<Integer,Integer> getCrcBox(){
		  return CRC_BOX;
	}

	private static void setMessageBoxVersion2(){
		MESSAGE_BOX.put(1, SysStatus.class);
		MESSAGE_BOX.put(2, SystemTime.class);
		MESSAGE_BOX.put(4, Ping.class);
		MESSAGE_BOX.put(5, ChangeOperatorControl.class);
		MESSAGE_BOX.put(6, ChangeOperatorControlAck.class);
		MESSAGE_BOX.put(7, AuthKey.class);
		MESSAGE_BOX.put(8, LinkNodeStatus.class);
		MESSAGE_BOX.put(11, SetMode.class);
		MESSAGE_BOX.put(19, ParamAckTransaction.class);
		MESSAGE_BOX.put(20, ParamRequestRead.class);
		MESSAGE_BOX.put(21, ParamRequestList.class);
		MESSAGE_BOX.put(22, ParamValue.class);
		MESSAGE_BOX.put(23, ParamSet.class);
		MESSAGE_BOX.put(24, GpsRawInt.class);
		MESSAGE_BOX.put(25, GpsStatus.class);
		MESSAGE_BOX.put(26, ScaledImu.class);
		MESSAGE_BOX.put(27, RawImu.class);
		MESSAGE_BOX.put(28, RawPressure.class);
		MESSAGE_BOX.put(29, ScaledPressure.class);
		MESSAGE_BOX.put(30, Attitude.class);
		MESSAGE_BOX.put(31, AttitudeQuaternion.class);
		MESSAGE_BOX.put(32, LocalPositionNed.class);
		MESSAGE_BOX.put(33, GlobalPositionInt.class);
		MESSAGE_BOX.put(34, RcChannelsScaled.class);
		MESSAGE_BOX.put(35, RcChannelsRaw.class);
		MESSAGE_BOX.put(36, ServoOutputRaw.class);
		MESSAGE_BOX.put(37, MissionRequestPartialList.class);
		MESSAGE_BOX.put(38, MissionWritePartialList.class);
		MESSAGE_BOX.put(39, MissionItem.class);
		MESSAGE_BOX.put(40, MissionRequest.class);
		MESSAGE_BOX.put(41, MissionSetCurrent.class);
		MESSAGE_BOX.put(42, MissionCurrent.class);
		MESSAGE_BOX.put(43, MissionRequestList.class);
		MESSAGE_BOX.put(44, MissionCount.class);
		MESSAGE_BOX.put(45, MissionClearAll.class);
		MESSAGE_BOX.put(46, MissionItemReached.class);
		MESSAGE_BOX.put(47, MissionAck.class);
		MESSAGE_BOX.put(48, SetGpsGlobalOrigin.class);
		MESSAGE_BOX.put(49, GpsGlobalOrigin.class);
		MESSAGE_BOX.put(50, ParamMapRc.class);
		MESSAGE_BOX.put(51, MissionRequestInt.class);
		MESSAGE_BOX.put(52, MissionChanged.class);
		MESSAGE_BOX.put(54, SafetySetAllowedArea.class);
		MESSAGE_BOX.put(55, SafetyAllowedArea.class);
		MESSAGE_BOX.put(61, AttitudeQuaternionCov.class);
		MESSAGE_BOX.put(62, NavControllerOutput.class);
		MESSAGE_BOX.put(63, GlobalPositionIntCov.class);
		MESSAGE_BOX.put(64, LocalPositionNedCov.class);
		MESSAGE_BOX.put(65, RcChannels.class);
		MESSAGE_BOX.put(66, RequestDataStream.class);
		MESSAGE_BOX.put(67, DataStream.class);
		MESSAGE_BOX.put(69, ManualControl.class);
		MESSAGE_BOX.put(70, RcChannelsOverride.class);
		MESSAGE_BOX.put(73, MissionItemInt.class);
		MESSAGE_BOX.put(74, VfrHud.class);
		MESSAGE_BOX.put(75, CommandInt.class);
		MESSAGE_BOX.put(76, CommandLong.class);
		MESSAGE_BOX.put(77, CommandAck.class);
		MESSAGE_BOX.put(80, CommandCancel.class);
		MESSAGE_BOX.put(81, ManualSetpoint.class);
		MESSAGE_BOX.put(82, SetAttitudeTarget.class);
		MESSAGE_BOX.put(83, AttitudeTarget.class);
		MESSAGE_BOX.put(84, SetPositionTargetLocalNed.class);
		MESSAGE_BOX.put(85, PositionTargetLocalNed.class);
		MESSAGE_BOX.put(86, SetPositionTargetGlobalInt.class);
		MESSAGE_BOX.put(87, PositionTargetGlobalInt.class);
		MESSAGE_BOX.put(89, LocalPositionNedSystemGlobalOffset.class);
		MESSAGE_BOX.put(90, HilState.class);
		MESSAGE_BOX.put(91, HilControls.class);
		MESSAGE_BOX.put(92, HilRcInputsRaw.class);
		MESSAGE_BOX.put(93, HilActuatorControls.class);
		MESSAGE_BOX.put(100, OpticalFlow.class);
		MESSAGE_BOX.put(101, GlobalVisionPositionEstimate.class);
		MESSAGE_BOX.put(102, VisionPositionEstimate.class);
		MESSAGE_BOX.put(103, VisionSpeedEstimate.class);
		MESSAGE_BOX.put(104, ViconPositionEstimate.class);
		MESSAGE_BOX.put(105, HighresImu.class);
		MESSAGE_BOX.put(106, OpticalFlowRad.class);
		MESSAGE_BOX.put(107, HilSensor.class);
		MESSAGE_BOX.put(108, SimState.class);
		MESSAGE_BOX.put(109, RadioStatus.class);
		MESSAGE_BOX.put(110, FileTransferProtocol.class);
		MESSAGE_BOX.put(111, Timesync.class);
		MESSAGE_BOX.put(112, CameraTrigger.class);
		MESSAGE_BOX.put(113, HilGps.class);
		MESSAGE_BOX.put(114, HilOpticalFlow.class);
		MESSAGE_BOX.put(115, HilStateQuaternion.class);
		MESSAGE_BOX.put(116, ScaledImu2.class);
		MESSAGE_BOX.put(117, LogRequestList.class);
		MESSAGE_BOX.put(118, LogEntry.class);
		MESSAGE_BOX.put(119, LogRequestData.class);
		MESSAGE_BOX.put(120, LogData.class);
		MESSAGE_BOX.put(121, LogErase.class);
		MESSAGE_BOX.put(122, LogRequestEnd.class);
		MESSAGE_BOX.put(123, GpsInjectData.class);
		MESSAGE_BOX.put(124, Gps2Raw.class);
		MESSAGE_BOX.put(125, PowerStatus.class);
		MESSAGE_BOX.put(126, SerialControl.class);
		MESSAGE_BOX.put(127, GpsRtk.class);
		MESSAGE_BOX.put(128, Gps2Rtk.class);
		MESSAGE_BOX.put(129, ScaledImu3.class);
		MESSAGE_BOX.put(130, DataTransmissionHandshake.class);
		MESSAGE_BOX.put(131, EncapsulatedData.class);
		MESSAGE_BOX.put(132, DistanceSensor.class);
		MESSAGE_BOX.put(133, TerrainRequest.class);
		MESSAGE_BOX.put(134, TerrainData.class);
		MESSAGE_BOX.put(135, TerrainCheck.class);
		MESSAGE_BOX.put(136, TerrainReport.class);
		MESSAGE_BOX.put(137, ScaledPressure2.class);
		MESSAGE_BOX.put(138, AttPosMocap.class);
		MESSAGE_BOX.put(139, SetActuatorControlTarget.class);
		MESSAGE_BOX.put(140, ActuatorControlTarget.class);
		MESSAGE_BOX.put(141, Altitude.class);
		MESSAGE_BOX.put(142, ResourceRequest.class);
		MESSAGE_BOX.put(143, ScaledPressure3.class);
		MESSAGE_BOX.put(144, FollowTarget.class);
		MESSAGE_BOX.put(146, ControlSystemState.class);
		MESSAGE_BOX.put(147, BatteryStatus.class);
		MESSAGE_BOX.put(148, AutopilotVersion.class);
		MESSAGE_BOX.put(149, LandingTarget.class);
		MESSAGE_BOX.put(162, FenceStatus.class);
		MESSAGE_BOX.put(192, MagCalReport.class);
		MESSAGE_BOX.put(225, EfiStatus.class);
		MESSAGE_BOX.put(230, EstimatorStatus.class);
		MESSAGE_BOX.put(231, WindCov.class);
		MESSAGE_BOX.put(232, GpsInput.class);
		MESSAGE_BOX.put(233, GpsRtcmData.class);
		MESSAGE_BOX.put(234, HighLatency.class);
		MESSAGE_BOX.put(235, HighLatency2.class);
		MESSAGE_BOX.put(241, Vibration.class);
		MESSAGE_BOX.put(242, HomePosition.class);
		MESSAGE_BOX.put(243, SetHomePosition.class);
		MESSAGE_BOX.put(244, MessageInterval.class);
		MESSAGE_BOX.put(245, ExtendedSysState.class);
		MESSAGE_BOX.put(246, AdsbVehicle.class);
		MESSAGE_BOX.put(247, Collision.class);
		MESSAGE_BOX.put(248, V2Extension.class);
		MESSAGE_BOX.put(249, MemoryVect.class);
		MESSAGE_BOX.put(250, DebugVect.class);
		MESSAGE_BOX.put(251, NamedValueFloat.class);
		MESSAGE_BOX.put(252, NamedValueInt.class);
		MESSAGE_BOX.put(253, Statustext.class);
		MESSAGE_BOX.put(254, Debug.class);
		MESSAGE_BOX.put(256, SetupSigning.class);
		MESSAGE_BOX.put(257, ButtonChange.class);
		MESSAGE_BOX.put(258, PlayTune.class);
		MESSAGE_BOX.put(259, CameraInformation.class);
		MESSAGE_BOX.put(260, CameraSettings.class);
		MESSAGE_BOX.put(261, StorageInformation.class);
		MESSAGE_BOX.put(262, CameraCaptureStatus.class);
		MESSAGE_BOX.put(263, CameraImageCaptured.class);
		MESSAGE_BOX.put(264, FlightInformation.class);
		MESSAGE_BOX.put(265, MountOrientation.class);
		MESSAGE_BOX.put(266, LoggingData.class);
		MESSAGE_BOX.put(267, LoggingDataAcked.class);
		MESSAGE_BOX.put(268, LoggingAck.class);
		MESSAGE_BOX.put(269, VideoStreamInformation.class);
		MESSAGE_BOX.put(270, VideoStreamStatus.class);
		MESSAGE_BOX.put(271, CameraFovStatus.class);
		MESSAGE_BOX.put(275, CameraTrackingImageStatus.class);
		MESSAGE_BOX.put(276, CameraTrackingGeoStatus.class);
		MESSAGE_BOX.put(280, GimbalManagerInformation.class);
		MESSAGE_BOX.put(281, GimbalManagerStatus.class);
		MESSAGE_BOX.put(282, GimbalManagerSetAttitude.class);
		MESSAGE_BOX.put(283, GimbalDeviceInformation.class);
		MESSAGE_BOX.put(284, GimbalDeviceSetAttitude.class);
		MESSAGE_BOX.put(285, GimbalDeviceAttitudeStatus.class);
		MESSAGE_BOX.put(286, AutopilotStateForGimbalDevice.class);
		MESSAGE_BOX.put(287, GimbalManagerSetPitchyaw.class);
		MESSAGE_BOX.put(288, GimbalManagerSetManualControl.class);
		MESSAGE_BOX.put(290, EscInfo.class);
		MESSAGE_BOX.put(291, EscStatus.class);
		MESSAGE_BOX.put(299, WifiConfigAp.class);
		MESSAGE_BOX.put(301, AisVessel.class);
		MESSAGE_BOX.put(310, UavcanNodeStatus.class);
		MESSAGE_BOX.put(311, UavcanNodeInfo.class);
		MESSAGE_BOX.put(320, ParamExtRequestRead.class);
		MESSAGE_BOX.put(321, ParamExtRequestList.class);
		MESSAGE_BOX.put(322, ParamExtValue.class);
		MESSAGE_BOX.put(323, ParamExtSet.class);
		MESSAGE_BOX.put(324, ParamExtAck.class);
		MESSAGE_BOX.put(325, ParamExtValueTrimmed.class);
		MESSAGE_BOX.put(326, ParamExtSetTrimmed.class);
		MESSAGE_BOX.put(327, ParamExtAckTrimmed.class);
		MESSAGE_BOX.put(330, ObstacleDistance.class);
		MESSAGE_BOX.put(331, Odometry.class);
		MESSAGE_BOX.put(332, TrajectoryRepresentationWaypoints.class);
		MESSAGE_BOX.put(333, TrajectoryRepresentationBezier.class);
		MESSAGE_BOX.put(334, CellularStatus.class);
		MESSAGE_BOX.put(335, IsbdLinkStatus.class);
		MESSAGE_BOX.put(336, CellularConfig.class);
		MESSAGE_BOX.put(339, RawRpm.class);
		MESSAGE_BOX.put(340, UtmGlobalPosition.class);
		MESSAGE_BOX.put(350, DebugFloatArray.class);
		MESSAGE_BOX.put(360, OrbitExecutionStatus.class);
		MESSAGE_BOX.put(370, SmartBatteryInfo.class);
		MESSAGE_BOX.put(373, GeneratorStatus.class);
		MESSAGE_BOX.put(375, ActuatorOutputStatus.class);
		MESSAGE_BOX.put(380, TimeEstimateToTarget.class);
		MESSAGE_BOX.put(385, Tunnel.class);
		MESSAGE_BOX.put(390, OnboardComputerStatus.class);
		MESSAGE_BOX.put(395, ComponentInformation.class);
		MESSAGE_BOX.put(400, PlayTuneV2.class);
		MESSAGE_BOX.put(401, SupportedTunes.class);
		MESSAGE_BOX.put(9000, WheelDistance.class);
		MESSAGE_BOX.put(9005, WinchStatus.class);
		MESSAGE_BOX.put(12900, OpenDroneIdBasicId.class);
		MESSAGE_BOX.put(12901, OpenDroneIdLocation.class);
		MESSAGE_BOX.put(12902, OpenDroneIdAuthentication.class);
		MESSAGE_BOX.put(12903, OpenDroneIdSelfId.class);
		MESSAGE_BOX.put(12904, OpenDroneIdSystem.class);
		MESSAGE_BOX.put(12905, OpenDroneIdOperatorId.class);
		MESSAGE_BOX.put(12915, OpenDroneIdMessagePack.class);
		MESSAGE_BOX.put(0, Heartbeat.class);
		MESSAGE_BOX.put(300, ProtocolVersion.class);
	}

	private static void setMessageBoxVersion1(){
		MESSAGE_BOX.put(1, com.zhy.selfdev.mavlink.common.v1.messages.SysStatus.class);
		MESSAGE_BOX.put(2, com.zhy.selfdev.mavlink.common.v1.messages.SystemTime.class);
		MESSAGE_BOX.put(4, com.zhy.selfdev.mavlink.common.v1.messages.Ping.class);
		MESSAGE_BOX.put(5, com.zhy.selfdev.mavlink.common.v1.messages.ChangeOperatorControl.class);
		MESSAGE_BOX.put(6, com.zhy.selfdev.mavlink.common.v1.messages.ChangeOperatorControlAck.class);
		MESSAGE_BOX.put(7, com.zhy.selfdev.mavlink.common.v1.messages.AuthKey.class);
		MESSAGE_BOX.put(11, com.zhy.selfdev.mavlink.common.v1.messages.SetMode.class);
		MESSAGE_BOX.put(20, com.zhy.selfdev.mavlink.common.v1.messages.ParamRequestRead.class);
		MESSAGE_BOX.put(21, com.zhy.selfdev.mavlink.common.v1.messages.ParamRequestList.class);
		MESSAGE_BOX.put(22, com.zhy.selfdev.mavlink.common.v1.messages.ParamValue.class);
		MESSAGE_BOX.put(23, com.zhy.selfdev.mavlink.common.v1.messages.ParamSet.class);
		MESSAGE_BOX.put(24, com.zhy.selfdev.mavlink.common.v1.messages.GpsRawInt.class);
		MESSAGE_BOX.put(25, com.zhy.selfdev.mavlink.common.v1.messages.GpsStatus.class);
		MESSAGE_BOX.put(26, com.zhy.selfdev.mavlink.common.v1.messages.ScaledImu.class);
		MESSAGE_BOX.put(27, com.zhy.selfdev.mavlink.common.v1.messages.RawImu.class);
		MESSAGE_BOX.put(28, com.zhy.selfdev.mavlink.common.v1.messages.RawPressure.class);
		MESSAGE_BOX.put(29, com.zhy.selfdev.mavlink.common.v1.messages.ScaledPressure.class);
		MESSAGE_BOX.put(30, com.zhy.selfdev.mavlink.common.v1.messages.Attitude.class);
		MESSAGE_BOX.put(31, com.zhy.selfdev.mavlink.common.v1.messages.AttitudeQuaternion.class);
		MESSAGE_BOX.put(32, com.zhy.selfdev.mavlink.common.v1.messages.LocalPositionNed.class);
		MESSAGE_BOX.put(33, com.zhy.selfdev.mavlink.common.v1.messages.GlobalPositionInt.class);
		MESSAGE_BOX.put(34, com.zhy.selfdev.mavlink.common.v1.messages.RcChannelsScaled.class);
		MESSAGE_BOX.put(35, com.zhy.selfdev.mavlink.common.v1.messages.RcChannelsRaw.class);
		MESSAGE_BOX.put(36, com.zhy.selfdev.mavlink.common.v1.messages.ServoOutputRaw.class);
		MESSAGE_BOX.put(37, com.zhy.selfdev.mavlink.common.v1.messages.MissionRequestPartialList.class);
		MESSAGE_BOX.put(38, com.zhy.selfdev.mavlink.common.v1.messages.MissionWritePartialList.class);
		MESSAGE_BOX.put(39, com.zhy.selfdev.mavlink.common.v1.messages.MissionItem.class);
		MESSAGE_BOX.put(40, com.zhy.selfdev.mavlink.common.v1.messages.MissionRequest.class);
		MESSAGE_BOX.put(41, com.zhy.selfdev.mavlink.common.v1.messages.MissionSetCurrent.class);
		MESSAGE_BOX.put(42, com.zhy.selfdev.mavlink.common.v1.messages.MissionCurrent.class);
		MESSAGE_BOX.put(43, com.zhy.selfdev.mavlink.common.v1.messages.MissionRequestList.class);
		MESSAGE_BOX.put(44, com.zhy.selfdev.mavlink.common.v1.messages.MissionCount.class);
		MESSAGE_BOX.put(45, com.zhy.selfdev.mavlink.common.v1.messages.MissionClearAll.class);
		MESSAGE_BOX.put(46, com.zhy.selfdev.mavlink.common.v1.messages.MissionItemReached.class);
		MESSAGE_BOX.put(47, com.zhy.selfdev.mavlink.common.v1.messages.MissionAck.class);
		MESSAGE_BOX.put(48, com.zhy.selfdev.mavlink.common.v1.messages.SetGpsGlobalOrigin.class);
		MESSAGE_BOX.put(49, com.zhy.selfdev.mavlink.common.v1.messages.GpsGlobalOrigin.class);
		MESSAGE_BOX.put(54, com.zhy.selfdev.mavlink.common.v1.messages.SafetySetAllowedArea.class);
		MESSAGE_BOX.put(55, com.zhy.selfdev.mavlink.common.v1.messages.SafetyAllowedArea.class);
		MESSAGE_BOX.put(61, com.zhy.selfdev.mavlink.common.v1.messages.AttitudeQuaternionCov.class);
		MESSAGE_BOX.put(62, com.zhy.selfdev.mavlink.common.v1.messages.NavControllerOutput.class);
		MESSAGE_BOX.put(63, com.zhy.selfdev.mavlink.common.v1.messages.GlobalPositionIntCov.class);
		MESSAGE_BOX.put(64, com.zhy.selfdev.mavlink.common.v1.messages.LocalPositionNedCov.class);
		MESSAGE_BOX.put(65, com.zhy.selfdev.mavlink.common.v1.messages.RcChannels.class);
		MESSAGE_BOX.put(66, com.zhy.selfdev.mavlink.common.v1.messages.RequestDataStream.class);
		MESSAGE_BOX.put(67, com.zhy.selfdev.mavlink.common.v1.messages.DataStream.class);
		MESSAGE_BOX.put(69, com.zhy.selfdev.mavlink.common.v1.messages.ManualControl.class);
		MESSAGE_BOX.put(70, com.zhy.selfdev.mavlink.common.v1.messages.RcChannelsOverride.class);
		MESSAGE_BOX.put(73, com.zhy.selfdev.mavlink.common.v1.messages.MissionItemInt.class);
		MESSAGE_BOX.put(74, com.zhy.selfdev.mavlink.common.v1.messages.VfrHud.class);
		MESSAGE_BOX.put(75, com.zhy.selfdev.mavlink.common.v1.messages.CommandInt.class);
		MESSAGE_BOX.put(76, com.zhy.selfdev.mavlink.common.v1.messages.CommandLong.class);
		MESSAGE_BOX.put(77, com.zhy.selfdev.mavlink.common.v1.messages.CommandAck.class);
		MESSAGE_BOX.put(81, com.zhy.selfdev.mavlink.common.v1.messages.ManualSetpoint.class);
		MESSAGE_BOX.put(82, com.zhy.selfdev.mavlink.common.v1.messages.SetAttitudeTarget.class);
		MESSAGE_BOX.put(83, com.zhy.selfdev.mavlink.common.v1.messages.AttitudeTarget.class);
		MESSAGE_BOX.put(84, com.zhy.selfdev.mavlink.common.v1.messages.SetPositionTargetLocalNed.class);
		MESSAGE_BOX.put(85, com.zhy.selfdev.mavlink.common.v1.messages.PositionTargetLocalNed.class);
		MESSAGE_BOX.put(86, com.zhy.selfdev.mavlink.common.v1.messages.SetPositionTargetGlobalInt.class);
		MESSAGE_BOX.put(87, com.zhy.selfdev.mavlink.common.v1.messages.PositionTargetGlobalInt.class);
		MESSAGE_BOX.put(89, com.zhy.selfdev.mavlink.common.v1.messages.LocalPositionNedSystemGlobalOffset.class);
		MESSAGE_BOX.put(90, com.zhy.selfdev.mavlink.common.v1.messages.HilState.class);
		MESSAGE_BOX.put(91, com.zhy.selfdev.mavlink.common.v1.messages.HilControls.class);
		MESSAGE_BOX.put(92, com.zhy.selfdev.mavlink.common.v1.messages.HilRcInputsRaw.class);
		MESSAGE_BOX.put(100, com.zhy.selfdev.mavlink.common.v1.messages.OpticalFlow.class);
		MESSAGE_BOX.put(101, com.zhy.selfdev.mavlink.common.v1.messages.GlobalVisionPositionEstimate.class);
		MESSAGE_BOX.put(102, com.zhy.selfdev.mavlink.common.v1.messages.VisionPositionEstimate.class);
		MESSAGE_BOX.put(103, com.zhy.selfdev.mavlink.common.v1.messages.VisionSpeedEstimate.class);
		MESSAGE_BOX.put(104, com.zhy.selfdev.mavlink.common.v1.messages.ViconPositionEstimate.class);
		MESSAGE_BOX.put(105, com.zhy.selfdev.mavlink.common.v1.messages.HighresImu.class);
		MESSAGE_BOX.put(106, com.zhy.selfdev.mavlink.common.v1.messages.OpticalFlowRad.class);
		MESSAGE_BOX.put(107, com.zhy.selfdev.mavlink.common.v1.messages.HilSensor.class);
		MESSAGE_BOX.put(108, com.zhy.selfdev.mavlink.common.v1.messages.SimState.class);
		MESSAGE_BOX.put(109, com.zhy.selfdev.mavlink.common.v1.messages.RadioStatus.class);
		MESSAGE_BOX.put(110, com.zhy.selfdev.mavlink.common.v1.messages.FileTransferProtocol.class);
		MESSAGE_BOX.put(111, com.zhy.selfdev.mavlink.common.v1.messages.Timesync.class);
		MESSAGE_BOX.put(113, com.zhy.selfdev.mavlink.common.v1.messages.HilGps.class);
		MESSAGE_BOX.put(114, com.zhy.selfdev.mavlink.common.v1.messages.HilOpticalFlow.class);
		MESSAGE_BOX.put(115, com.zhy.selfdev.mavlink.common.v1.messages.HilStateQuaternion.class);
		MESSAGE_BOX.put(116, com.zhy.selfdev.mavlink.common.v1.messages.ScaledImu2.class);
		MESSAGE_BOX.put(117, com.zhy.selfdev.mavlink.common.v1.messages.LogRequestList.class);
		MESSAGE_BOX.put(118, com.zhy.selfdev.mavlink.common.v1.messages.LogEntry.class);
		MESSAGE_BOX.put(119, com.zhy.selfdev.mavlink.common.v1.messages.LogRequestData.class);
		MESSAGE_BOX.put(120, com.zhy.selfdev.mavlink.common.v1.messages.LogData.class);
		MESSAGE_BOX.put(121, com.zhy.selfdev.mavlink.common.v1.messages.LogErase.class);
		MESSAGE_BOX.put(122, com.zhy.selfdev.mavlink.common.v1.messages.LogRequestEnd.class);
		MESSAGE_BOX.put(123, com.zhy.selfdev.mavlink.common.v1.messages.GpsInjectData.class);
		MESSAGE_BOX.put(124, com.zhy.selfdev.mavlink.common.v1.messages.Gps2Raw.class);
		MESSAGE_BOX.put(125, com.zhy.selfdev.mavlink.common.v1.messages.PowerStatus.class);
		MESSAGE_BOX.put(126, com.zhy.selfdev.mavlink.common.v1.messages.SerialControl.class);
		MESSAGE_BOX.put(127, com.zhy.selfdev.mavlink.common.v1.messages.GpsRtk.class);
		MESSAGE_BOX.put(128, com.zhy.selfdev.mavlink.common.v1.messages.Gps2Rtk.class);
		MESSAGE_BOX.put(130, com.zhy.selfdev.mavlink.common.v1.messages.DataTransmissionHandshake.class);
		MESSAGE_BOX.put(131, com.zhy.selfdev.mavlink.common.v1.messages.EncapsulatedData.class);
		MESSAGE_BOX.put(132, com.zhy.selfdev.mavlink.common.v1.messages.DistanceSensor.class);
		MESSAGE_BOX.put(133, com.zhy.selfdev.mavlink.common.v1.messages.TerrainRequest.class);
		MESSAGE_BOX.put(134, com.zhy.selfdev.mavlink.common.v1.messages.TerrainData.class);
		MESSAGE_BOX.put(135, com.zhy.selfdev.mavlink.common.v1.messages.TerrainCheck.class);
		MESSAGE_BOX.put(136, com.zhy.selfdev.mavlink.common.v1.messages.TerrainReport.class);
		MESSAGE_BOX.put(147, com.zhy.selfdev.mavlink.common.v1.messages.BatteryStatus.class);
		MESSAGE_BOX.put(148, com.zhy.selfdev.mavlink.common.v1.messages.AutopilotVersion.class);
		MESSAGE_BOX.put(248, com.zhy.selfdev.mavlink.common.v1.messages.V2Extension.class);
		MESSAGE_BOX.put(249, com.zhy.selfdev.mavlink.common.v1.messages.MemoryVect.class);
		MESSAGE_BOX.put(250, com.zhy.selfdev.mavlink.common.v1.messages.DebugVect.class);
		MESSAGE_BOX.put(251, com.zhy.selfdev.mavlink.common.v1.messages.NamedValueFloat.class);
		MESSAGE_BOX.put(252, com.zhy.selfdev.mavlink.common.v1.messages.NamedValueInt.class);
		MESSAGE_BOX.put(253, com.zhy.selfdev.mavlink.common.v1.messages.Statustext.class);
		MESSAGE_BOX.put(254, com.zhy.selfdev.mavlink.common.v1.messages.Debug.class);
		MESSAGE_BOX.put(0, com.zhy.selfdev.mavlink.common.v1.messages.Heartbeat.class);
		MESSAGE_BOX.put(300, com.zhy.selfdev.mavlink.common.v1.messages.ProtocolVersion.class);
	}

	/**
	 * 根据枚举属性获取注解MavlinkEnumEntry的value
	 * @param enumColumn 枚举属性
	 * @return 结果
	 */
	public static Integer getMavlinkEnumEntryValue(Enum<?> enumColumn){
		Map<String, Field> fieldCache = Arrays.stream(enumColumn.getClass().getDeclaredFields()).
				filter(Field::isEnumConstant).
				collect(Collectors.toMap(Field::getName, Function.identity()));

		int ordinal = enumColumn.ordinal();
		Enum<?>[] enumConstants = enumColumn.getClass().getEnumConstants();
		for (Enum<?> item : enumConstants) {
			String keyName = item.name();
			Field field = fieldCache.get(keyName);
			//不包含原始，则停止解析
			if (!field.isAnnotationPresent(MavlinkEnumEntry.class)) {
				continue;
			}
			if(ordinal == item.ordinal()){
				MavlinkEnumEntry declaredAnnotation = field.getDeclaredAnnotation(MavlinkEnumEntry.class);
				return declaredAnnotation.value();
			}
		}
		return null;
	}

	/**
	 * 根据枚举属性class名称和注解中的value获取枚举常量
	 * @param className 枚举属性class名称
	 * @param value     注解中的value
	 * @return 结果：枚举常量
	 */
	public static Enum<?> getMavlinkEnumEntry(Class<? extends Enum<?>> className, Integer value) throws Exception {
		Map<String, Field> fieldCache = Arrays.stream(className.getDeclaredFields()).
				filter(Field::isEnumConstant).
				collect(Collectors.toMap(Field::getName, Function.identity()));

		Enum<?>[] enumConstants = className.getEnumConstants();
		for (Enum<?> item : enumConstants) {
			String keyName = item.name();
			Field field = fieldCache.get(keyName);
			//不包含原始，则停止解析
			if (!field.isAnnotationPresent(MavlinkEnumEntry.class)) {
				continue;
			}
			MavlinkEnumEntry declaredAnnotation = field.getDeclaredAnnotation(MavlinkEnumEntry.class);
			if(value == declaredAnnotation.value()){
				return item;
			}
		}
		throw new Exception("没有找到对应的MavlinkEnum常量");
	}

	public static void main(String[] args) throws Exception {
		Integer mavlinkEnumEntryValue = getMavlinkEnumEntryValue(com.zhy.selfdev.mavlink.common.v1.enums.FenceAction.FENCE_ACTION_REPORT);
		System.out.println(mavlinkEnumEntryValue);
		Enum<?> mavlinkEnumEntry = getMavlinkEnumEntry(com.zhy.selfdev.mavlink.zhy.enums.DeviceType.class, 3);
		System.out.println(mavlinkEnumEntry);
		Enum<?> mavlinkEnumEntry1 = getMavlinkEnumEntry(com.zhy.selfdev.mavlink.zhy.enums.DeviceType.class, 9992);
		System.out.println(mavlinkEnumEntry1);
	}

	private static void setCrcBox(){
		CRC_BOX.put(0,50);
		CRC_BOX.put(1,124);
		CRC_BOX.put(2,137);
		CRC_BOX.put(4,237);
		CRC_BOX.put(5,217);
		CRC_BOX.put(6,104);
		CRC_BOX.put(7,119);
		CRC_BOX.put(8,117);
		CRC_BOX.put(11,89);
		CRC_BOX.put(20,214);
		CRC_BOX.put(21,159);
		CRC_BOX.put(22,220);
		CRC_BOX.put(23,168);
		CRC_BOX.put(24,24);
		CRC_BOX.put(25,23);
		CRC_BOX.put(26,170);
		CRC_BOX.put(27,144);
		CRC_BOX.put(28,67);
		CRC_BOX.put(29,115);
		CRC_BOX.put(30,39);
		CRC_BOX.put(31,246);
		CRC_BOX.put(32,185);
		CRC_BOX.put(33,104);
		CRC_BOX.put(34,237);
		CRC_BOX.put(35,244);
		CRC_BOX.put(36,222);
		CRC_BOX.put(37,212);
		CRC_BOX.put(38,9);
		CRC_BOX.put(39,254);
		CRC_BOX.put(40,230);
		CRC_BOX.put(41,28);
		CRC_BOX.put(42,28);
		CRC_BOX.put(43,132);
		CRC_BOX.put(44,221);
		CRC_BOX.put(45,232);
		CRC_BOX.put(46,11);
		CRC_BOX.put(47,153);
		CRC_BOX.put(48,41);
		CRC_BOX.put(49,39);
		CRC_BOX.put(50,78);
		CRC_BOX.put(51,196);
		CRC_BOX.put(52,132);
		CRC_BOX.put(54,15);
		CRC_BOX.put(55,3);
		CRC_BOX.put(61,167);
		CRC_BOX.put(62,183);
		CRC_BOX.put(63,119);
		CRC_BOX.put(64,191);
		CRC_BOX.put(65,118);
		CRC_BOX.put(66,148);
		CRC_BOX.put(67,21);
		CRC_BOX.put(69,243);
		CRC_BOX.put(70,124);
		CRC_BOX.put(73,38);
		CRC_BOX.put(74,20);
		CRC_BOX.put(75,158);
		CRC_BOX.put(76,152);
		CRC_BOX.put(77,143);
		CRC_BOX.put(81,106);
		CRC_BOX.put(82,49);
		CRC_BOX.put(83,22);
		CRC_BOX.put(84,143);
		CRC_BOX.put(85,140);
		CRC_BOX.put(86,5);
		CRC_BOX.put(87,150);
		CRC_BOX.put(89,231);
		CRC_BOX.put(90,183);
		CRC_BOX.put(91,63);
		CRC_BOX.put(92,54);
		CRC_BOX.put(93,47);
		CRC_BOX.put(100,175);
		CRC_BOX.put(101,102);
		CRC_BOX.put(102,158);
		CRC_BOX.put(103,208);
		CRC_BOX.put(104,56);
		CRC_BOX.put(105,93);
		CRC_BOX.put(106,138);
		CRC_BOX.put(107,108);
		CRC_BOX.put(108,32);
		CRC_BOX.put(109,185);
		CRC_BOX.put(110,84);
		CRC_BOX.put(111,34);
		CRC_BOX.put(112,174);
		CRC_BOX.put(113,124);
		CRC_BOX.put(114,237);
		CRC_BOX.put(115,4);
		CRC_BOX.put(116,76);
		CRC_BOX.put(117,128);
		CRC_BOX.put(118,56);
		CRC_BOX.put(119,116);
		CRC_BOX.put(120,134);
		CRC_BOX.put(121,237);
		CRC_BOX.put(122,203);
		CRC_BOX.put(123,250);
		CRC_BOX.put(124,87);
		CRC_BOX.put(125,203);
		CRC_BOX.put(126,220);
		CRC_BOX.put(127,25);
		CRC_BOX.put(128,226);
		CRC_BOX.put(129,46);
		CRC_BOX.put(130,29);
		CRC_BOX.put(131,223);
		CRC_BOX.put(132,85);
		CRC_BOX.put(133,6);
		CRC_BOX.put(134,229);
		CRC_BOX.put(135,203);
		CRC_BOX.put(136,1);
		CRC_BOX.put(137,195);
		CRC_BOX.put(138,109);
		CRC_BOX.put(139,168);
		CRC_BOX.put(140,181);
		CRC_BOX.put(141,47);
		CRC_BOX.put(142,72);
		CRC_BOX.put(143,131);
		CRC_BOX.put(144,127);
		CRC_BOX.put(146,103);
		CRC_BOX.put(147,154);
		CRC_BOX.put(148,178);
		CRC_BOX.put(149,200);
		CRC_BOX.put(162,189);
		CRC_BOX.put(230,163);
		CRC_BOX.put(231,105);
		CRC_BOX.put(232,151);
		CRC_BOX.put(233,35);
		CRC_BOX.put(234,150);
		CRC_BOX.put(235,179);
		CRC_BOX.put(241,90);
		CRC_BOX.put(242,104);
		CRC_BOX.put(243,85);
		CRC_BOX.put(244,95);
		CRC_BOX.put(245,130);
		CRC_BOX.put(246,184);
		CRC_BOX.put(247,81);
		CRC_BOX.put(248,8);
		CRC_BOX.put(249,204);
		CRC_BOX.put(250,49);
		CRC_BOX.put(251,170);
		CRC_BOX.put(252,44);
		CRC_BOX.put(253,83);
		CRC_BOX.put(254,46);
		CRC_BOX.put(256,71);
		CRC_BOX.put(257,131);
		CRC_BOX.put(258,187);
		CRC_BOX.put(259,92);
		CRC_BOX.put(260,146);
		CRC_BOX.put(261,179);
		CRC_BOX.put(262,12);
		CRC_BOX.put(263,133);
		CRC_BOX.put(264,49);
		CRC_BOX.put(265,26);
		CRC_BOX.put(266,193);
		CRC_BOX.put(267,35);
		CRC_BOX.put(268,14);
		CRC_BOX.put(269,109);
		CRC_BOX.put(270,59);
		CRC_BOX.put(299,19);
		CRC_BOX.put(300,217);
		CRC_BOX.put(301,243);
		CRC_BOX.put(310,28);
		CRC_BOX.put(311,95);
		CRC_BOX.put(320,243);
		CRC_BOX.put(321,88);
		CRC_BOX.put(322,243);
		CRC_BOX.put(323,78);
		CRC_BOX.put(324,132);
		CRC_BOX.put(330,23);
		CRC_BOX.put(331,91);
		CRC_BOX.put(332,236);
		CRC_BOX.put(333,231);
		CRC_BOX.put(334,135);
		CRC_BOX.put(335,225);
		CRC_BOX.put(340,99);
		CRC_BOX.put(350,232);
		CRC_BOX.put(360,11);
		CRC_BOX.put(365,36);
		CRC_BOX.put(370,98);
		CRC_BOX.put(371,161);
		CRC_BOX.put(375,251);
		CRC_BOX.put(380,232);
		CRC_BOX.put(385,147);
		CRC_BOX.put(390,156);
		CRC_BOX.put(395,231);
		CRC_BOX.put(400,110);
		CRC_BOX.put(401,183);
		CRC_BOX.put(9000,113);
		CRC_BOX.put(12900,197);
		CRC_BOX.put(12901,16);
		CRC_BOX.put(12902,181);
		CRC_BOX.put(12903,149);
		CRC_BOX.put(12904,238);
		CRC_BOX.put(12905,56);
		CRC_BOX.put(12915,67);
	}
}
