package com.djcao.zk.register;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-20
 */
public class CuratorClientTest {

    @Test
    public void createPath() throws Exception {
        CuratorClient curatorClient = new CuratorClient();
        curatorClient.createPath("/8848");

    }

    @Test
    public void deletePath() throws Exception {
        CuratorClient curatorClient = new CuratorClient();
        curatorClient.createPath("/8848");
        curatorClient.deletePath("/8848");
    }
}
