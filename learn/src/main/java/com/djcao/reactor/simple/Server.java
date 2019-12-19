package com.djcao.reactor.simple;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import com.djcao.reactor.SystemConfig;

/**
 * @author djcao
 * @date 2019/12/19 11:00 
 */
public class Server {
    public static void testServer() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",SystemConfig.PORT));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0){
            Iterator it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey  selectionKey = (SelectionKey )it.next();
                if (selectionKey.isAcceptable()){
                    System.out.println("发现一个新连接");
                    ServerSocketChannel channel = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    System.out.println("新连接已注册到选择器");
                }

                if (selectionKey.isReadable()){
                    System.out.println("一个连接已经readable");
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    ByteBuffer inputByteBuffer = ByteBuffer.allocate(SystemConfig.INPUT_SIZE);
                    StringBuilder input = new StringBuilder();
                    int length;
                    if ((length = channel.read(inputByteBuffer)) != -1){
                        inputByteBuffer.flip();
                        input.append(new String(inputByteBuffer.array(),0,length));
                        inputByteBuffer.clear();
                    }
                    System.out.println(input.toString());
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("bye bye".getBytes());
                    byteBuffer.flip();
                    channel.write(byteBuffer);
                    channel.close();
                }

                if (selectionKey.isWritable()){
                    System.out.println("一个连接已经writeable");
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("bye bye".getBytes());
                    byteBuffer.flip();
                    channel.write(byteBuffer);
                    System.out.println("bye bye");
                }
                it.remove();
            }
        }
        serverSocketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        testServer();
    }
}
