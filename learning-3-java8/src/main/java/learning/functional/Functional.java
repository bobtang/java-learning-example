package learning.functional;

/**
 * author：millet
 * create at 2018/7/18 20:51
 */

/**
 * 函数式接口：只要接口只定义了一个抽象方法
 * @FunctionalInterface这个标注用于表示该接口会设计成一个函数式接口。如果你用
 *
 * @FunctionalInterface定义了一个接口，而它却不是函数式接口的话，编译器将返回一个提示原因的错误。
 */
@FunctionalInterface
public interface Functional {
    void method();
}
