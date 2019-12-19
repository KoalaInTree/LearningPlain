package com.djcao.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * SelectionKey.cancel  取消订阅当前事件
 * selectedKeys()  remove 表示处理完成
 * @author djcao
 * @date 2019/12/19 10:58
 */
public class NioClient {
    Selector selector;
    SocketChannel socketChannel;
    public void init() throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        selector = Selector.open();
        socketChannel.register(selector,SelectionKey.OP_CONNECT);
    }

    public void start() throws IOException {
        socketChannel.connect(new InetSocketAddress("127.0.0.1",NioServer.port));
        while (true){
            if (selector.select(5 * 1000) <= 0){
                continue;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                SocketChannel channel = (SocketChannel)next.channel();
                if (next.isConnectable()){
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    System.out.println("我嘞个亲娘,可算连上了");
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    allocate.put(("现在是:"+System.currentTimeMillis()).getBytes());
                    allocate.flip();
                    channel.write(allocate);
                    channel.register(selector,SelectionKey.OP_READ);
                }else if (next.isReadable()){
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((length = channel.read(byteBuffer)) > 0){
                        byteBuffer.flip();
                        stringBuilder.append(new String(byteBuffer.array(),0,length, StandardCharsets.UTF_8));
                        byteBuffer.compact();
                    }
                    System.out.println("收到来自服务端的消息:"+stringBuilder.toString());
                    try {
                        Thread.sleep(5 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    allocate.put(("现在是:"+System.currentTimeMillis()).getBytes());
                    allocate.flip();
                    channel.write(allocate);
                }else {
                    System.out.println("不知道是啥");
                }
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        NioClient nioClient = new NioClient();
        try {
            nioClient.init();
            nioClient.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
