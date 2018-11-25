package com.qm.nettylearn.nio;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/20 20:40
 */
public class TimeClient {
    public static void main(String[] args) {

        new Thread(new TimeClientHandle("127.0.0.1", 8080), "TimeClient-001").start();
    }
}
