package com.example.proxyandcglib.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class MyMethodInterceptor implements MethodInterceptor {
    /**
     * 在实际方法被调用的时候，代理对象会把执行的函数重定向到interceptor(...)这里，这与JDK的动态代理是一致的，
     * 但是JDK动态代理是通过反射来对原始方法进行执行，而Cglib不然；
     * 因为反射的效率会比较低，Cglib通过FastClass的机制来实现对被拦截方法的调用。
     * FastClass f1; // net.sf.cglib.test.HelloConcrete的fastclass
     *         FastClass f2; // MbsConcrete$$EnhancerByCGLIB$$4d552cc 的fastclass
     *         int i1; //方法speak在f1中的索引
     *         int i2; //方法CGLIB$speak$0在f2中的索引
     * @param o 代理对象本身
     * @param method 被拦截的方法对象
     * @param objects 方法调用入参
     * @param methodProxy 用于调用被拦截方法的方法代理对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("MyMethodInterceptor....intercept.....");
        return methodProxy.invokeSuper(o, objects);
    }
}
