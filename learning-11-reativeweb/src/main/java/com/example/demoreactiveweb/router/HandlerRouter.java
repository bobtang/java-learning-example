package com.example.demoreactiveweb.router;

import com.example.demoreactiveweb.module.system.controller.SystemHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * 处理的
 *
 * @author liupei
 * @date 2018/10/11 20:59
 */
@Configuration
public class HandlerRouter {
    
    @Autowired
    private SystemHandler systemHandler;
    
    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions
                .route(GET("/hello1").and(accept(TEXT_PLAIN)), systemHandler::hello)
                .andRoute(GET("/stream").and(accept(TEXT_PLAIN)), systemHandler::streamData);
    }
    
    /*@Bean
    public RouterFunction<ServerResponse> route1() {
        return route(GET("/hello1"), req -> systemHandler.hello(req));
    }*/
}
