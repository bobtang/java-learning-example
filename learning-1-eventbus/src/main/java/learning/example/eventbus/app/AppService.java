package learning.example.eventbus.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
@Component
public class AppService {

    public void change(float temperature) {
        // ... 推送
        log.info("App ---- now temperature is {}", temperature);
    }
}
