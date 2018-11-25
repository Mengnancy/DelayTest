package com.qm.concurrent.pool;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/6 23:34
 */
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long beforeTime = System.currentTimeMillis();
        int result = fibonacci.count(30);
        System.out.println("Total Time in MilliSecond Taken ->  " + (System.currentTimeMillis() - beforeTime));
        System.out.println("30 the element of Fibonacci Number = " + result);
    }

    private int count(int number) {
        if (number <= 1)
            return number;
        int a = count(number - 1);
        int b = count(number - 2);
        return a + b;
    }
}
