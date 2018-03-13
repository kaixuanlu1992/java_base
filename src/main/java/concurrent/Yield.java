package concurrent;

/*
sleep:运行状态进入阻塞状态，不会释放锁，指定时间后进入就绪状态
wait:运行状态进入阻塞状态，会释放锁
yield:运行状态进入就绪状态，不会释放锁，重新与其他线程争夺CPU执行权
 */
public class Yield {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
        new Thread(new Thread3()).start();
    }

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread1 start...");

                try {
                    Thread.yield();
                    System.out.println("Thread1 before...");

                    System.out.println("Thread1 after...");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            System.out.println("Thread1 stop...");
        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread2 start...");


                System.out.println("Thread2 stop...");

        }
    }
    static class Thread3 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread3 start...");


                System.out.println("Thread3 stop...");

        }
    }
}
