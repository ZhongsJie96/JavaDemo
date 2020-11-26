package designPatterns.proxy.CGLIB;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，如何实现动态代理呢，
 * 这就需要CGLib了。CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创
 * 建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。但因为
 * 采用的是继承，所以不能对final修饰的类进行代理。JDK动态代理与CGLib动态代理均是实现Spring AOP的基础。
 *
 * CGLIB动态代理是代理类去继承目标类，然后重写其中目标类的方法
 *
 * java.lang.NoClassDefFoundError需要添加asm.jar文件
 * asm是字节码操作和分析框架，常常被使用到第三方框架中
 * https://javabeat.net/java-lang-noclassdeffounderror-orgobjectwebasmclassvisitor/
 *
 * CGLIB创建的动态代理对象比JDK创建的动态代理对象的性能更高，但是CGLIB创建代理对象时所花费的时间比JDK多
 * 同时由于CGLIB采用动态创建子类的方法，对于final修饰的方法无法进行代理
 *
 * @author zhong
 */
public class CglibProxy implements MethodInterceptor {
    private Object object;

    public Object getProxyInstance(final Object object) {
        this.object = object;
        // 创建enhancer对象，类似于JDK动态代理的Proxy类
        Enhancer enhancer = new Enhancer();
        // 设置目标类的字节码文件
        enhancer.setSuperclass(this.object.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 正式创建代理类
        return enhancer.create();
    }
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        // 方法调用
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("after");
        return result;
    }
}
