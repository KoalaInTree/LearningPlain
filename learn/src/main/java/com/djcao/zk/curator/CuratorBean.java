package com.djcao.zk.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.checkerframework.checker.units.qual.C;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-19
 */
public class CuratorBean {
    private static CuratorFramework curatorFramework;
    private static final String prefix = "/curatorFramework";

    static {
        curatorFramework = CuratorFrameworkFactory.builder().connectString("192.168.102.128:2181")
            .retryPolicy(new RetryOneTime(1000))
            .sessionTimeoutMs(30000).connectionTimeoutMs(30000).build();
        curatorFramework.start();
    }

    public boolean exist(String path){
        try {
            String s = new String(curatorFramework.getData().forPath(prefix));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean lock(String path){
        try {
            curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(prefix+"/"+path);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean unLock(String path){
        try {
            curatorFramework.delete().forPath(prefix+"/"+path);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CuratorBean curatorBean = new CuratorBean();
        boolean ps = curatorBean.lock("ps");
        if (ps){
            System.out.printf("ps");
            curatorBean.unLock("ps");
        }
    }
}
