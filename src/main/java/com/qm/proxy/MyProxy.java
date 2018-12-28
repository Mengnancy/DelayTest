package com.qm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {
    private Object orign;

    public Object newProxxy(Object object) {
        this.orign = object;
        return Proxy.newProxyInstance(orign.getClass().getClassLoader(), orign.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Welcom, ");
        return method.invoke(orign, args);
    }
}
