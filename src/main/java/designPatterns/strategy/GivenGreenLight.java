package designPatterns.strategy;

public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("开个绿灯，放行");
    }
}
