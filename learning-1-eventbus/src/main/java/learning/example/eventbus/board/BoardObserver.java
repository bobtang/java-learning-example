package learning.example.eventbus.board;

import com.yaowan.game.dfh.common.eventbus.annotation.Observer;
import com.yaowan.game.dfh.common.eventbus.annotation.Subscribe;
import learning.example.eventbus.station.WeatherChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Observer
public class BoardObserver {

    @Autowired
    private BulletinBoard bulletinBoard;

    @Subscribe
    public void onEvent(WeatherChangeEvent event) {
        bulletinBoard.change(event.getTemperature());
    }
}
