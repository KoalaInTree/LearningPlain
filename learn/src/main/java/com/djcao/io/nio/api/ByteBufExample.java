package com.djcao.io.nio.api;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

/**
 * @author djcao
 * @date 2019/12/19 10:57 
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
