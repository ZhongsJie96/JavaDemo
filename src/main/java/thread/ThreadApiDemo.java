package thread;

public class ThreadApiDemo implements Runnable {

    public static void main(String[] args) {
        // 获取当前线程对象
        Thread thread = Thread.currentThread();
        // 获取当前线程的名称
        System.out.println(thread.getName());
        // id
        System.out.println(thread.getId());
        // 优先级(0-10) 默认值5
        System.out.println(thread.getPriority());

        System.out.println(thread.getState());
        // 设置线程池的优先级
        thread.setPriority(10);
        System.out.println(thread.getPriority());

        ThreadApiDemo threadApiDemo = new ThreadApiDemo();
        Thread thread1 = new Thread(threadApiDemo);
        System.out.println(thread1.isAlive());
        thread1.start();
        System.out.println(thread1.isAlive());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
