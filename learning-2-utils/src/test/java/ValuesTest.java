import com.google.common.collect.ImmutableList;
import learning.example.util.Application;
import learning.example.util.converter.Values;
import learning.example.util.register.ValuesManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ValuesTest {

    @Autowired
    private ValuesManager valuesManager;

    @Test
    public void testValues() {
        Values item1001 = Values.of(1001, 100);
        Values item1002 = Values.of(1002, 10);
        Values gold = Values.of(1, 10000);
        Values diamond = Values.of(2, 30000);

        List<Values> valuesList = ImmutableList.of(item1001, item1002, gold, diamond);

        long rid = 9527;

        valuesManager.consume(rid, valuesList);

        valuesManager.reward(rid, valuesList);
    }
}
