package com.djcao.io.nio.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @author djcao
 * @date 2019/12/19 10:57 
 */
public class ByteBufferExample {

    public void allocateAndPut(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put((byte)129);
        byteBuffer.flip();
        System.out.println(byteBuffer.get());
    }

    public void allocateAndRead() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        RandomAccessFile file = new RandomAccessFile(new File("C:\\Users\\CJ\\Desktop\\magic.txt"),"rw");
        RandomAccessFile file2 = new RandomAccessFile("C:\\Users\\CJ\\Desktop\\magic2.txt","rw");
        FileChannel channel = file.getChannel();
        try {
            channel.read(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        byteBuffer.flip();
        file2.getChannel().write(byteBuffer);
    }

    public void allocateAndSlice() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.putChar('1');
        byteBuffer.flip();
        ByteBuffer slice = byteBuffer.slice();
        System.out.println(slice.getChar());
        System.out.println(byteBuffer.getChar());
    }

    public void allocateAndCompact() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\CJ\\Desktop\\b.html"));
        File file = new File("C:\\Users\\CJ\\Desktop\\magic3.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile inputStream2 = new RandomAccessFile(file,"rw");
        FileChannel channel = inputStream.getChannel();
        FileChannel channel2 = inputStream2.getChannel();
        while (channel.read(byteBuffer) > 0 || byteBuffer.position() > 0){
            byteBuffer.flip();
            channel2.write(byteBuffer);
            byteBuffer.compact();
        }
    }

    public static void main(String[] args) throws Exception {
        ByteBufferExample example = new ByteBufferExample();
        example.allocateAndPut();
        example.allocateAndRead();
        example.allocateAndSlice();
        example.allocateAndCompact();
    }
}
