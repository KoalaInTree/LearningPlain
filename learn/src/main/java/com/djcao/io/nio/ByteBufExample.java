package com.djcao.io.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-12-16
 */
public class ByteBufExample {

    public void allocateAndPut(){
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.heapBuffer(1024);
        byteBuf.writeBoolean(true);



    }

    public static void main(String[] args) {
        ByteBufExample byteBufExample = new ByteBufExample();
        byteBufExample.allocateAndPut();
    }
}
