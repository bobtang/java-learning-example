package learning.functional;

import learning.model.Apple;

import java.util.function.Supplier;

/**
 * author：millet
 * create at 2018/7/19 15:14
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();
    }
}
