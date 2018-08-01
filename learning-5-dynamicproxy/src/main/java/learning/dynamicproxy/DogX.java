package learning.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ModuleName
 * @Description TODO
 * @Author mbs
 * @Date 2018/7/30 15:57
 */
// 被代理对象调用处理程序，必须实现InvocationHandler接口
public class DogX implements InvocationHandler {
    // 所代理的真实对象
    private WorkInteface target;

    public DogX(WorkInteface target) {
        this.target = target;
    }

    //需要我们实现具体业务的地方
    //proxy:　　所生成代理类实例
    //method:　　指代的是我们所要调用真实对象的某个方法的Method对象
    //args:　　指代的是调用真实对象某个方法时接受的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dog start...");
        // 执行目标对象的方法
        Object invoke = method.invoke(target, args);
        System.out.println("dog end...");
        return invoke;
    }
}
