import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.yaowan.game.dfh.common.util.convert.ConvertUtils;
import learning.example.util.Application;
import learning.example.util.converter.Values;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ConvertTest {

    @Test
    public void testConvert() {
        String input = "123.456";

        log.info("convert to float {}", ConvertUtils.toFloat(input));

        String reward = "[1001, 1]";
        Values values = ConvertUtils.convertTo(reward, new TypeReference<Values>() {});
        log.info("convert to values {}", values);

        ImmutableList<Integer> immutableList = ConvertUtils.convertTo(reward, new TypeReference<ImmutableList<Integer>>() {});
        log.info("convert to ImmutableList<Integer> {}", immutableList);

        ImmutableSet<Integer> immutableSet = ConvertUtils.convertTo(reward, new TypeReference<ImmutableSet<Integer>>() {});
        log.info("convert to ImmutableSet<Integer> {}", immutableSet);

        String rewards = "[[1001, 1], [1002, 2]]";
        ImmutableList<ImmutableList<Integer>> immutableListList = ConvertUtils.convertTo(rewards, new TypeReference<ImmutableList<ImmutableList<Integer>>>() {});
        log.info("convert to ImmutableList<ImmutableList<Integer>> {}", immutableListList);
    }
}
