package com.djcao.io.netty.framedecode.fixedlengthbase;

import java.net.InetSocketAddress;

import com.djcao.io.netty.EchoHandler;
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
import io.netty.handler.codec.FixedLengthFrameDecoder;

/**
 * @author djcao
 * @date 2019/12/19 13:21
 */
public class FixedLengthClient {

    public void run(){
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new FixedLengthFrameDecoder(25))
                            .addLast(new EchoHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG,128);
            ChannelFuture sync = bootstrap
                .connect(new InetSocketAddress("127.0.0.1", FixedLengthServer.port)).sync();

            ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(8);
            byteBuf.writeBytes("1111222288".getBytes());
            sync.channel().write(byteBuf);
            sync.channel().flush();
            ByteBuf byteBuf2 = ByteBufAllocator.DEFAULT.buffer(8);
            byteBuf2.writeBytes("1111222288".getBytes());
            sync.channel().write(byteBuf2);
            sync.channel().flush();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        FixedLengthClient client = new FixedLengthClient();
        client.run();
        //System.out.println("11112222".getBytes().length);
    }
}
