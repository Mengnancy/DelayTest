package com.qm.concurrent.Barr;

import java.util.concurrent.*;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/6 20:48
 */
public class CompletationEx {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletionService<String> service = new ExecutorCompletionService<String>(executor);
        service.submit(() -> {
            Thread.sleep(1000);
            return "hello";
        });

        service.submit(() -> {
            Thread.sleep(1000);
            return "beybey";
        });

        try {
            Future<String> future = service.take();
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();

    }
}
