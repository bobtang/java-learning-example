package com.example.demoreactiveweb.module.system.controller;

import com.example.demoreactiveweb.module.system.model.SystemData;
import com.example.demoreactiveweb.module.system.repository.SystemDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liupei
 * @date 2018/10/12 10:43
 */
@RestController
public class HelloHandler {
    
    @Resource
    private SystemDao systemDao;
    
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    
    /*@RequestMapping("/hello")
    public String hello() {
        return "hello";
    }*/
    
    @RequestMapping("/hello")
    public Mono<String> hello() {
        //        Mono.delay()
        Mono.just("hello world").subscribe(key -> systemDao.add(new SystemData("lp", 1)));
        Mono.delay(Duration.ofMillis(10))
                .subscribe(key -> java.lang.System.out.println("1 Thread:" + Thread.currentThread()
                        + java.lang.System.currentTimeMillis()));
        java.lang.System.out.println("2 Thread:" + Thread.currentThread()
                + java.lang.System.currentTimeMillis());
        Mono.fromCallable(() -> {
            System.out.println("3 Thread:" + Thread.currentThread());
            systemDao.delete(1);
            return 1;
        }).subscribe(key -> java.lang.System.out.println("4 Thread:" + Thread.currentThread()
                + System.currentTimeMillis()));
        java.lang.System.out.println("5 Thread:" + Thread.currentThread()
                + java.lang.System.currentTimeMillis());
        CompletableFuture future = CompletableFuture.completedFuture("test")
                .acceptEitherAsync(CompletableFuture.completedFuture("lp"), key -> {
                    System.out.println("7 Thread:" + Thread.currentThread() + System.currentTimeMillis());
                }, executorService);
        System.out.println(future.getNow(null));
        System.out.println(future.join());
//        Mono.fromFuture(future);
        System.out.println("6 Thread:" + Thread.currentThread()
                + java.lang.System.currentTimeMillis());
        return Mono.just("hello world");
    }
    
    /*@GetMapping("/test")
    public Flux<Integer> findAll() {
        return Flux.just(1).flatMap();
    }*/
}
