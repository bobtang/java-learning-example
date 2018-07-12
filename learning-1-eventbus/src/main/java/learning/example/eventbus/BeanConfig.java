package learning.example.eventbus;

import com.yaowan.game.dfh.common.eventbus.EventBus;
import com.yaowan.game.dfh.common.eventbus.EventBusImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Configuration
public class BeanConfig {

    @Bean
    EventBus eventBus() {
        return new EventBusImpl(Executors.newSingleThreadExecutor(), 50);
    }
}
