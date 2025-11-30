/**
 * Netty心跳之IdleStateHandler
 * Netty4 提供了一个类，名为IdleStateHandler，这个类可以对三种类型的心跳检测
 * <p>
 * public IdleStateHandler(
 * long readerIdleTime, long writerIdleTime, long allIdleTime,
 * TimeUnit unit) {
 * this(false, readerIdleTime, writerIdleTime, allIdleTime, unit);
 * }
 * <p>
 * 前三个的参数解释如下：
 * 1）readerIdleTime：为读超时时间（即测试端一定时间内未接受到被测试端消息）
 * 2）writerIdleTime：为写超时时间（即测试端一定时间内向被测试端发送消息）
 * 3）allIdleTime：所有类型的超时时间
 * <p>
 * 初步地看下IdleStateHandler源码，先看下IdleStateHandler中的channelRead方法：
 * public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
 * if (readerIdleTimeNanos > 0 || allIdleTimeNanos > 0) {
 * reading = true;
 * firstReaderIdleEvent = firstAllIdleEvent = true;
 * }
 * ctx.fireChannelRead(msg); // 表示该方法只是进行了透传，不做任何业务逻辑处理，让channelPipe中的下一个handler处理channelRead方法
 * }
 */
package com.xinput.ch07;