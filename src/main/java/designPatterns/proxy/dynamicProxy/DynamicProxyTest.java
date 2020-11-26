package designPatterns.proxy.dynamicProxy;

import designPatterns.proxy.KindWomen;
import designPatterns.proxy.PanJinLian;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        KindWomen panJinLian = new PanJinLian();
        /**
         * 接收三个参数
         * ClassLoader loader 指定当前目标对象使用的类加载器，获取加载器的方法是固定的
         * Class<?>[] interfaces 指定目标对象实现的接口的类型，使用泛型方式确认类型
         * InvocationHandler 指定动态处理器，执行目标对象的方法时，会触发事件处理器的方法
         */
        KindWomen proxy = (KindWomen) Proxy.newProxyInstance(KindWomen.class.getClassLoader(), new Class[]{KindWomen.class}, new DynamicProxyHandler(panJinLian));
        proxy.makeEyesWithMen();
    }
}
