package thread.submit;

import java.util.concurrent.Callable;

public class CallableTask implements Callable {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName() + " running";
    }
}
