package com.qm.concurrent.pool;

import java.util.concurrent.*;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/6 23:55
 */
public class WorkSteal {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int number = 30;
        ExecutorService pool = Executors.newWorkStealingPool();
        FibonacciCallable f1 = new FibonacciCallable(number);
        long beforeTime = System.currentTimeMillis();

        Future<Integer> future = pool.submit(f1);
        System.out.println(future.get());

        System.out.println("Total Time in MilliSecond Taken ->  " + (System.currentTimeMillis() - beforeTime));
        pool.shutdown();

    }
}
