package thread.ticket;

public class TicketThread extends Thread{
    private static int ticket = 5;

    @Override
    public void run() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() +"sale " + (ticket--));
        }
    }

    public static void main(String[] args) {
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        TicketThread t3 = new TicketThread();
        TicketThread t4 = new TicketThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
