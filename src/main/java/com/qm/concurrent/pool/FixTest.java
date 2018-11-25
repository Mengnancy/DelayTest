package com.qm.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/5 22:03
 */
public class FixTest {
    public static void main(String[] args) {
        Runnable a = new MyRunnable("a");
        Runnable b = new MyRunnable("b");
        Runnable c = new MyRunnable("c");
        ExecutorService pool = Executors.newFixedThreadPool(2);
//        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(a);
        pool.submit(b);
        pool.shutdownNow();
//        pool.submit(c);
//        pool.shutdown();
    }
}
