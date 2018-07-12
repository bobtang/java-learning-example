package learning.example.eventbus.app;

import com.yaowan.game.dfh.common.eventbus.annotation.Observer;
import com.yaowan.game.dfh.common.eventbus.annotation.Subscribe;
import learning.example.eventbus.station.WeatherChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
@Observer
public class AppObserver {

    @Autowired
    private AppService appService;

    @Subscribe
    public void onEvent(WeatherChangeEvent event) {
        appService.change(event.getTemperature());
    }
}
