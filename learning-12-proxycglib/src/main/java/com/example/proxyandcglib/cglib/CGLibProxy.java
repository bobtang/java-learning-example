package com.example.proxyandcglib.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 *
 */
@Slf4j
public class CGLibProxy {

    @Test
    public void test01() {
        // 实例化一个增强器，也就是cglib中的一个class generator
        Enhancer enhancer = new Enhancer();
        // 设置目标类
        enhancer.setSuperclass(MbsConcrete.class);
        // 设置拦截对象
        enhancer.setCallback(new MyMethodInterceptor());
        // 生成代理类并返回一个实例
        MbsConcrete concrete = (MbsConcrete) enhancer.create();
        log.info(concrete.speak("猫"));
        log.info(concrete.getClass().getName());
        log.info(concrete.getClass().getSuperclass().getName());
    }
}
