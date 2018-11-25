package com.qm.concurrent.pool;

import java.util.concurrent.Executors;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/18 0:02
 */
public class Worker implements Runnable {
    private Runnable r;
    private Thread wt;

    public Worker(Runnable r) {
        this.r = r;
//        this.wt = Executors.defaultThreadFactory().newThread(this);
        wt = new Thread(this);
    }

    public Thread getWt() {
        return wt;
    }

    @Override
    public void run() {
        System.out.println(wt.isAlive());
        wt.interrupt();
        r.run();
    }
}
