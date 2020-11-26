package designPatterns.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理是基于接口的方式
 * 每一个动态代理的调用处理程序都必须实现{@code InvocationHandler}接口，并且每个代理类的实例都关联到了实现该接口的动态类调用处理程序中，
 * 当我们通过动态代理对象调用一个方法时候，这个方法的调用就会被转发到实现InvocationHandler接口类的invoke()方法来调用
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object object;

    /**
     * final修饰参数列表，表明这个对象的内存的地址不予许修改，但值可以被修改
     * @param object
     */
    public DynamicProxyHandler(final Object object) {
        this.object = object;
    }

    /**
     *
     * @param proxy:代理类代理的真实代理对象
     * @param method：调用某个对象真实的方法
     * @param args：代理对象方法传递的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(object, args);
        System.out.println("after");
        return result;
    }
}
