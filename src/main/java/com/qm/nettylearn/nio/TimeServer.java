package com.qm.nettylearn.nio;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/20 20:13
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;

        MultiPlexerTimeServer timeServer = new MultiPlexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiPlexerTimeServer-001").start();
    }
}
