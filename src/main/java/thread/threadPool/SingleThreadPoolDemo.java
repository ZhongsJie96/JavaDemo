package thread.threadPool;

import java.util.concurrent.*;

public class SingleThreadPoolDemo {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));

        executor.execute(new Task());
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
