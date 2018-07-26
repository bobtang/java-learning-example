package study.base;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author liupei
 * @date 2018/7/26 14:24
 */
public class HashMapUtils {

    @Test
    public void test() {
        HashMap<Integer, Integer> hashMap = new HashMap();

        // 单纯的替换
        System.out.println(hashMap.put(1, 1));

        // 不存在value才设值
        System.out.println(hashMap.putIfAbsent(1, 2));

        // 初始化当前key的初始值 存在不做什么操作
        System.out.println(hashMap.computeIfAbsent(1, obj -> 3));

        // 存在值就替换
        System.out.println(hashMap.computeIfPresent(1, (key, value) -> value + 4));
        System.out.println(hashMap.computeIfPresent(2, (key, value) -> value + 4));

        // 旧值存在 执行后的新值存在就重设，不存在就删除 旧值不存在 执行后的新值存在就put 不存不做操作
        System.out.println(hashMap.compute(1, (key, value) -> value != null ? value + 5 : 0));
        System.out.println(hashMap.compute(3, (key, value) -> value != null ? value + 5 : 0));

        // 值不存在使用默认值
        System.out.println(hashMap.getOrDefault(1, 100));
        System.out.println(hashMap.getOrDefault(4, 100));

        // 合并 存在的执行合并 不存在put
        hashMap.merge(1, 5, (oldValue, value) -> oldValue + value);
        System.out.println(hashMap.get(1));

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 1);
        map2.put(2, 2);
        map2.put(3, 3);
        map2.put(4, 4);
        map2.put(5, 5);
        map2.put(6, 6);

        // 新值会替换旧值
        hashMap.putAll(map2);
    }
}
