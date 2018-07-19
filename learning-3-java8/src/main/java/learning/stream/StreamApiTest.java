package learning.stream;

import com.alibaba.fastjson.JSON;
import learning.model.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

/**
 * author：millet
 * create at 2018/7/19 15:30
 */
public class StreamApiTest {

    public static void main(String[] args) {
        StreamApiTest obj = new StreamApiTest();
        //filter()：接受一个谓词，返回符合条件的元素集合
        obj.filter();

        // 返回集合中各异的元素集合(去重)
        obj.distinct();

        //截取流中指定数量的元素，返回一个不超过给定长度的流。如果流是有序的，则最多会返回前n个元素。
        obj.limit();

        //anyMatch()：至少匹配一个
        obj.anyMatch();

        //allMatch()：全部匹配
        obj.allMatch();

        //noneMatch()：全部不匹配，和allMatch相反
        obj.noneMatch();

        // 查找有2个方法：findFirst()和findAny()，返回一个Optional<T>集合。
        //如果你不关心返回的元素是哪个，请使用findAny()，因为它在使用并行流时限制较少。
        obj.findFirst();
        obj.findAny();

        //归约在汇总结合内所有数据的时候使用。比如求 max，min，sum。
        obj.reduce();

    // todo 原始类型流特化
        /**
         * 流在内部迭代的过程中，对基本类型会自动装箱和拆箱。为了避免不需要的装箱拆箱，Java8提供了IntStream、DoubleStream和LongStream
         * - 普通流转特化流：mapToInt(), mapToLong(), mapToDouble()
         * - 特化流转普通流：boxed()
         */
        obj.boxedStream();
    }

    public void filter() {
        List<Dish> menu = init();
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(vegetarianMenu));
    }

    public void distinct() {
        List<Integer> numbers = Arrays.asList(5, 1, 2, 1, 3, 3, 2, 4);
        numbers.stream().distinct().forEach(System.out::println);
    }

    //limit()：截取流中指定数量的元素，返回一个不超过给定长度的流。如果流是有序的，则最多会返回前n个元素。
    public void limit() {
        List<Dish> menu = init();
        menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .forEach(System.out::println);
    }

    //skip()：跳过指定数量元素，返回一个扔掉了前n个元素的流。如果流中元素不足n个，则返回一个空流。
    public void skip() {
        List<Dish> menu = init();
        menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .skip(2)
                .forEach(System.out::println);
    }
    public void anyMatch() {
        List<Dish> menu = init();
        System.out.println(menu.stream().anyMatch(Dish::isVegetarian));
    }

    public void allMatch() {
        List<Dish> menu = init();
        System.out.println(menu.stream().allMatch(d -> d.getCalories() < 1000));
    }

    public void noneMatch() {
        List<Dish> menu = init();
        System.out.println(menu.stream().noneMatch(d -> d.getCalories() >= 1000));
    }

    public void findFirst() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst(); // 9
        System.out.println(firstSquareDivisibleByThree.get());
    }

    public void findAny() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findAny(); // 9
        System.out.println(firstSquareDivisibleByThree.get());
    }

    public void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);//Integer::max  Integer::min
        System.out.println(sum);

        Optional<Integer> optional = numbers.stream().reduce(Integer::max);
        System.out.println(optional.get());

    }

    public void boxedStream() {
        List<Dish> menu = init();
        // 特化
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        // 转回普通Stream
        Stream<Integer> stream = intStream.boxed();
    }
    public void collectors(){
        List<Dish> menu = init();
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));//Collectors.summingLong，Collectors.summingDouble

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));

        //请注意，joining在内部使用了StringBuilder来把生成的字符串逐个追加起来。
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
    }

    public List<Dish> init() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }
}
