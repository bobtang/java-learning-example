package com.example.proxyandcglib.proxy.dynamicproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class MyInvocationHandler implements InvocationHandler {

    private Object houseHolder;

    public MyInvocationHandler(Object object) {
        this.houseHolder = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("中介（proxy）现在有房源了，欢迎选购...");
        // jack.sale();
        method.invoke(houseHolder, args);
        log.info("中介（proxy）出租了一间房子");
        return null; // method.invoke后没有返回值直接null
    }
}
