package com.qm.concurrent.pool;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/6 23:28
 */
public class FibonacciComutationClient {
    public static void main(String[] args) {
        int number = 30;
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
//        ForkJoinPool pool = new ForkJoinPool(1);
        System.out.println("Parallelism  => " + pool.getParallelism());
        long beforeTime = System.currentTimeMillis();
        Integer result = pool.invoke(new FibonacciComputation(number));

        System.out.println("Total Time in MilliSecond Taken ->  " + (System.currentTimeMillis() - beforeTime));
        System.out.println(number + " the element of Fibonacci Number = " + result);
    }
}
