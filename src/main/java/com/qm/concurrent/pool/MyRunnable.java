package com.qm.concurrent.pool;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/4 22:32
 */
public class MyRunnable implements Runnable {
    private String nn;

    public MyRunnable(String nn) {
        this.nn = nn;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + nn);
        System.out.println(Thread.currentThread().isInterrupted());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
