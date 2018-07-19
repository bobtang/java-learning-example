package learning.functional;

import java.util.function.Function;

/**
 * author：millet
 * create at 2018/7/19 11:41
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute1(5, i -> i * 2, i -> i * i));//50
        System.out.println(functionTest.compute2(5, i -> i * 2, i -> i * i));//100
    }

    public int compute1(int i, Function<Integer, Integer> after, Function<Integer, Integer> before) {
       //return m1(m2(i));
        return after.compose(before).apply(i);
    }

    public int compute2(int i, Function<Integer, Integer> before, Function<Integer, Integer> after) {
       // return m2(m1(i));
        return before.andThen(after).apply(i);
    }

    private int m1(int t) {
        return t * 2;
    }

    private int m2(int t) {
        return t * t;
    }
}
