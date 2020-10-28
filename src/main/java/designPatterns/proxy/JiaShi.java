package designPatterns.proxy;

public class JiaShi implements KindWomen{
    @Override
    public void makeEyesWithMen() {
        System.out.println("贾式抛媚眼");
    }

    @Override
    public void playWithMen() {
        System.out.println("贾式。。。");
    }
}
