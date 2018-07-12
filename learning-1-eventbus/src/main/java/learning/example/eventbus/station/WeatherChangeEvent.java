package learning.example.eventbus.station;

import lombok.Value;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Value(staticConstructor = "of")
public class WeatherChangeEvent {
    private float temperature;
    // ...
}
