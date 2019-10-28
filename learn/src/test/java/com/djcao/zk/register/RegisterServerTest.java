package com.djcao.zk.register;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-20
 */
public class RegisterServerTest {

    @Test
    public void allAppName() throws Exception {
        prepare();
        RegisterServer registerServer = new RegisterServer();
        System.out.println(registerServer.allAppName().toString());;
    }

    @Test
    public void allAddress() throws Exception {
        prepare();
        RegisterServer registerServer = new RegisterServer();
        for (String appName : registerServer.allAppName()){
            List<String> strings = registerServer.allAddress(appName);
            System.out.println(strings.toString());
        }
    }

    @Test
    public void banAddress() throws Exception {
        prepare();
        RegisterServer registerServer = new RegisterServer();
        registerServer.banAddress("8848","192.168.0.102");
    }

    private void prepare(){
        RegisterClient registerClient = new RegisterClient();
        registerClient.setAppName("3412");
        registerClient.register();
        System.out.println("register success");

        RegisterClient registerClient2 = new RegisterClient();
        registerClient2.setAppName("8848");
        registerClient2.register();
        System.out.println("register success");
    }

    public static void main(String[] args) throws UnknownHostException {
        Inet4Address.getLocalHost().getHostAddress();
    }
}