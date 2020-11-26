package designPatterns.singleton;

/**
 * 懒汉式双重锁定
 */
public class Singleton03 {
    private Singleton03(){}

    /**
     * 需要添加volatile
     */
    private static volatile Singleton03 INSTANCE;

    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton03.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton03();
                }
            }
        }
        return INSTANCE;
    }
}
