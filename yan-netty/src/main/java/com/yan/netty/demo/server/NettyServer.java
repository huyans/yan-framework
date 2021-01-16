package com.yan.netty.demo.server;

import com.yan.netty.demo.server.channel.InitServerChannel;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 10:23
 * DESC:
 */
@Slf4j
public class NettyServer{

    public void nettyServerStart(Integer port) throws Exception {
        EventLoopGroup manageGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //1、创建启动类
            ServerBootstrap server = new ServerBootstrap();
            //2、配置启动参数等
            /**设置循环线程组，前者用于处理客户端连接事件，后者用于处理网络IO(server使用两个参数这个)
             *public ServerBootstrap group(EventLoopGroup group)
             *public ServerBootstrap group(EventLoopGroup parentGroup, EventLoopGroup childGroup)
             */
            server.group(manageGroup, workGroup);
            /**设置选项
             * 参数：Socket的标准参数（key，value），可自行百度
             * eg:
             * bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
             * bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
             */
            server.option(ChannelOption.SO_BACKLOG, 1024);
            /**
             * 用于构造socketchannel工厂
             */
            server.channel(NioServerSocketChannel.class);
            /**
             * 传入自定义客户端Handle（服务端在这里搞事情）
             */
            server.childHandler(new InitServerChannel());

            /**
             * 绑定端口，开始接收进来的连接
             */
            ChannelFuture f = server.bind(port).sync();

            /**
             * 等待服务器 socket 关闭
             */
            log.info("NettyServer start success...");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("NettyServer InterruptedException : " + e.getMessage(), e);
        } finally {
            manageGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
            log.info("NettyServer shutdown gracefully...");
        }
    }
}
