package designPatterns.factoryMethod;

public class NvWa {
    public static void main(String[] args) {
        System.out.println("----");
        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.cry();
        whiteHuman.laugh();
        whiteHuman.talk();

        System.out.println("----");
        Human human = HumanFactory.createHuman();
        human.talk();
    }
}
