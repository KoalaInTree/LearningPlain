package com.djcao.zk.client;

import java.util.Date;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-19
 */
public class ZKLock {
    private static ZkClient zkClient;
    private static final String prefix = "/distribute";
    static {
        zkClient = new ZkClient("192.168.102.128:2181",30000,30000);
    }

    public boolean existPath(String path){
        return zkClient.exists(path);
    }

    public boolean lock(String path){
        if (!existPath(prefix)){
            zkClient.createPersistent(prefix);
        }
        try {
            zkClient.createEphemeral(prefix+path,new Date());
        }catch (Exception ex){
            System.out.printf("exception while lock :"+path);
            return false;
        }
        return true;
    }

    public void release(String path){
        try {
            zkClient.delete(path);
        }catch (Exception ex){
            System.out.printf("exception while release lock :"+path);
        }
    }

    public static void main(String[] args) {
        ZKLock lock = new ZKLock();
        boolean deduct = lock.lock("deduct");
        System.out.printf("lock status:"  + deduct);
        if (deduct){
            lock.release("/deduct");
            System.out.printf("release lock");
        }

    }


}
