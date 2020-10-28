package designPatterns.proxy;

public class WangPo implements KindWomen {
    KindWomen kindWomen;

    WangPo() {
        this(new PanJinLian());
    }

    WangPo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }
    @Override
    public void makeEyesWithMen() {
        kindWomen.makeEyesWithMen();
    }

    @Override
    public void playWithMen() {
        kindWomen.playWithMen();
    }
}
