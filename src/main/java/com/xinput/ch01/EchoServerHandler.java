package com.xinput.ch01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 实现服务端逻辑
 *
 * @author xinput
 * @since
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当服务器接收到消息后，channelRead方法会被调用，具体消息为msg，用户可以对该消息就行处理
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf bb = (ByteBuf) msg;
        bb.markReaderIndex();
        System.out.println("Server received: " + ByteBufUtil.hexDump(bb.readBytes(bb.readableBytes())));
        bb.resetReaderIndex();
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
