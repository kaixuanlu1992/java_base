package concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/*
相比同步锁，JUC里的锁功能更加强大，操作更加灵活
 */
public class LockTest {
    public  int inc = 0;
    public static ReentrantLock lock=new ReentrantLock(true);

    public  void increase() {
        inc++;
    }


    public static void main(String[] args) {
        final LockTest test = new LockTest();
        long t1=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    lock.lock();
                    System.out.println(lock.getQueueLength());
                    for(int j=0;j<1000;j++)
                        test.increase();
                    lock.unlock();
                };
            }.start();
        }

        while(Thread.activeCount()>2)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
        System.out.println(System.currentTimeMillis()-t1);
    }
}
