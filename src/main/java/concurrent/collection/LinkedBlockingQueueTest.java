package concurrent.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/*
LinkedBlockingDeque：线程安全的、无界的、阻塞队列
 */
public class LinkedBlockingQueueTest {
    private static BlockingQueue<String> queue=new LinkedBlockingDeque<String>();

    public static void main(String[] args) {
        testBlocking();
    }

    private static void testBlocking() {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                    for (int i=0;i<10;i++){
                        queue.put(Thread.currentThread().getName()+": "+i);
                        System.out.println("left"+queue.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    try {
                        System.out.println(Thread.currentThread().getName()+queue.poll());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
