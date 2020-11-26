package designPatterns.proxy.CGLIB;

import designPatterns.proxy.KindWomen;
import designPatterns.proxy.PanJinLian;
import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {
    public static void main(String[] args) {
        KindWomen pan = new PanJinLian();
        CglibProxy cglibProxy = new CglibProxy();
        PanJinLian panCglibProxy = (PanJinLian) cglibProxy.getProxyInstance(pan);
        panCglibProxy.makeEyesWithMen();


//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(PanJinLian.class);
//        enhancer.setCallback(new CglibProxy());
//
//        PanJinLian panProxy = (PanJinLian) enhancer.create();
//        panProxy.playWithMen();
    }
}
