package com.yan.netty.demo.client;

import com.yan.netty.demo.client.channel.InitClientChannel;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 10:49
 * DESC:
 */
@Slf4j
public class NettyClient{

    public void nettClientStart(String host, Integer port) throws Exception {

        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap client = new Bootstrap();

            /**
             * EventLoop的组
             */
            client.group(worker);

            /**
             * 用于构造socketchannel工厂
             */
            client.channel(NioSocketChannel.class);

            /**设置选项
             * 参数：Socket的标准参数（key，value） 保持呼吸，不要断气！
             */
            client.option(ChannelOption.SO_KEEPALIVE, true);

            /**
             * 自定义客户端Handle（客户端在这里搞事情）
             */
            client.handler(new InitClientChannel());

            /** 开启客户端监听*/
            ChannelFuture f = client.connect(host, port).sync();
            /**等待数据直到客户端关闭*/
            f.channel().closeFuture().sync();
            log.info("NettyClient start success...");
        } finally {
            worker.shutdownGracefully();
            log.info("NettyClient shutdown gracefully...");
        }

    }
}
