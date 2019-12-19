package com.djcao.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  SelectionKey.cancel  取消订阅当前事件
 *  selectedKeys()  remove 表示处理完成
 *
 * @author djcao
 * @date 2019/12/19 10:58
 */
public class NioServer {

    public final static int port = 8848;
    Selector selector;
    private final ConcurrentHashMap<String,SocketChannel> connectedSocket = new ConcurrentHashMap<>(64);

    public void init() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",port));
        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void start() throws IOException {

        while (true){
            if (selector.select(5*1000) <= 0){
                continue;
            }
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()){
                SelectionKey next = keys.next();
                if (next.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel)next.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector,SelectionKey.OP_CONNECT|SelectionKey.OP_READ);
                }else if (next.isConnectable()){
                    SocketChannel channel = (SocketChannel)next.channel();
                    String socketChannelKey = getSocketChannelKey(channel);
                    connectedSocket.put(socketChannelKey,channel);
                    System.out.println(socketChannelKey +" 建立连接");
                }else if (next.isReadable()){
                    SocketChannel channel = (SocketChannel)next.channel();
                    String socketChannelKey = getSocketChannelKey(channel);
                    System.out.println(socketChannelKey+" is readable");
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((length = channel.read(byteBuffer)) > 0){
                        byteBuffer.flip();
                        stringBuilder.append(new String(byteBuffer.array(),0,length, StandardCharsets.UTF_8));
                        byteBuffer.compact();
                    }
                    System.out.println(socketChannelKey+" say:"+stringBuilder.toString());
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
                    System.out.println("未处理的操作:"+next.interestOps());
                }
                keys.remove();
            }
        }
    }

    private String getSocketChannelKey(SocketChannel socketChannel) throws IOException {
        InetSocketAddress remoteAddress = (InetSocketAddress)socketChannel.getRemoteAddress();
        if (remoteAddress == null){
            throw new RuntimeException("socket not connected");
        }
        return remoteAddress.getHostString()+":"+remoteAddress.getPort();
    }
    public static void main(String[] args) {
        NioServer nioServer = new NioServer();
        try {
            nioServer.init();
            nioServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
