package concurrent;
/*
wait方法在具体对象上调用，调用前需要获得该对象的锁，调用后当前线程进入阻塞状态，并释放该对象的锁
 */
public class Wait {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread1 start...");
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread1 stop...");
        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread2 start...");
            synchronized (lock) {
                lock.notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 stop...");
            }
        }
    }
}