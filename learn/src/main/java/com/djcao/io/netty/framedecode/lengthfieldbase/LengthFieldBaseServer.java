package com.djcao.io.netty.framedecode.lengthfieldbase;

import java.nio.charset.StandardCharsets;

import com.djcao.io.netty.EchoHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author djcao
 * @date 2019/12/19 16:09
 */
public class LengthFieldBaseServer {

    public static int port = 8634;
    public void run() throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap =  new ServerBootstrap();
        serverBootstrap.group(boss,worker)
            .channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline()
                        .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4))
                        .addLast(new EchoHandler());
                }
            });
        ChannelFuture sync = serverBootstrap.bind(port).sync();
        sync.channel().closeFuture().sync();
    }

    public static void main(String[] args) {
        LengthFieldBaseServer lengthFieldBaseServer = new LengthFieldBaseServer();
        try {
            lengthFieldBaseServer.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
