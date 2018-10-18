package com.example.demoreactiveweb.module.system.stream;

import com.example.demoreactiveweb.module.system.model.SystemData;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liupei
 * @date 2018/10/16 16:11
 */
@Component
public class FluxGenerator {
    
    private List<SystemData> list = new ArrayList<>();
    
    public FluxGenerator() {
        this.list.add(new SystemData("CTXS", 82));
        this.list.add(new SystemData("DELL", 63));
        this.list.add(new SystemData("GOOG", 847));
        this.list.add(new SystemData("MSFT", 65));
        this.list.add(new SystemData("ORCL", 45));
        this.list.add(new SystemData("RHT", 84));
        this.list.add(new SystemData("VMW", 92));
    }
    
    public Flux<SystemData> fetchSystemDataStream(Duration period) {
        
        // We want to emit quotes with a specific period;
        // to do so, we create a Flux.interval
        return Flux.interval(period)
                // In case of back-pressure, drop events
                .onBackpressureDrop()
                // For each tick, generate a list of quotes
                .map(this::generateData)
                // "flatten" that List<Quote> into a Flux<Quote>
                .flatMapIterable(quotes -> quotes)
                .log("test");
    }
    
    public List<SystemData> generateData(long interval) {
        return list;
    }
}
