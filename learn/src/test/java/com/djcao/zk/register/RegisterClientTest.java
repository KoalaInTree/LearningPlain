package com.djcao.zk.register;

import java.io.IOException;

import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-20
 */
public class RegisterClientTest {

    @Test
    public void register() throws IOException {
        RegisterClient registerClient = new RegisterClient();
        registerClient.setAppName("8848");
        registerClient.register();
        System.out.println("register success");
    }

}
