package com.qm.concurrent.pool;

import java.util.concurrent.Callable;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/6 23:59
 */
public class FibonacciCallable implements Callable {
    private final int number;

    public FibonacciCallable(int number) {
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        if (number <= 1)
            return number;
        FibonacciComputation fibonacciComputation = new FibonacciComputation(number - 1);
        fibonacciComputation.fork();

        FibonacciComputation f2 = new FibonacciComputation(number - 2);
        f2.fork();
        return fibonacciComputation.compute() + f2.compute();
    }
}
