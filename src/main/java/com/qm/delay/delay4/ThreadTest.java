package com.qm.delay.delay4;

import java.util.concurrent.CountDownLatch;

public class ThreadTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    static class DelayMessage implements Runnable {

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AppTest appTest = new AppTest();
            appTest.consumerDelayMessage();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AppTest appTest = new AppTest();
        appTest.productionDelayMessage();
        for (int i = 0; i < 10; i++) {
            new Thread(new DelayMessage()).start();
            countDownLatch.countDown();
        }
    }
}
