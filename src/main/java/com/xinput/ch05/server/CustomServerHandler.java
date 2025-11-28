package com.xinput.ch05.server;

import com.xinput.ch05.CustomMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class CustomServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("CustomServerHandler channelRead0 msg: " + msg);
        if (msg instanceof CustomMsg) {
            CustomMsg customMsg = (CustomMsg) msg;
            System.out.println("Client->Server:" + ctx.channel().remoteAddress() + " send " + customMsg.getBody());
        }
    }
}
