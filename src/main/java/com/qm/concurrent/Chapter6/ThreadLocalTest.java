package com.qm.concurrent.Chapter6;

public class ThreadLocalTest {
    public static void main(String[] args) {
        while (true) {
            ThreadLocal<String> value = ThreadLocal.withInitial(() -> {
                return "ssssssssssssssssssssssssssssssssssssssssssssssssssss";
            });

            new Thread(() -> {
                value.set("ssssssssssssssssssssssssssssssssssssssssssssss");
            }).start();
        }
    }
}
