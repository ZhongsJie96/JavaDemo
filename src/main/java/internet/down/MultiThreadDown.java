package internet.down;

public class MultiThreadDown {

    public static void main(String[] args) throws Exception {

        final DownUtil downUtil = new DownUtil("https://www.baidu.com/"
                + "img/", "PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png", 4);
        downUtil.download();
        new Thread(()->{
            System.out.println("running");
            while (downUtil.getCompleteRate() < 1) {
                System.out.println(downUtil.getCompleteRate());

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
