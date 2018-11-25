package com.qm.nettylearn.aio;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/20 22:45
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;

        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);

        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
