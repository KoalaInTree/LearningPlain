package com.djcao.reactor;

import java.nio.channels.SocketChannel;

/**
 * @author djcao
 * @date 2019/12/19 11:00 
 */
public interface Handler {

    boolean onConnect(SocketChannel channel);

    boolean onReadable(SocketChannel channel,String input);

    boolean onWriteable(SocketChannel channel);
}
