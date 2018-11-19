package com.example.proxyandcglib.module.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class RoleLogAspect {

    private static final String LOG_FORMATTER = "%s.%s - %s";

    @Pointcut("execution(* com.example.proxyandcglib.module.handler.RoleController.register(..))")
    public void register() {
    }

    public RoleLogAspect() {
    }

    @Before(value = "register()")
    public void before(JoinPoint jp) {
        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        Object[] params = jp.getArgs();
        log.info(String.format(LOG_FORMATTER, className, methodName, Arrays.toString(params)));
    }

    @After("register()")
    public void after(JoinPoint jp) {
        log.info(String.format("register end, %s", jp.getSignature().getName()));
    }
}
