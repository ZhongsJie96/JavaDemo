package thread;

public class YieldDemo {
    public static void main(String[] args) {


        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);

        thread.start();

        for (int i = 0; i < 5; i++) {

            if (i == 2) {
                // 暂停当前线程
                Thread.yield();
                System.out.println("礼让一次");
            } else {
                System.out.println(Thread.currentThread().getName() + "----" + i);
            }

        }
    }
}
