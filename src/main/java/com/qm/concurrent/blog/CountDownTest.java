package com.qm.concurrent.blog;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/19 21:48
 */
public class CountDownTest {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("我醒了");

    }
}
