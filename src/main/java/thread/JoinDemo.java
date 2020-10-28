package thread;

public class JoinDemo {
    public static void main(String[] args) {
        RunnableDemo myRunnable = new RunnableDemo();

        Thread thread = new Thread(myRunnable);
        thread.start();


        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);

            if (i == 2) {
                try  {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
