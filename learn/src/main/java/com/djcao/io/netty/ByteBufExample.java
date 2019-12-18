package com.djcao.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/12/17
 */
public class ByteBufExample {

    public void allocateAndPut(){
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.heapBuffer();
        byteBuf.writeByte(128);
        System.out.println(byteBuf.readByte());
    }

    public void allocateAndChannel(){
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.heapBuffer();
        byteBuf.writeByte(128);
        System.out.println(byteBuf.readByte());
    }

    public void allocateAndTest(){
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.heapBuffer();
        byteBuf.writeByte(1);
        //slice 只读
        /*ByteBuf slice = byteBuf.slice();
        slice.writeByte(128);*/

        //retainedSlice for produces less garbage
        ByteBuf retainedSlice = byteBuf.retainedSlice();
        System.out.println(retainedSlice.readByte());
        System.out.println(byteBuf.readByte());

        //duplicate 读写
        ByteBuf duplicate = byteBuf.duplicate();
        duplicate.writeByte(100);
        System.out.println(duplicate.readByte());
        byteBuf.writeByte(111);
        //retained for produces less garbage
        ByteBuf retainedDuplicate = byteBuf.retainedDuplicate();
        System.out.println(retainedDuplicate.readByte());
    }

    public static void main(String[] args) {
        ByteBufExample example = new ByteBufExample();
        //example.allocateAndPut();
        example.allocateAndTest();
    }
}
