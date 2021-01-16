package com.yan.netty.demo.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 11:05
 * DESC:
 */
@Slf4j
public class ClientChannelInHandler extends ChannelInboundHandlerAdapter {

    /**
     * 监听Channel注册
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("Netty Client has one Channel registered...  channelId=" + ctx.channel().id());
        super.channelRegistered(ctx);
    }

    /**
     * 监听Channel激活
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }
}
