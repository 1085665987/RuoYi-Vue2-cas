package com.zhy.selfdev.mavlink.test;

import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.protocol.MessageBuilder;
import com.zhy.selfdev.mavlink.protocol.Packet;
import com.zhy.selfdev.mavlink.protocol.util.ByteModel;

public class Test {
    public static void main(String[] args) {
//        CommandAck commandAck = new CommandAck();
//        commandAck.setCommand(MavCmd.MAV_CMD_NAV_ROI);
        testUnpack();
    }

    /**
     * Heartbeat 心跳包解析
     */
    public static void testUnpack(){
        // #0 心跳包解析
        byte [] message = new byte[]{
                // 第一个数FE：mavlink数据包的起始位（mavlink1.0是以FE开头）
                (byte) 0xFE,
                // 第二个数09：表明数据包的有效载荷长度为9个即00 00 00 00 0D 03 51 03 03
                0x09,
                // 第三个数36：发送该心跳包是从开机开始算的第几个数据包，中间可能掺杂了其他的数据包，用于校验是否丢包
                0x36,
                // 第四个数01：sysid（system ID）发送系统的ID
                0x01,
                // 第五个数01：compid（componene ID）发送单元ID
                0x01,
                // 第六个数00：代表本消息的有效载荷的编号，即心跳包的编号是#0
                0x00,
                // 第七个数（uint32_t即4个16进制数）00 00 00 00：即custom_mode（用户模式），即用于自动驾驶仪的特别的一个标志位的模式设置，
                // APM中包括17模式，在使用APM飞控时，根据自己的目的要在使用前，先给APM发送改变模式的数据包，将APM变化模式，
                // 一般custom_mode和base_mode是一起的。00 00 00 00表示0是STABILIZE（自稳模式）
                0x00,
                0x00,
                0x00,
                0x00,
                // 第八个数0D：即type（类型），0D表示 MAV_TYPE_HEXAROTOR（六轴）
                0x0D,
                // 第九个数03：即autopilot（微型飞行器即飞控板类型），03表示MAV_AUTOPILOT_ARDUPILOTMEGA（ArduPilotMega / ArduCopter即APM飞控）
                0x03,
                // 第十个数51：即base_mode（基本模式）
                0x51,
                // 第十一个数03：即 system_status（系统状态标志）如下图，03表示系统已接地并处于待机状态。任何时间都可以发射。
                0x03,
                // 第十二个数03：即 mavlink_version（mavlink版，不可写的用户，获取补充协议因为神奇的数据类型），默认就是3，这是开发者写好的。
                0x03,
                // 第十三和十四个数F4 11：这是校验位，调用系统函数后，会加到消息包的最后。
                (byte) 0xF4,
                0x11
        };
        Message message1 = MessageBuilder.readAnyMessage(message);
        Packet<Message> messagePacket = Packet.readV1Packet(message);
        System.out.println(message1);
        System.out.println(message1.hexStringPayload());
        System.out.println(messagePacket);
        System.out.println(ByteModel.bytes2HexString(messagePacket.getPayload()));
        System.out.println(MessageBuilder.readAnyMessage(messagePacket.getPayload()));
    }
}
