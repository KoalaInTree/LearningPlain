package com.djcao.reactor;

import java.nio.channels.SocketChannel;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/9/29
 */
public interface Handler {

    boolean onConnect(SocketChannel channel);

    boolean onReadable(SocketChannel channel,String input);

    boolean onWriteable(SocketChannel channel);
}
