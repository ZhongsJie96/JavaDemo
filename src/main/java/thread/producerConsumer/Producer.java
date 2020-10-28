package thread.producerConsumer;

/**
 * @author zhong
 * 消费者
 */
public class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                goods.product("娃哈哈", "矿泉水");
            } else {
                goods.product("旺仔", "小馒头");
            }
        }
    }
}
