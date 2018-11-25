package com.qm.concurrent.Chapter6;

public class ReadWriteLockClient {
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new WriteWorker(sharedData,"qwertyuiop").start();
        new WriteWorker(sharedData,"QWERTYUIOP").start();
    }
}
