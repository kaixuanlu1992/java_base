package concurrent.lock;

import java.util.concurrent.CountDownLatch;

/*
允许1或N个线程等待其他线程完成执行
 */
public class CountDownLatchTest {
    private static int SIZE=5;

    private static CountDownLatch doneSignal;

    public static void main(String[] args) {
        try {
            doneSignal = new CountDownLatch(SIZE-3);
            //初始化count数目的同步计数器，只有当同步计数器为0，主线程才会向下执行

            // 新建5个任务
            for(int i=0; i<SIZE; i++)
                new InnerThread().start();

            System.out.println("main await begin.");
            // "主线程"等待线程池中5个任务的完成
            doneSignal.await();////当前线程等待计数器为0

            System.out.println("main await finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class InnerThread extends Thread{
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
