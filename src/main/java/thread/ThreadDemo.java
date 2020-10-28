package thread;

public class ThreadDemo extends Thread {

    public static void main(String[] args) {
        new ThreadDemo().start();

        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
    }
}
