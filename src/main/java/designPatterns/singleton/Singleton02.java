package designPatterns.singleton;

/**
 * 懒汉式单例
 */
public class Singleton02 {
    private Singleton02() {}
    private static Singleton02 INSTANCE;

    public static  Singleton02 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton02();
        }
        return INSTANCE;
    }
}
