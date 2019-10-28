package com.djcao.zk.register;

import java.sql.Array;
import java.util.List;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-20
 */
public class RegisterServer {

    private CuratorClient curatorClient;
    private static final String director = "/";

    public RegisterServer() {
        curatorClient = new CuratorClient();
    }

    public List<String> allAppName() throws Exception {
        return curatorClient.getChildren("");
    }

    public List<String> allAddress(String appName) throws Exception {
        return curatorClient.getChildren(director + appName);
    }

    public void banAddress(String appName,String address) throws Exception {
        curatorClient.deletePath(director + appName + director + address);
    }

    public static void main(String[] args) {
        RegisterServer registerServer = new RegisterServer();
        System.out.println(registerServer.getClass().isInstance(new RegisterServer()));
        RegisterServer registerServer1 = new RegisterServer();
        System.out.println(registerServer instanceof RegisterServer);
        System.out.println(registerServer instanceof Object);
        int[] ids = new int[10];
        System.out.println(ids instanceof int[]);
    }
}
