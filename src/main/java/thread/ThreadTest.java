package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable");
        }
    }

    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "Callable";
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        RunnableTask task = new RunnableTask();
        new Thread(task).start();

        FutureTask<String> ft = new FutureTask<>(new CallerTask());
        new Thread(ft).start();
        try {
            String result = ft.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
