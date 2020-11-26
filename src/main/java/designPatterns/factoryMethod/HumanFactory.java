package designPatterns.factoryMethod;


import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 工厂抽象模式可以实现懒初始化（Lazy initialization）
 */
public class HumanFactory {
    private static HashMap<String, Human> humans = new HashMap<>();
    public static Human createHuman(Class c) {
        Human human = null;

        try {
            if (humans.containsKey(c.getSimpleName())) {
                human = humans.get(c.getSimpleName());
            } else {
                human = (Human)Class.forName(c.getName()).newInstance();
                humans.put(c.getSimpleName(), human);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }

    public static Human createHuman() {
        Human human = null;

        List<Class> concreateHumanList = ClassUtils.getAllClassByInterface(Human.class);
        Random random = new Random();
        int rand = random.nextInt(concreateHumanList.size());
        human = createHuman(concreateHumanList.get(rand));
        return human;
    }
}
