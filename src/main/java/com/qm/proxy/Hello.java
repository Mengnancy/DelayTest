package com.qm.proxy;

public class Hello implements IHello {
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
