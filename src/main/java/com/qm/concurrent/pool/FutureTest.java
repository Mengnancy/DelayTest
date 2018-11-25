package com.qm.concurrent.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/4 22:26
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(task);

        String s = task.get();

        System.out.println(s);

        executorService.shutdown();

    }
}
