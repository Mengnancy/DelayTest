package com.qm.concurrent.Barr;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/6 22:50
 */
public class ExceptionTest {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 1 / 0;
            }
        };

        MyUncaughtExceptionHandler handler = new MyUncaughtExceptionHandler();
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler(handler);
                return thread;
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(5, threadFactory);
        executor.execute(runnable);
        executor.shutdown();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + " run UncaughtExceptionHandler");
    }
}
