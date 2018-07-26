package study.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Test;

/**
 * @author liupei
 * @date 2018/7/26 14:25
 */
public class ConcurrentHasMapUtils {

    @Test
    void test() {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

        for (int i = 1; i < 100; i++) {
            map.put(i, i);
        }
        System.out.println(map.toString());

        // 分流计算
        System.out.println(map.reduce(2, (key, value) -> value, (value, value2) -> value + value2).toString());
    }
}
