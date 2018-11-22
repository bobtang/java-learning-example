package com.example.proxyandcglib.module;

import com.example.proxyandcglib.module.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@ComponentScan(basePackages = {"com.example.proxyandcglib"})
@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        log.info("那种代理？？输出： " + context.getBean(RoleService.class).getClass());
//        context.close();
    }
}
