package com.djcao.io.netty.framedecode.delimiterbase;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import com.djcao.io.netty.EchoHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * @author djcao
 * @date 2019/12/19 16:12
 */
public class DelimiterBaseClient {

    public void run() throws InterruptedException {
        ByteBuf delimiter = ByteBufAllocator.DEFAULT.buffer(0);
        delimiter.writeCharSequence("#!#", StandardCharsets.UTF_8);
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup())
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter))
                        .addLast(new EchoHandler());
                }
            });
        ChannelFuture connect = bootstrap
            .connect(new InetSocketAddress("127.0.0.1", DelimiterBaseServer.port)).sync();
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(2048);
        byteBuf.writeBytes("first#!#second#!#3#!#".getBytes());
        connect.channel().write(byteBuf);
        connect.channel().flush();
        connect.channel().closeFuture().sync();
    }

    public static void main(String[] args) {
        DelimiterBaseClient delimiterBaseClient = new DelimiterBaseClient();
        try {
            delimiterBaseClient.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
