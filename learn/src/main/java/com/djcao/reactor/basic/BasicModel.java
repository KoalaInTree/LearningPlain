package com.djcao.reactor.basic;

import static com.djcao.reactor.SystemConfig.PORT;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.djcao.reactor.SystemConfig;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/9/10
 */
public class BasicModel implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(PORT);
            while (!Thread.interrupted()){
                new Thread(new Handler(ss.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class Handler implements Runnable{
        final Socket socket;
        Handler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                byte[] input = new byte[SystemConfig.INPUT_SIZE];
                socket.getInputStream().read(input);
                socket.getOutputStream().write(process(input));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private byte[] process(byte[] input){
            byte[] output = "下面是你的输入信息:".getBytes();
            byte[] result = new byte[input.length+output.length];
            System.arraycopy(output,0,result,0,output.length);
            System.arraycopy(input,0,result,output.length,input.length);
            return result;
        }
    }

    public static void main(String[] args) {
        BasicModel basicModel = new BasicModel();
        basicModel.run();
    }
}
