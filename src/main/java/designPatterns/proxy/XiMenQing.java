package designPatterns.proxy;

public class XiMenQing {
    public static void main(String[] args) {
        WangPo wangPo = new WangPo(new JiaShi());
        wangPo.makeEyesWithMen();
        wangPo.playWithMen();
    }
}
