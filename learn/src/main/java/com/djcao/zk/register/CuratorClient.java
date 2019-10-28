package com.djcao.zk.register;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-20
 */
public class CuratorClient {
    public static final String prefix = "/register";
    public static CuratorFramework curatorFramework;

    public CuratorClient() {
        curatorFramework = CuratorFrameworkFactory.builder().connectString("192.168.102.128:2181")
            .connectionTimeoutMs(30000).sessionTimeoutMs(30000).retryPolicy(new RetryOneTime(1000))
            .build();
        curatorFramework.start();;
    }

    public void createPath(String path) throws Exception {
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(prefix+path);
    }

    public void deletePath(String path) throws Exception {
        curatorFramework.delete().forPath(prefix+path);
    }

    public List<String> getChildren(String path) throws Exception {
        return curatorFramework.getChildren().forPath(prefix + path);
    }
}
