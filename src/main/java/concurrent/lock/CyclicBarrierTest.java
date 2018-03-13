package concurrent.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
CyclicBarrier主要有两个功能，通过两个构造函数实现：
1、CyclicBarrier(int)N个线程相互等待直到所有线程到达屏障
2、CyclicBarrier(int，Runnable)N个线程相互等待直到所有线程到达屏障，并触发某个线程
CyclicBarrier可以用于多线程计算数据，最后合并计算结果的应用场景。
 */
public class CyclicBarrierTest {
    private static int SIZE = 5;
    private static CyclicBarrier cb;
    public static void main(String[] args) {

        cb = new CyclicBarrier(SIZE);

        // 新建5个任务
        for(int i=0; i<SIZE; i++)
            new InnerThread().start();
    }

    static class InnerThread extends Thread{
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "wait for CyclicBarrier.");

                // 将cb的参与者数量加1
                cb.await();
                //告诉屏障该线程已经到达，并阻塞该线程

                // cb的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
