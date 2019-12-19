package com.djcao.io.netty.framedecode.lengthfieldbase;

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
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author djcao
 * @date 2019/12/19 16:12
 */
public class LengthFieldBaseClient {

    public void run() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup())
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,
                        0,4))
                        .addLast(new EchoHandler());
                }
            });
        ChannelFuture connect = bootstrap
            .connect(new InetSocketAddress("127.0.0.1", LengthFieldBaseServer.port)).sync();
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(2048);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i < 200000;i++){
            stringBuilder.append("我我我我我我我我我我"+i);
        }
        byte[] bytes =stringBuilder.toString().getBytes();
        System.out.println(bytes.length);
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        connect.channel().write(byteBuf);
        connect.channel().flush();

        connect.channel().closeFuture().sync();
    }

    public static void main(String[] args) {
        LengthFieldBaseClient lengthFieldBaseClient = new LengthFieldBaseClient();
        try {
            lengthFieldBaseClient.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
