package com.example.proxyandcglib.cglib;

import com.example.proxyandcglib.proxy.staticproxy.HouseOfJack;
import com.example.proxyandcglib.proxy.staticproxy.HouseSale;
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

    @Test
    public void test02() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HouseOfJack.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HouseSale concrete = (HouseSale) enhancer.create();
        concrete.sale();
        log.info(concrete.getClass().getName());
        log.info(concrete.getClass().getSuperclass().getName());
    }
}
