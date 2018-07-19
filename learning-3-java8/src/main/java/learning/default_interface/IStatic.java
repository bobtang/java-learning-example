package learning.default_interface;

/**
 * author：millet
 * create at 2018/7/19 10:14
 */
public interface IStatic {
    static void staticMethod(){
        System.out.println("静态方法");
    }
}

interface IStatic2 extends IStatic{

}
class StaticImpl implements IStatic {
}