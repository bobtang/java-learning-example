package learning.dynamicproxy;

import java.lang.reflect.Proxy;

public class App {

    public static void main(String[] args) {
        System.out.println("learning dynamic proxy!");
        // 目标对象实现的接口，用JDK来生成代理对象一定要实现一个接口
        Class[] clazz = {WorkInteface.class};
        ClassLoader loader = WorkInteface.class.getClassLoader();
        /*InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();
                System.out.println(name);
                return null;
            }
        };*/
        //被代理真实对象
        WorkInteface wi = new WorkIntefaceImpl();
        //被代理对象调用处理程序，需传入被代理对象
        DogX dx = new DogX(wi);
        // 根据目标对象生成代理对象
        WorkInteface work = (WorkInteface) Proxy.newProxyInstance(loader, clazz, dx);
        work.coding();
    }
}
