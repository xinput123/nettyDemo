package com.xinput.ch01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 第一个示例
 * 引导服务端
 *
 * @author xinput
 * @since
 */
public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        // 1、创建NioEventLoopGroup实例来处理事件，如接受连接，读写数据等
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 2、创建ServerBootstrap实例
            ServerBootstrap worker = new ServerBootstrap();
            worker.group(group)
                    .channel(NioServerSocketChannel.class)
                    // 3、指定服务端绑定的端口
                    .localAddress(new InetSocketAddress(port))
                    // 4、设置childHandler来处理每一次连接。
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            // 5、使用ServerBootstrap的bind方法进行绑定并同步直至其完成绑定。
            ChannelFuture f = worker.bind().sync();
            System.out.println("Server start listen at " + port);
            // 等待服务器socket关闭
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new EchoServer(port).start();
    }
}
