package learning.example.eventbus.station;

import com.yaowan.game.dfh.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Component
public class WeatherStation {

    @Autowired
    private final EventBus eventBus;

    public WeatherStation(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void collect() {
        // ...数据采集完
        float temperature = 30.0f;

        eventBus.post(WeatherChangeEvent.of(temperature));
    }
}
