package com.yan.netty.demo.client.channel;

import com.yan.netty.demo.client.handler.ClientChannelInHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 11:02
 * DESC:
 */
public class InitClientChannel extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new ClientChannelInHandler());
    }
}
