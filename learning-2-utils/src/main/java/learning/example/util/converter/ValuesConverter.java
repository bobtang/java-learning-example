package learning.example.util.converter;

import com.alibaba.fastjson.TypeReference;
import com.yaowan.game.dfh.common.util.convert.ConvertUtils;
import com.yaowan.game.dfh.common.util.convert.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 物品转换器 格式为 [1001, 10]
 *
 * Created by LeiJun on 2018/7/12.
 */
@Component
public class ValuesConverter implements Converter<Values> {

    @PostConstruct
    public void register() {
        ConvertUtils.registerConverter(this);
    }

    @Override
    public Values convertFrom(String content) {
        List<Integer> data = ConvertUtils.convertTo(content, new TypeReference<List<Integer>>() {});
        return Values.of(data.get(0), data.get(1));
    }
}
