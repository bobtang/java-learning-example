package learning.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * author：millet
 * create at 2018/7/19 13:50
 */
public class BiFunctionTest {
    public static void main(String[] args) {
        System.out.println(compute(4,5,(a,b) -> a * b,a -> a * 2));
    }

    public static int compute(int a, int b, BiFunction<Integer,Integer,Integer> biFunction,
                       Function<Integer,Integer> function){
        //return m1(m2(a,b));
        return biFunction.andThen(function).apply(a,b);
    }

    private static int m1(int a) {
        return a * 2;
    }

    private static int m2(int a,int b) {
        return a * b;
    }
}
