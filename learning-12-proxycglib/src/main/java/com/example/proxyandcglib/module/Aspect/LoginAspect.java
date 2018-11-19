package com.example.proxyandcglib.module.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoginAspect {

    /**
     * *：匹配所有字符
     * ..：一般用于匹配多个包，多个参数
     * +：表示类及其子类
     */
    @Pointcut("execution(* com.example.proxyandcglib.module.handler.RoleController.login(..))")
    public void login() {
    }

    public LoginAspect() {
    }

    @Around(value = "login()")
    public Object before(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();

        long id = (long) Arrays.asList(args).get(0);
        if (id == 1) {
            return String.format("login fail");
        }
        Object o = pjp.proceed();
        return o;
    }
}
