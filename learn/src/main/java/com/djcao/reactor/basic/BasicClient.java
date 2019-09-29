package com.djcao.reactor.basic;

import java.io.IOException;
import java.net.Socket;

import com.djcao.reactor.SystemConfig;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/9/10
 */
public class BasicClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", SystemConfig.PORT);
        if (socket.isConnected()){
            byte[] send = "hello".getBytes();
            socket.getOutputStream().write(send);
            byte[] recv = new byte[1024];
            socket.getInputStream().read(recv);
            System.out.println(new String(recv));
        }
        System.out.println("bye bye~");
    }
}
