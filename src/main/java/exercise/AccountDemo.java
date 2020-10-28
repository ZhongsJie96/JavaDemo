package exercise;

/**
 * @author zhong
 */
public class AccountDemo implements Runnable {

    private static int money = 2000;

    public static void main(String[] args) {
        AccountDemo threadDemo2 = new AccountDemo();
        Thread t1 = new Thread(threadDemo2, "张三");
        Thread t2 = new Thread(threadDemo2, "张三的妻子");
        t1.start();
        t2.start();

    }

    public synchronized void withdrawal() {
        if (money > 0) {
            System.out.println(Thread.currentThread().getName() + "准备取款");
            money -= 500;
            System.out.println(Thread.currentThread().getName() + "取款完成:" + "余额" + money);
        } else {
            System.out.println(Thread.currentThread().getName() + "余额不足:"+ "余额" + money);
        }
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.withdrawal();
        }
    }
}
