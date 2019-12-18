package com.djcao.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * 使用心跳包维持socket的连接
 *
 * @author djcao
 * @workcode BG389966
 * @date 2019/12/17
 */
public class BIOClient {

    public void start(){
        Socket socket = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1",8624));
            while (true){
                if (!socket.isConnected()){
                    continue;
                }
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("#########################".getBytes());
                outputStream.flush();
                Thread.sleep(2 * 1000);
                socket.shutdownOutput();
                socket.shutdownInput();
                outputStream.close();
                socket.close();
                Thread.sleep(8 * 1000);
                break;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BIOClient bioClient = new BIOClient();
        bioClient.start();
    }
}
