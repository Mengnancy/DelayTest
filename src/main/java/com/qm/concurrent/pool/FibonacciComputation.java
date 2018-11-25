package com.qm.concurrent.pool;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/6 23:26
 */
public class FibonacciComputation extends RecursiveTask<Integer> {

    private final int number;

    public FibonacciComputation(int number) {

        this.number = number;
    }

    @Override
    protected Integer compute() {
        if (number <= 1)
            return number;
        FibonacciComputation fibonacciComputation = new FibonacciComputation(number - 1);
        fibonacciComputation.fork();

        FibonacciComputation f2 = new FibonacciComputation(number - 2);
        f2.fork();
        return fibonacciComputation.compute() + f2.compute();
    }
}
