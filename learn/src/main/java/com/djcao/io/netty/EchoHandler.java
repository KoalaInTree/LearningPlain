package com.djcao.io.netty;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author djcao
 * @date 2019/12/19 15:44
 */
public class EchoHandler extends ChannelInboundHandlerAdapter {

    private AtomicInteger atomicInteger = new AtomicInteger();
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof ByteBuf){
            ByteBuf byteBuf = (ByteBuf)msg;
            byte[] cache;
            int length = byteBuf.readableBytes();
            int offset;
            if (byteBuf.hasArray()){
                cache = byteBuf.array();
                offset = byteBuf.arrayOffset();
            }else {
                cache = new byte[byteBuf.readableBytes()];
                byteBuf.getBytes(byteBuf.readerIndex(),cache);
                offset = 0;
            }
            System.out.println(new String(cache,offset,length,StandardCharsets.UTF_8));
            System.out.println("##############################################完成"+atomicInteger.getAndIncrement());
        }else {
            System.out.println(msg.toString());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
