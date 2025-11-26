package com.xinput.ch01.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 服务端处理器
 * 继承 ChannelInboundHandlerAdapter，我们不需要使每一个inboundChannel继承于ChannelInboundHandler，
 * 这样会需要我们实现ChannelInboundHandler中的所有接口，在一般的channel中我们没有必要这样做，这样只会
 * 增加我们的额外的工作量，我们只需要继承ChannelInboundHandlerAdapter，继承它的适配就可以了。我们需要
 * 实现几个特别重要的方法，例如读取的方法channelRead和异常处理的方法exceptionCaught
 */
public class HelloWorldServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取客户端发送的消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead..");
        System.out.println(ctx.channel().remoteAddress() + "->Server :" + msg.toString());
        ctx.write("server write: " + msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
