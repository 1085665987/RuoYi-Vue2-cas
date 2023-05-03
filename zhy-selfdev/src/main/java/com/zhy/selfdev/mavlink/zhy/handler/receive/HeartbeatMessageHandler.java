package com.zhy.selfdev.mavlink.zhy.handler.receive;

import com.zhy.selfdev.mavlink.common.Message;
import com.zhy.selfdev.mavlink.protocol.MavlinkConfig;
import com.zhy.selfdev.mavlink.protocol.MessageBuilder;
import com.zhy.selfdev.mavlink.protocol.Packet;
import com.zhy.selfdev.mavlink.zhy.messages.ZhyOrderCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class HeartbeatMessageHandler extends ReceivedMessageHandler{

    /**
     * 消费消息
     *
     * @param uid
     * @param message
     */
    @Override
    public void consumeMessage(String uid, byte[] message) {
        Packet<Message> messagePacket = Packet.readV1Packet(message);
//        byte[] bytes = messagePacket.encodePacket(messagePacket.getMessageId());
        //int sequence, int systemId, int componentId, int messageId, int crcExtra, byte[] payload) {
        byte[] bytes = Packet.createMavlink1Packet(
                messagePacket.getSequence(),
                messagePacket.getSystemId(),
                messagePacket.getComponentId(),
                messagePacket.getMessageId(),
                MavlinkConfig.getCrcBox().get(messagePacket.getMessageId()),
                messagePacket.getPayload()
        ).getRawBytes();
        System.out.println(Arrays.toString(bytes));
    }
}