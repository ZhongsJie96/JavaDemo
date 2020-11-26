package designPatterns.factoryMethod;

public class YellowHuman implements Human{
    @Override
    public void laugh() {
        System.out.println("黄：laugh");
    }

    @Override
    public void cry() {
        System.out.println("黄：cry");
    }

    @Override
    public void talk() {
        System.out.println("黄：talk");
    }
}
