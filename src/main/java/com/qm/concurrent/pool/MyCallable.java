package com.qm.concurrent.pool;

import java.util.concurrent.Callable;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/4 22:26
 */
public class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
