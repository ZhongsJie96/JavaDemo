package thread;


public class ThreadTest1 {
    private static volatile Object resourcesA = new Object();
    private static volatile Object resourcesB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourcesA) {
                        System.out.println("threadA get resourceA lock");
                        synchronized (resourcesB) {
                            System.out.println("threadA get resourceB lock");

                            System.out.println("threadA release resourceA lock");
                            resourcesA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (resourcesA) {
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try get resourceB lock...");
                        synchronized (resourcesB) {
                            System.out.println("threadB get resourceB lock");

                            System.out.println("threadB release resourceA lock");
                            resourcesA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();


        threadA.join();
        threadB.join();

        System.out.println("over");



    }
}
