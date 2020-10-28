package thread.ticket;

/**
 * @author zhong
 * <p>
 *     同步代码块实现同步
 */
public class TicketRunnableSyn implements Runnable {

    // 使用static来实现共享变量
    private static int ticket = 5;

    public static void main(String[] args) {
        Runnable runnable = new TicketRunnableSyn();
        Thread t1 = new Thread(runnable, "A");
        Thread t2 = new Thread(runnable, "B");
        Thread t3 = new Thread(runnable, "C");
        Thread t4 = new Thread(runnable, "D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    @Override
    public void run() {
        synchronized (this) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " sale " + (ticket--));
            }
        }
    }
}
