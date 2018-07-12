package learning.example.util.register;

import learning.example.util.converter.Values;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
@Component
public class DiamondProcessor implements ValuesProcessor {

    @Override
    public ValuesType type() {
        return ValuesType.DIAMOND;
    }

    @Override
    public void consume(long rid, Values values) {
        log.info("{} 消耗钻石 {}", rid, values.getNum());
    }

    @Override
    public void reward(long rid, Values values) {
        log.info("{} 获得钻石 {}", rid, values.getNum());
    }
}
