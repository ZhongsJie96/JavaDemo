package thread.producerConsumer;


/**
 * @author zhong
 * 消费者
 */
public class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                goods.consume("娃哈哈", "矿泉水");
            } else {
                goods.consume("旺仔", "小馒头");
            }
        }
    }
}
