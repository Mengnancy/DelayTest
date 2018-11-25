package com.qm.concurrent.Barr;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/5 22:15
 */
public class BarrirTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("完成了");
        });

        Thread thread1 = new Thread(() -> {
            System.out.println("1执行了");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1等待结束");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("2执行了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("2等待结束");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("3执行了");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("3等待结束");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
