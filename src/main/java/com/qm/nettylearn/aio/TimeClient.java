package com.qm.nettylearn.aio;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/20 23:09
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port)).start();
    }
}
