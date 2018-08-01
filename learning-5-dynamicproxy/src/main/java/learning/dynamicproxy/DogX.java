package learning.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ModuleName
 * @Description TODO
 * @Author mbs
 * @Date 2018/7/30 15:57
 */
public class DogX implements InvocationHandler {

    private WorkInteface target;

    public DogX(WorkInteface target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dog start...");
        // 执行目标对象的方法
        Object invoke = method.invoke(target, args);
        System.out.println("dog end...");
        return invoke;
    }
}
