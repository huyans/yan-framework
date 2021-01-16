package com.yan.netty.demo;

import com.yan.netty.demo.server.NettyServer;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 11:22
 * DESC:
 */
public class NettyServerTest {

    public static void main(String[] args) throws Exception {
        NettyServer nettyServer = new NettyServer();
        nettyServer.nettyServerStart(9999);

    }


}
