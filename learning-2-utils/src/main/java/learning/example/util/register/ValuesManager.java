package learning.example.util.register;

import com.yaowan.game.dfh.common.base.Asserts;
import com.yaowan.game.dfh.common.base.bean.IRegister;
import learning.example.util.converter.Values;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Component
public class ValuesManager implements IRegister<ValuesProcessor> {

    private EnumMap<ValuesType, ValuesProcessor> processors = new EnumMap<>(ValuesType.class);

    @Override
    public void registerBean(ValuesProcessor bean) {
        Asserts.isNull(processors.putIfAbsent(bean.type(), bean), () -> String.format("{%s} duplicated", bean));
    }

    private ValuesProcessor getProcessor(ValuesType type) {
        return processors.get(type);
    }

    public void consume(long rid, List<Values> list) {
        list.forEach(values -> getProcessor(ValuesType.of(values.getId())).consume(rid, values));
    }

    public void reward(long rid, List<Values> list) {
        list.forEach(values -> getProcessor(ValuesType.of(values.getId())).reward(rid, values));
    }
}
