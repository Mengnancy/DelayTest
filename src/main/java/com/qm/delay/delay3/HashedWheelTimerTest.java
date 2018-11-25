package com.qm.delay.delay3;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

public class HashedWheelTimerTest {
    static class MyTask implements TimerTask {
        boolean flag;

        public MyTask(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run(Timeout timeout) throws Exception {
            System.out.println("数据库删除订单");
            this.flag = false;
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask(true);

        Timer timer = new HashedWheelTimer();

        timer.newTimeout(myTask, 10, TimeUnit.SECONDS);

        int i = 1;
        while (myTask.flag) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "秒过去了");

            i++;
        }
    }
}
