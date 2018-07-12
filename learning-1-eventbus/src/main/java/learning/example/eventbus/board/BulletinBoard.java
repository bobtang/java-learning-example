package learning.example.eventbus.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
@Component
public class BulletinBoard {

    public void change(float temperature) {
        // ... 更改显示
        log.info("BulletinBoard --- now temperature is {}", temperature);
    }
}
