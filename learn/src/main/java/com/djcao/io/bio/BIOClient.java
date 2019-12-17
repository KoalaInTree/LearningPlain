package com.djcao.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/12/17
 */
public class BIOClient {

    public void start(){
        Socket socket = null;
        try {
            socket = new Socket();
            socket.bind(new InetSocketAddress("127.0.0.1",1234));
            socket.connect(new InetSocketAddress("127.0.0.1",8624));
            while (true){
                if (!socket.isConnected()){
                    continue;
                }
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("8848".getBytes());
                outputStream.flush();
                Thread.sleep(10 * 1000);
                break;
            }
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BIOClient bioClient = new BIOClient();
        bioClient.start();
    }
}
