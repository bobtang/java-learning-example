package learning;


import java.util.Arrays;

/**
 * author：millet
 * create at 2018/7/17 19:40
 */
public class Test {

    public static void main(String[] args) {

        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));

    }

    /** TODO lambda表达式替换匿名类；简化代码
     *  Java 8中增加的另一个编程概念是通过API来传递代码的能力。
     * */
    private static void test_1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
    }

    private static void test_1_1() {
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }

}
