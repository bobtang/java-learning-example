package com.example.demoreactiveweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan(basePackages = "com.example.demoreactiveweb")
@MapperScan("com.example.demoreactiveweb.module.*.repository")
@SpringBootApplication
@EnableDiscoveryClient
public class DemoReactiveWebApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoReactiveWebApplication.class, args);
    }
}
