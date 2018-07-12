package learning.example.eventbus;

import com.yaowan.game.dfh.common.eventbus.EventBus;
import com.yaowan.game.dfh.common.eventbus.annotation.Observer;
import learning.example.eventbus.station.WeatherStation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by LeiJun on 2018/7/12.
 */
@ComponentScan(basePackages = {"com.yaowan.game", "learning.example"})
@SpringBootApplication
public class WeatherExample {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WeatherExample.class);
        ConfigurableApplicationContext ctx = application.run(args);

        EventBus eventBus = ctx.getBean(EventBus.class);
        ctx.getBeansWithAnnotation(Observer.class).forEach((k, v) -> eventBus.register(v));

        WeatherStation station = ctx.getBean(WeatherStation.class);
        station.collect();
    }
}
