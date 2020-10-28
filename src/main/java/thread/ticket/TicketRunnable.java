package thread.ticket;

/**
 * @author zhong
 *
 * 使用接口的方式，每次只创建一个共享变量，所有线程共享同一变量
 *      数据一致性问题
 */
public class TicketRunnable implements Runnable{
    private static int ticket = 5;

    @Override
    public void run() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() +" sale " + (ticket--));
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new TicketRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
