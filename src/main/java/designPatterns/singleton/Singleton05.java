package designPatterns.singleton;

/**
 * 枚举实现单例，解决线程同步，还可以防止反序列化
 * 枚举单例不会被反序列化的原因由于没有构造方法
 */
public enum Singleton05 {
    INSTANCE;

    public static Singleton05 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    System.out.println(Singleton05.getInstance().hashCode())).start();
        }
    }

    public void m() {
    }
}
