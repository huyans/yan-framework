package com.yan.netty.demo;

import com.yan.netty.demo.client.NettyClient;

/**
 * Created by huyan on 2021/1/16.
 * TIME: 11:23
 * DESC:
 */
public class NettyClientTest {

    private static final String host = "127.0.0.1";
    private static final Integer port = 9999;

    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient();
        client.nettClientStart(host, port);
    }
}
