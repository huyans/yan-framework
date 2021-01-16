package com.yan.netty.demo.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 10:41
 * DESC:
 */
@Slf4j
public class ServerChannelInHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        String readMsg = new String(byteBuf.array());
        log.info("handler read msg..." + readMsg);
        byteBuf.release();//释放动作，必不可少

    }

    /**
     * 获取异常信息
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("ServerChannelInHandler.exceptionCaught... msg=" + cause.getMessage());
        super.exceptionCaught(ctx, cause);
    }


    /**
     * 信息读取完成后，执行flush操作
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
