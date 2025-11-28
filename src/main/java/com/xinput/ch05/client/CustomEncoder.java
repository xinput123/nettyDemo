package com.xinput.ch05.client;

import com.xinput.ch05.CustomMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class CustomEncoder extends MessageToByteEncoder<CustomMsg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, CustomMsg msg, ByteBuf out) throws Exception {
        if (null == msg) {
            throw new Exception("msg is null");
        }

        System.out.println("CustomEncoder encode customMsg: " + msg);
        String body = msg.getBody();
        byte[] bodyBytes = body.getBytes(StandardCharsets.UTF_8);
        out.writeByte(msg.getType());
        out.writeByte(msg.getFlag());
        out.writeInt(bodyBytes.length);
        out.writeBytes(bodyBytes);
    }
}
