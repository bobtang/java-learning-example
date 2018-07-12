package learning.example.util.register;

import learning.example.util.converter.Values;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
@Component
public class ItemProcessor implements ValuesProcessor {

    @Override
    public ValuesType type() {
        return ValuesType.ITEM;
    }

    @Override
    public void consume(long rid, Values values) {
        log.info("{} 消耗道具 {}", rid, values);
    }

    @Override
    public void reward(long rid, Values values) {
        log.info("{} 获得道具 {}", rid, values);
    }
}
