package com.djcao.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javafx.util.Pair;

/**
 *
 * 使用心跳包维持socket的连接
 *
 * @author djcao
 * @workcode BG389966
 * @date 2019/12/17
 */
public class BIOServer {

    private static ConcurrentHashMap<String,Socket> acceptedSocket = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String,Socket> connectedSocket = new ConcurrentHashMap<>();

    private ScheduledThreadPoolExecutor executorService;

    private int port = 8624;
    public BIOServer() {
        this.executorService = new ScheduledThreadPoolExecutor(20, new ThreadFactory() {
            private AtomicLong atomicLong = new AtomicLong();
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                thread.setName("Check-Client-Thread-" + atomicLong.getAndIncrement());
                return thread;
            }
        });
    }

    public void start() {
        try {
            ServerSocket server = new ServerSocket(port);
            if (server.isBound()){
                executorService.scheduleAtFixedRate(() -> {
                    try {
                        sout(getEmmitEventSocket());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                },5,2, TimeUnit.SECONDS);

                executorService.scheduleAtFixedRate(() -> {
                    try {
                        System.out.println("开始一轮accept轮询,size:"+acceptedSocket.size());
                        Iterator<Socket> iterator = acceptedSocket.values().iterator();
                        while (iterator.hasNext()){
                            Socket socket = processConnect(iterator.next());
                            if (socket != null){
                                connectedSocket.put(getRemoteInstanceId((InetSocketAddress)socket.getRemoteSocketAddress()),socket);
                                iterator.remove();
                            }
                        }
                        System.out.println("结束一轮accept轮询,size:"+acceptedSocket.size());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },5,2, TimeUnit.SECONDS);
            }
            InetSocketAddress remoteSocketAddress;
            while (true){
                Socket client = server.accept();
                remoteSocketAddress = (InetSocketAddress) client.getRemoteSocketAddress();
                acceptedSocket.put(getRemoteInstanceId(remoteSocketAddress),client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Pair<Event,Socket>> getEmmitEventSocket() throws IOException {
        List<Pair<Event,Socket>> rlt = new ArrayList<>();
        Iterator<Socket> iterator = connectedSocket.values().iterator();
        while (iterator.hasNext()){
            Socket next = iterator.next();
            Pair<Event, Socket> event = findEvent(next);
            if (event != null){
                rlt.add(event);
            }
        }
        return rlt;
    }

    public void sout(List<Pair<Event,Socket>> eventSocket){
        System.out.println("开始一轮轮询,size:"+eventSocket.size());
        Iterator<Pair<Event, Socket>> iterator = eventSocket.iterator();
        while (iterator.hasNext()){
            Pair<Event, Socket> next = iterator.next();
            switch (next.getKey()){
                case CONNECTED:
                    throw new RuntimeException("not allow here process connect");
                case READABLE:
                    processReadable(next.getValue());
                    break;
                case UNCONNECTED:
                    processUnConnect(next.getValue());
                    break;
                case WRITEABLE:
                    throw new RuntimeException("not allow here process write");
                default:
                    break;
            }
            System.out.println(next.getKey().name());
        }
        System.out.println("结束一轮轮询,size:"+eventSocket.size());
    }

    public Socket processConnect(Socket socket){
        if (socket.isConnected()){
            InetSocketAddress socketAddress =
                (InetSocketAddress)socket.getRemoteSocketAddress();
            System.out.println(socketAddress.getHostString() + ":" + socketAddress.getPort()+
                "连接成功");
            return socket;
        }
        return null;
    }

    public void processReadable(Socket socket){
        InetSocketAddress socketAddress =
            (InetSocketAddress)socket.getRemoteSocketAddress();
        System.out.println("来自 "+socketAddress.getHostString() + ":" + socketAddress.getPort()+
            "的消息:");
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024*3/2];
            int length;
            StringBuilder stringBuilder = new StringBuilder();
            while (inputStream.available()>0){
                length = inputStream.read(buffer);
                stringBuilder.append(new String(buffer,0,length,StandardCharsets.UTF_8));
            }
            System.out.println(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processWriteable(Socket socket){
        InetSocketAddress socketAddress =
            (InetSocketAddress)socket.getRemoteSocketAddress();
        System.out.println(getRemoteInstanceId(socketAddress));
    }

    public void processUnConnect(Socket socket){
        System.out.println("开始断开连接");
        InetSocketAddress socketAddress =
            (InetSocketAddress)socket.getRemoteSocketAddress();
        connectedSocket.remove(getRemoteInstanceId(
            (InetSocketAddress) socket.getRemoteSocketAddress()));
        try {
            socket.shutdownInput();
            socket.shutdownOutput();
            if (socket.getInputStream()!= null){
                socket.getInputStream().close();
            }
            if (socket.getOutputStream() != null){
                socket.getOutputStream().close();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(socketAddress.getHostString() + ":" + socketAddress.getPort()+"断开连接成功");
    }

    public Pair<Event,Socket> findEvent(Socket socket) throws IOException {
        if (socket.isClosed()){
            return new Pair<>(Event.UNCONNECTED,socket);
        }else if (socket.getInputStream().available() > 0){
            return new Pair<>(Event.READABLE,socket);
        }else {
            //pass
        }
        return null;
    }

    private String getRemoteInstanceId(InetSocketAddress socketAddress){
        return socketAddress.getHostString() + ":" + socketAddress.getPort();
    }

    public static void main(String[] args) {
        BIOServer bioServer = new BIOServer();
        bioServer.start();
    }
}
