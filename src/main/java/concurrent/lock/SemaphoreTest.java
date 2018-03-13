package concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源。
Semaphore可以用于做流量控制，特别公用资源有限的应用场景，比如数据库连接
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore se=new Semaphore(15);
        ExecutorService threadPool= Executors.newFixedThreadPool(3);
        MyThreada myThreada=new MyThreada(se,6);
        MyThreada myThreada1=new MyThreada(se,6);
        MyThreada myThreada2=new MyThreada(se,10);
        threadPool.execute(myThreada);
        threadPool.execute(myThreada1);
        threadPool.execute(myThreada2);

    }
}

class MyThreada extends Thread{
    private Semaphore se;
    private int count;        // 申请信号量的大小

    public MyThreada(Semaphore se,int count){
        this.count=count;
        this.se=se;
    }
    @Override
    public void run() {
        try {
            se.acquire(count);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " acquire count="+count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            se.release(count);
            System.out.println(Thread.currentThread().getName() + " release " + count + "");
        }

    }
}
