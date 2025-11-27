package com.xinput.ch04.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class BaseClientHandler extends ChannelInboundHandlerAdapter {

    private byte[] req;

    private int counter;

    public BaseClientHandler() {
        // 我们在我们巨长的req中末尾加了System.getProperty("line.separator")，这样相当于给req打了一个标记
//        req = ("In this chapter you general, we recommend Java Concurrency in Practice by Brian Goetz. His book w"
//                + "ill give We’ve reached an exciting point—in the next chapter we’ll discuss bootstrapping, the process "
//                + "of configuring and connecting all of Netty’s components to bring your learned about threading models in ge"
//                + "neral and Netty’s threading model in particular, whose performance and consistency advantages we discuss"
//                + "ed in detail In this chapter you general, we recommend Java Concurrency in Practice by Brian Goetz. Hi"
//                + "s book will give We’ve reached an exciting point—in the next chapter we’ll discuss bootstrapping, the"
//                + " process of configuring and connecting all of Netty’s components to bring your learned about threading "
//                + "models in general and Netty’s threading model in particular, whose performance and consistency advantag"
//                + "es we discussed in detailIn this chapter you general, we recommend Java Concurrency in Practice by Bri"
//                + "an Goetz. His book will give We’ve reached an exciting point—in the next chapter;the counter is: 1 2222"
//                + "sdsa ddasd asdsadas dsadasdas" + System.getProperty("line.separator")).getBytes();

//        req = ("BazingaLyncc is learner").getBytes();

        // 加入固定字符 $$__
        // 服务端使用固定字符解码器
        // ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("$$__".getBytes())));
        // 客户端发送了2次req字节，每个req中有10个“$$__”，这样就是第11次切割的时候其实发送了粘包，第一个req中末尾部分和第二次的头部粘在了一起，
        // 作为第11部分的内容， 而最后一部分的内容因为没有"$$__"切割，所以没有打印在控制台上~
        req = ("In this chapter you general, we recommend Java Concurrency in Practice by Brian Goetz. $$__ His book w"
                + "ill give We’ve reached an exciting point—in the next chapter we’ll $$__ discuss bootstrapping, the process "
                + "of configuring and connecting all of Netty’s components to bring $$__ your learned about threading models in ge"
                + "neral and Netty’s threading model in particular, whose performance $$__ and consistency advantages we discuss"
                + "ed in detail In this chapter you general, we recommend Java  $$__Concurrency in Practice by Brian Goetz. Hi"
                + "s book will give We’ve reached an exciting point—in the next $$__ chapter we’ll discuss bootstrapping, the"
                + " process of configuring and connecting all of Netty’s components $$__ to bring your learned about threading "
                + "models in general and Netty’s threading model in particular, $$__ whose performance and consistency advantag"
                + "es we discussed in detailIn this chapter you general, $$__ we recommend Java Concurrency in Practice by Bri"
                + "an Goetz. His book will give We’ve reached an exciting $$__ point—in the next chapter;the counter is: 1 2222"
                + "sdsa ddasd asdsadas dsadasdas" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ByteBuf message = null;
//        message = Unpooled.buffer(req.length);
//        message.writeBytes(req);
//        ctx.writeAndFlush(message);
//
//        message = Unpooled.buffer(req.length);
//        message.writeBytes(req);
//        ctx.writeAndFlush(message);

//        ByteBuf message = null;
//        for (int i = 0; i < 100; i++) {
//            message = Unpooled.buffer(req.length);
//            message.writeBytes(req);
//            ctx.writeAndFlush(message);
//        }

        ByteBuf message = null;
        message = Unpooled.buffer(req.length);
        message.writeBytes(req);
        ctx.writeAndFlush(message);

        message = Unpooled.buffer(req.length);
        message.writeBytes(req);
        ctx.writeAndFlush(message);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String buf = (String) msg;
        System.out.println("Now is : " + buf + " ; the counter is : " + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
