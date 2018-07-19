package learning.default_interface;

/**
 * author：millet
 * create at 2018/7/18 20:49
 */
public interface Defaulable {
    default String notRequired() {
        return "Default implementation";
    }
}
//原因： 默认方法主要是为了支持库设计师，让他们能够写出更容易改进的接口

// todo 默认方法 可以重写也可以不用重写
class DefaultableImpl implements Defaulable {
}

 class OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}

interface Defaulable1 {
    default String notRequired() {
        return "Default implementation 1";
    }
}
/**todo 默认方法 如果两个接口中定义了一模一样的默认方法，并且一个实现类同时实现了这两个接口，那么必须在实现类中重写默认方法，否则编译失败。*/
class Overridable2Impl implements Defaulable ,Defaulable1{
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
