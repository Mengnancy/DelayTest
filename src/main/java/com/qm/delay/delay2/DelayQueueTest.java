package com.qm.delay.delay2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("00001");
        list.add("00002");
        list.add("00003");

        DelayQueue<OrderDelay> queue = new DelayQueue<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            queue.put(new OrderDelay(list.get(i), TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS)));
            try {
                queue.take().print();
                System.out.println("After " + (System.currentTimeMillis() - start) + " MilliSeconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
