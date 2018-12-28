package com.qm.proxy;

public class Main {
    public static void main(String[] args) {
        IHello hello = (IHello) new MyProxy().newProxxy(new Hello());
        hello.sayHello();
    }
}
