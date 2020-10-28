package thread;

import java.util.concurrent.*;

public class CallableDemo implements Callable {
    public static void main(String[] args) {
        FutureTask<Integer> ft = new FutureTask(new CallableDemo());
        Thread thread = new Thread(ft);
        thread.start();
        try {
            if (ft.get() != null) {
                System.out.println(ft.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
