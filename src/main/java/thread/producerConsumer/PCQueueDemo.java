package thread.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<GoodsQueue> queue = new ArrayBlockingQueue(5);
        ConsumerQueue consumer = new ConsumerQueue(queue);
        ProducerQueue producer = new ProducerQueue(queue);
        Thread t1 = new Thread(consumer, "consumer");
        Thread t2 = new Thread(producer, "producer");

        t1.start();
        t2.start();
    }
}
