package concurrent.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/*
ArrayBlockingQueue:数组实现的、线程安全的、有界的[创建时需要指定大小]、阻塞队列、采用FIFO排序
阻塞队列的顶层接口：BlockingQueue
阻塞队列：队列是空的时，从队列中获取元素的操作将会被阻塞，或者当队列是满时，往队列里添加元素的操作会被阻塞。
注意：add、offer、put区别
 */
public class ArrayBlockingQueueTest {
    private static BlockingQueue<String> queue=new ArrayBlockingQueue<String>(5);
    public static void main(String[] args) {
        testCURD();
        //testBlocking();

    }

    private static void testCURD() {
        //add
        queue.add("kaixuan");
        queue.offer("lu");
        //read
        System.out.println(queue.peek()+queue.size());
    }

    private static void testBlocking() {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
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
                        System.out.println(Thread.currentThread().getName()+queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
