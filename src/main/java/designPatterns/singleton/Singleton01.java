package designPatterns.singleton;

/**
 * 饿汉式单例
 */
public class Singleton01 {
    private Singleton01() {}
    private static final Singleton01 INSTANCE = new Singleton01();

    public static Singleton01 getInstance() {
        return INSTANCE;
    }
}
