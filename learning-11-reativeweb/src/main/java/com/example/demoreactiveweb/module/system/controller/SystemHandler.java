package com.example.demoreactiveweb.module.system.controller;

import com.example.demoreactiveweb.module.system.model.SystemData;
import com.example.demoreactiveweb.module.system.repository.SystemDao;
import com.example.demoreactiveweb.module.system.stream.FluxGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author liupei
 * @date 2018/10/11 21:09
 */
@Component
public class SystemHandler {
    
    @Resource
    private SystemDao systemDao;
    @Autowired
    private FluxGenerator fluxGenerator;
    
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ok().contentType(TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello Spring!"));
    }
    
    public Mono<ServerResponse> streamData(ServerRequest request) {
        Flux<SystemData> flux = this.fluxGenerator.fetchSystemDataStream(Duration.ofMillis(10000)).share();
        return ok().contentType(APPLICATION_STREAM_JSON)
                .body(flux, SystemData.class);
    }
}
