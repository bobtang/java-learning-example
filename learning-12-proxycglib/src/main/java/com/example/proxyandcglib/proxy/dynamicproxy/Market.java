package com.example.proxyandcglib.proxy.dynamicproxy;

import com.example.proxyandcglib.proxy.staticproxy.HouseOfJack;
import com.example.proxyandcglib.proxy.staticproxy.HouseSale;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class Market {

    /**
     * JDK动态代理的使用步骤：
     *
     * 定义接口及其实现类；
     * 创建*InvocationHandler类，该类实现InvocationHandler接口，重写invoke(...)方法.
     * 创建需要代理的对象，执行Proxy的newProxyInstance(...)方法
     * 执行接口中定义的方法。
     * 可以看到，核心类有两个：Proxy和InvocationHandler。
     *
     * 静态代理和动态代理显然静态代理更容易让人接受和理解，但是为什么要用动态代理呢？
     * 因为在方法的调用中，我们不想让方法的调用者和真正的执行者有过多的接触，并且我们希望调用者调用的方法对原始的方法有着一定的增强。
     * 即是为了编程上解耦呀~~~逼格高点呀~~~
     *
     * 但是jdk的动态代理也存在不足之处，JDK动态代理只能代理接口，不能代理类。如何解决代理类的问题呢？？？？
     */
    @Test
    public void market() {
        HouseOfJack houseOfJack = new HouseOfJack();
        log.info("老子有钱，要买房...");
        MyInvocationHandler saleProxy = new MyInvocationHandler(houseOfJack);
        /**
         * loader: 被代理对象所使用的类加载器
         * interfaces: 被代理类实现的接口，可以为多个
         * h: 被重定向时的对象
         */
        HouseSale houseSale = (HouseSale) Proxy.newProxyInstance(houseOfJack.getClass().getClassLoader(),
                houseOfJack.getClass().getInterfaces(), saleProxy);
        houseSale.sale();
        log.info("mbs终于租到房子住了...");
    }
}
