package learning.example.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by LeiJun on 2018/9/20.
 */
public class CollectExamples {

    @Test
    public void testCollections() {
        // 1.6
        List<Integer> list1 = new ArrayList<Integer>();
        // guava
        List<Integer> list2 = Lists.newArrayList();
        // 1.7
        List<Integer> list3 = new ArrayList<>();

        Map<Integer, String> map = Maps.newHashMap();

        ConcurrentMap<Integer, String> concurrentMap = Maps.newConcurrentMap();
        // ... more
    }

    @Test
    public void testImmutableCollection() {
        // 之前可能写过不少这样类似的代码
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        System.out.println(String.format("numbers %s", numbers));

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("rid", 10000L);
        parameters.put("type", 1);
        System.out.println(String.format("parameters %s", parameters));

        // 不可变集合

        List<Integer> numbers1 = ImmutableList.of(1, 2, 3, 4);
        System.out.println(String.format("numbers1 %s", numbers1));

        Map<String, Object> parameters1 = ImmutableMap.of("rid", 10000L, "type", 1);
        System.out.println(String.format("parameters1 %s", parameters1));

        // builder
        List<Integer> numbers2 = ImmutableList.<Integer>builder().add(1).add(2).add(3).build();
        System.out.println(String.format("numbers2 %s", numbers2));

        Map<String, Object> parameters2 = ImmutableMap.<String, Object>builder().put("rid", 10000L).put("type", 1).build();
        System.out.println(String.format("parameters2 %s", parameters1));
    }

    @Test
    public void testIterables() {
        List<Integer> numbers = ImmutableList.of(1, 2, 3, 4);
        System.out.println(String.format("first %s", Iterables.getFirst(numbers, 0)));
        System.out.println(String.format("last %s", Iterables.getLast(numbers, 0)));
    }

    @Test
    public void testMoreCollections() {
        Set<Integer> set1 = ImmutableSet.of(1, 2, 3);
        Set<Integer> set2  = ImmutableSet.of(3, 4, 5, 6);

        Sets.SetView<Integer> union = Sets.union(set1, set2);
        System.out.println(union);

        Sets.SetView<Integer> difference = Sets.difference(set1, set2);
        System.out.println(difference);

        Sets.SetView<Integer> intersection = Sets.intersection(set1, set2);
        System.out.println(intersection);

        Map<Integer, String> map1 = ImmutableMap.of(1, "a", 2, "b");
        Map<Integer, String> map2 = ImmutableMap.of(2, "b", 3, "c", 4, "d");

        MapDifference<Integer, String> mapDifference = Maps.difference(map1, map2);
        System.out.println(mapDifference.areEqual());
        System.out.println(mapDifference.entriesDiffering());
        System.out.println(mapDifference.entriesInCommon());
        System.out.println(mapDifference.entriesOnlyOnLeft());
        System.out.println(mapDifference.entriesOnlyOnRight());
    }

    @Test
    public void testBiMap() {
        BiMap<Integer, String> map = HashBiMap.create();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        System.out.println(String.format("k = %s, v= %s", 1, map.get(1)));
        System.out.println(String.format("k = %s, v= %s", "a", map.inverse().get("a")));
    }

    @Test
    public void testMultiMap() {
        Map<Integer, List<String>> mapList = new HashMap<>();
        mapList.computeIfAbsent(1, key -> new ArrayList<>()).add("a");
        mapList.computeIfAbsent(1, key -> new ArrayList<>()).add("b");
        mapList.computeIfAbsent(2, key -> new ArrayList<>()).add("c");
        mapList.computeIfAbsent(2, key -> new ArrayList<>()).add("d");
        System.out.println(String.format("mapList %s", mapList));

        Multimap<Integer, String> multimap = HashMultimap.create();
        multimap.put(1, "a");
        multimap.put(1, "b");
        multimap.put(2, "c");
        multimap.put(2, "d");
        System.out.println(String.format("multimap %s", multimap));
    }

    @Test
    public void testInterners() {

        String lock = "a";
        // 1.7里慎用String.intern() 作为synchronized的对象锁
        // 1.7里String.intern生成的String不再是在perm gen分配，而是在Java Heap中分配
        synchronized (lock.intern()) {
            // .....
        }


        Interner<String> pool = Interners.newWeakInterner();
        synchronized (pool.intern(lock)) {
            // ....
        }
    }
}
