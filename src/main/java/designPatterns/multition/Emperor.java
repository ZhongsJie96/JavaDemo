package designPatterns.multition;

import java.util.ArrayList;
import java.util.Random;

/**
 * 具有多个实例，多个实例被静态创建
 * 1. 多例可以有多个实例
 * 2. 多例类必须能够自我创建并管理自己的实例，并且向外界提供自己的实例
 */
@SuppressWarnings("all")
public class Emperor {
    private static int maxNumOfEmperor = 2;
    private static ArrayList emperorInfoList = new ArrayList(maxNumOfEmperor);
    private static ArrayList emperorList = new ArrayList(maxNumOfEmperor);
    private static int countNumOfEmperor = 0;
    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorList.add(new Emperor("皇帝：" + (i+1)));
        }
    }

    private Emperor() {

    }
    private Emperor(String info) {
        emperorInfoList.add(info);
    }

    public static Emperor getInstance() {
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return (Emperor) emperorList.get(countNumOfEmperor);
    }

    public static Emperor getInstance(int id) {
        return (Emperor) emperorList.get(id);
    }

    public static void emperorInfo() {
        System.out.println(emperorInfoList.get(countNumOfEmperor));
    }

}
