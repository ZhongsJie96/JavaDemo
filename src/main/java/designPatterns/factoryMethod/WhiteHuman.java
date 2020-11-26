package designPatterns.factoryMethod;

public class WhiteHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("白：laugh");
    }

    @Override
    public void cry() {
        System.out.println("白：cry");
    }

    @Override
    public void talk() {
        System.out.println("白：talk");
    }
}
