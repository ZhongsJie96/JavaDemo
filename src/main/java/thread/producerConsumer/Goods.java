package thread.producerConsumer;

/**
 * @author zhong
 */
public class Goods {
    private String brand;
    private String name;

    /** 通过设置标志位来确定是否已经被生产*/
    private boolean flag = false;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 生产者生产商品
     * @param brand
     * @param name
     */
    public synchronized void product(String brand, String name) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        flag = true;
        System.out.println(Thread.currentThread().getName() + "：" + this.getBrand() + "-" + this.getName());
        this.notifyAll();
    }

    /**
     * 消费者消费掉商品
     * @param brand
     * @param name
     */
    public synchronized void consume(String brand, String name) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        System.out.println(Thread.currentThread().getName() + "：" + this.getBrand() + "-" + this.getName());
        this.notifyAll();
    }
}
