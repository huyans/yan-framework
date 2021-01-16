package com.yan.netty.demo.server.channel;

import com.yan.netty.demo.server.handler.ServerChannelInHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 10:40
 * DESC:
 */
@Slf4j
public class InitServerChannel extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        log.info("InitServerChannel.initChannel...");
        socketChannel.pipeline().addLast(new ServerChannelInHandler());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("InitServerChannel.channelRead...   msg=" + msg);
        super.channelRead(ctx, msg);
    }


}
