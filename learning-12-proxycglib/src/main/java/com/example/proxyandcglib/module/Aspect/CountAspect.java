package com.example.proxyandcglib.module.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Aspect
@Component
public class CountAspect {

    private AtomicInteger count = new AtomicInteger(0);

    @Pointcut("execution(* com.example.proxyandcglib.module.service.RoleServiceImpl.get(..))")
    public void count() {
    }

    public CountAspect() {
    }

    @After(value = "count()")
    public void before() {
        int total = this.count.incrementAndGet();
        log.info(String.format("统计count：%s", total));
    }
}
