package com.djcao.io.netty;

import java.util.concurrent.atomic.AtomicBoolean;

import io.netty.bootstrap.Bootstrap;

/**
 * @author djcao
 * @date 2019/12/19 11:08
 */
public class NettyServer {


    private AtomicBoolean atomicBoolean = new AtomicBoolean(Boolean.FALSE);
    private Bootstrap bootstrap;

    public void init(){
        if (!atomicBoolean.compareAndSet(Boolean.FALSE,Boolean.TRUE)){
            return;
        }
        bootstrap = new Bootstrap();
    }

    public void start(){

    }
}
