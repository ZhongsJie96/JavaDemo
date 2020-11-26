package designPatterns.singleton;

/**
 * 静态内部类实现单例
 * JVM保证线程安全
 */
public class Singleton04 {
    private Singleton04(){}
    private static class SingletonHolder {
        private static final Singleton04 INSTANCE = new Singleton04();
    }
    public static final Singleton04 getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
