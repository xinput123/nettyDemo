package com.xinput.ch02.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 客户端的第二个自定义的inbound处理器
 */
public class BaseClient2Handler extends ChannelInboundHandlerAdapter {

    /**
     * 如果一个channelPipeline中有多个channelHandler时，且这些channelHandler中有同样的方法时，
     * 例如这里的channelActive方法，只会调用处在第一个的channelHandler中的channelActive方法，
     * 如果你想要调用后续的channelHandler的同名的方法就需要调用以“fire”为开头的方法了，这样做很灵活
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("BaseClient2Handler Active");
    }
}
