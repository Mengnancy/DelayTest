package com.qm.delay.delay2;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class OrderDelay implements Delayed {
    private String orderId;
    private long timeOut;

    public OrderDelay(String orderId, long timeOut) {
        this.orderId = orderId;
        this.timeOut = timeOut + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeOut - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if (other == this)
            return 0;
        OrderDelay t = (OrderDelay) other;
        long d = (getDelay(TimeUnit.NANOSECONDS) - t
                .getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    public void print() {
        System.out.println("删除订单 " + orderId);
    }
}
