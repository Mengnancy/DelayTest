package com.qm.concurrent.pool;

import java.util.concurrent.*;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/4 22:26
 */
public class FutureTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = new MyRunnable("nn");

        String s = "结束";

        FutureTask<String> task = new FutureTask<String>(runnable,s);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(task);

        System.out.println("等待");

        String sss = task.get();

        System.out.println(sss);

        executorService.shutdown();

    }
}
