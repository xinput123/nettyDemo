package com.xinput.ch02.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 客户端的第一个自定义的inbound处理器
 */
public class BaseClient1Handler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("BaseClient1Handler channelActive");
        // 如果想让后续的channelHandler也收到channelActive事件，需要调用fireChannelActive方法
//        ctx.fireChannelActive();

        // 这么做的好处是：
        // 1）每一个handler只需要关注自己要处理的方法，如果你不关注channelActive方法时，
        //   你自定义的channelhandler就不需要重写channelActive方法
        // 2）异常处理，如果 exceptionCaught方法每个handler都重写了，只需有一个类捕捉到
        //   然后做处理就可以了，不需要每个handler都处理一遍
        // 3）灵活性
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("BaseClient1Handler channelInactive");
    }
}
