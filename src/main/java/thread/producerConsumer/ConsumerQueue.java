package thread.producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhong
 * 使用blockingQueue来完成生产者消费者模型
 */
public class ConsumerQueue implements Runnable {
    private BlockingQueue<GoodsQueue> blockingQueue;

    public ConsumerQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("consumer:" + blockingQueue.take().getBrand() + "-" + blockingQueue.take().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
