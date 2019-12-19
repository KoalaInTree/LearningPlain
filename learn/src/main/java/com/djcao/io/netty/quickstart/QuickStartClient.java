package com.djcao.io.netty.quickstart;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author djcao
 * @date 2019/12/19 12:23
 */
public class QuickStartClient {

    public void run() throws InterruptedException {
        EventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker)
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new DiscardServerHandler());
                }
            })
            .option(ChannelOption.SO_BACKLOG,128);
        ChannelFuture sync = bootstrap
            .connect(new InetSocketAddress("127.0.0.1", DiscardServer.port)).sync();
        System.out.printf("123");
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeBytes("8848".getBytes());
        sync.channel().write(byteBuf);
        sync.channel().flush();
        sync.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        QuickStartClient quickStartClient = new QuickStartClient();
        quickStartClient.run();
    }
}
