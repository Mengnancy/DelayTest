package com.qm.nettylearn.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/20 22:46
 */
public class AsyncTimeServerHandler implements Runnable {
    private int port;
    CountDownLatch latch;
    AsynchronousServerSocketChannel serverSocketChannel;

    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAccept() {
        serverSocketChannel.accept(this,new AcceptCompletionHandler());
    }
}
