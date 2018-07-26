package study.base;

import java.util.HashMap;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

/**
 * @author liupei
 * @date 2018/7/26 14:26
 */
public class TreeMapUtils {

    @Test
    void test() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(1, 1);
        treeMap.put(2, 2);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        treeMap.putAll(map);

        System.out.println(treeMap.toString());
        treeMap.put(10, 10);
        treeMap.put(12, 12);
        treeMap.put(14, 14);
        treeMap.put(16, 16);
        treeMap.put(18, 18);


        //小于等于比当前值 最接近的值
        System.out.println(treeMap.floorEntry(15));
        System.out.println(treeMap.floorEntry(16));
        System.out.println(treeMap.floorEntry(18));
        System.out.println(treeMap.floorEntry(20));
        System.out.println(treeMap.floorEntry(22));
        System.out.println();

        //大于等于比当前值 最接近的值
        System.out.println(treeMap.ceilingEntry(15));
        System.out.println(treeMap.ceilingEntry(16));
        System.out.println(treeMap.ceilingEntry(18));
        System.out.println(treeMap.ceilingEntry(20));

        // 第一个一个节点
        System.out.println(treeMap.firstEntry());
        // 最后一个节点
        System.out.println(treeMap.lastEntry());

        // 小于
        System.out.println(treeMap.lowerEntry(10));
        System.out.println(treeMap.lowerEntry(1));

        // 取出
        System.out.println(treeMap.pollFirstEntry());
        System.out.println(treeMap.toString());
        System.out.println(treeMap.pollLastEntry());
        System.out.println(treeMap.toString());
    }
}
