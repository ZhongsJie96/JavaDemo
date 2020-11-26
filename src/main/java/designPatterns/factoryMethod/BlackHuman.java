package designPatterns.factoryMethod;

public class BlackHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("黑：laugh");
    }

    @Override
    public void cry() {
        System.out.println("黑：cry");
    }

    @Override
    public void talk() {
        System.out.println("黑：talk");
    }
}
