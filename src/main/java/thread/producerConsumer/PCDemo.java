package thread.producerConsumer;

public class PCDemo {

    public static void main(String[] args) {
        Goods goods = new Goods();

        Consumer consumer = new Consumer(goods);
        Producer producer = new Producer(goods);
        Thread t1 = new Thread(consumer, "consumer");
        Thread t2 = new Thread(producer, "producer");

        t1.start();
        t2.start();
    }
}
