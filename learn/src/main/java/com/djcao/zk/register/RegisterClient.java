package com.djcao.zk.register;

import java.net.Inet4Address;

import org.junit.Assert;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-20
 */
public class RegisterClient {
    private String appName;
    private CuratorClient curatorClient;
    private static final String director = "/";

    public RegisterClient() {
        curatorClient = new CuratorClient();
    }

    public void register(){
        Assert.assertNotNull("appName not null",appName);
        try {
            curatorClient.createPath(director + appName + director + Inet4Address.getLocalHost().getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
