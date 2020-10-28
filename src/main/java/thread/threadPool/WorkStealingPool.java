package thread.threadPool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool(4);

        for (int i = 0; i < 10; i++) {
            System.out.println("submit");
            final int count = i;
            executorService.submit(() -> {
                Date now = new Date();
                System.out.println(Thread.currentThread().getName() + " " + count + " " + now.getSeconds());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        executorService.shutdown();
    }
}
