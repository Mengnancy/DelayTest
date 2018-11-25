package com.qm.concurrent.pool;

import java.util.concurrent.*;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/4 22:26
 */
public class FutureTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable callable = new MyCallable();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<String> future = executorService.submit(callable);

        String s = future.get();

        System.out.println(s);

        executorService.shutdown();

    }
}
