package learning.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author：millet
 * create at 2018/7/19 10:44
 */
public class TestStream {

    /**
     * Java8中，所有的流操作会被组合到一个 stream pipeline中，这点类似linux中的pipeline概念，
     * 将多个简单操作连接在一起组成一个功能强大的操作。一个 stream pileline首先会有一个数据源，
     * 这个数据源可能是数组、集合、生成器函数或是IO通道，流操作过程中并不会修改源中的数据；
     * 然后还有零个或多个中间操作，每个中间操作会将接收到的流转换成另一个流（比如filter）；
     * 最后还有一个终止操作，会生成一个最终结果（比如sum）。
     * 流是一种惰性操作，所有对源数据的计算只在终止操作被初始化的时候才会执行。
     */

    /**
     * 总结一下流操作由3部分组成
     * 1.源
     * 2.零个或多个中间操作
     * 3.终止操作 （到这一步才会执行整个stream pipeline计算）
     *
     * 创建流的几种方式
     */

    //todo 创建流的几种方式
    private static void  createStream(){
        //第一种 通过Stream接口的of静态方法创建一个流
        Stream<String> stream = Stream.of("hello", "world", "helloworld");

        //第二种 通过Arrays类的stream方法，实际上第一种of方法底层也是调用的Arrays.stream(values);
        String[] array = new String[]{"hello","world","helloworld"};
        Stream<String> stream3 = Arrays.stream(array);

        //第三种 通过集合的stream方法，该方法是Collection接口的默认方法，所有集合都继承了该方法
        Stream<String> stream2 = Arrays.asList("hello","world","helloworld").stream();
    }
    // todo Stream的map方法
    private static void testMap(){
/**
 * 这里我们使用了Stream的map方法，map方法接收一个Function函数式接口实例，
 * 这里的map方法对每个元素进行映射处理。然后传入lambda表达式将每个元素转换大写，通过collect方法将结果收集到ArrayList中。
 *
 * <R> Stream<R> map(Function<? super T, ? extends R> mapper);//map函数定义
 */
        List<String> list = Arrays.asList("hello", "world", "helloworld");
        List<String> collect = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

        //那如果我们想把结果放到Set中或者替他的集合容器，也可以这样
        list.stream().map(s -> s.toUpperCase()).collect(Collectors.toSet());//放到Set中

        list.stream().map(s -> s.toUpperCase()).collect(Collectors.toCollection(TreeSet::new));//自定义容器类型
    }


//todo 扁平流 stream中除了map方法对元素进行映射外，还有一个flatMap方法
    /**
     * todo map 与 flatMap
     * map方法是将一个容器里的元素映射到另一个容器中。
     * flatMap方法，可以将多个容器的元素全部映射到一个容器中，即为扁平的map。
     */
    private static void  testFlatMap(){
        Stream<List<Integer>> listStream =
                Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));

        List<Integer> collect1 = listStream.flatMap(theList -> theList.stream()).
                map(integer -> integer * integer).collect(Collectors.toList());
    }

    // todo 统计信息的方法
    private static void  testStatistics (){
    //同时获取最大 最小 平均值等信息
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9, 11);
        IntSummaryStatistics statistics = list1.stream().
                filter(integer -> integer > 2).mapToInt(i -> i * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(statistics.getMax());//18
        System.out.println(statistics.getMin());//14
        System.out.println(statistics.getAverage());//16

        /**
         * 将list1中的数据取出大于2的，每个数进行平方计算，
         * skip(2)忽略前两个，limit(2)再取出前两个，
         * summaryStatistics对取出的这两个数计算统计数据。
         * mapToInt接收一个ToIntFunction类型，也就是接收一个参数返回值是int类型。
         */
    }
    public static void main(String[] args) {
        createStream();
        testMap();
        testFlatMap();
        testStatistics();
    }




}
