package learning.default_interface;

/**
 * author：millet
 * create at 2018/7/19 10:03
 */
public class TestDefaulable {

    public static void main(String[] args) {
        //todo 静态方法，只能通过接口名调用，不可以通过实现类的类名或者实现类的对象调用。
        IStatic.staticMethod();
       // IStatic2.
        //StaticImpl

        //default方法，只能通过接口实现类的对象来调用。
    }
}
