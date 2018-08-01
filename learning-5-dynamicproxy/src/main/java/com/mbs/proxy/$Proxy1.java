package com.mbs.proxy;
import java.lang.reflect.Method;
import learning.dynamicproxy.imitation.InvocationHandler;
public class $Proxy1 implements learning.dynamicproxy.imitation.Moveable{
    public $Proxy1(InvocationHandler h) {
        this.h = h;
    }
    learning.dynamicproxy.imitation.InvocationHandler h;
@Override
public void move() {
    try {
    Method md = learning.dynamicproxy.imitation.Moveable.class.getMethod("move");
    h.invoke(this, md);
    }catch(Exception e) {e.printStackTrace();}
}}