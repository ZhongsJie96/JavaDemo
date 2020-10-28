package thread;

public class RunnableDemo implements Runnable {

    public static void main(String[] args) {
        Runnable runnable = new RunnableDemo();
        Thread thread = new Thread(runnable);

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
