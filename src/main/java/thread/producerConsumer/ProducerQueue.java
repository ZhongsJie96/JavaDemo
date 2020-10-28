package thread.producerConsumer;

import sun.security.provider.NativePRNG;

import java.util.concurrent.BlockingQueue;

public class ProducerQueue implements Runnable{
    private final BlockingQueue<GoodsQueue> blockingQueue;

    public ProducerQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            GoodsQueue goods;
            if (i % 2 == 0) {
                goods = new GoodsQueue("娃哈哈", "矿泉水");
            } else {
                goods = new GoodsQueue("旺仔", "小馒头");
            }
            System.out.println(Thread.currentThread().getName() + "：" + goods.getBrand() + "-" + goods.getName());

            try {
                blockingQueue.put(goods);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
