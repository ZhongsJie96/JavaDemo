package exercise;

/**
 * sleep轮转需要保证具有时间差
 */
public class ThreadDemo1 implements Runnable {


    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        Thread t1 = new Thread(threadDemo1);
        t1.start();
        for (int i = 10; i >= 0; i--) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            try {
                Thread.sleep(1050);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
