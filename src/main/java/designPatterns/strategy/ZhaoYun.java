package designPatterns.strategy;

public class ZhaoYun {
    public static void main(String[] args) {
        Context context;

        System.out.println("第一个锦囊");
        context = new Context(new BackDoor());
        context.operate();
        System.out.println("-------");

        System.out.println("第二个锦囊");
        context = new Context(new GivenGreenLight());
        context.operate();
        System.out.println("-------");

        System.out.println("第三个锦囊");
        context = new Context(new BlockEnemy());
        context.operate();
        System.out.println("-------");
    }
}
