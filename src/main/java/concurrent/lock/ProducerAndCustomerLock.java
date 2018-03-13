package concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
生产/消费者问题是个非常典型的多线程问题，涉及到的对象包括“生产者”、“消费者”、“仓库”和“产品”。他们之间的关系如下：
(01) 生产者仅仅在仓储未满时候生产，仓满则停止生产。
(02) 消费者仅仅在仓储有产品时候才能消费，仓空则等待。
(03) 当消费者发现仓储没产品可消费时候会通知生产者生产。
(04) 生产者在生产出可消费产品时候，应该通知等待的消费者去消费。
 */
public class ProducerAndCustomerLock {
    public static void main(String[] args) {
        Depot depot=new Depot(100);
        Producer producer=new Producer(depot);
        Customer customer=new Customer(depot);

        producer.produce(20);
        customer.custom(120);
        producer.produce(60);
        customer.custom(40);
        producer.produce(80);
    }
}

class Depot{
    private int capacity;
    private int size;
    private Lock lock;
    private Condition fullCondition;
    private Condition emptyCondition;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.lock=new ReentrantLock();
        fullCondition=lock.newCondition();
        emptyCondition=lock.newCondition();
    }

    public  void produce(int val) {
        lock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (size >= capacity)
                    fullCondition.await();
                int inc = (size + left) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                // 通知“消费者”可以消费了。
                emptyCondition.signalAll();
            }
        }catch ( InterruptedException e){
        }finally {
            lock.unlock();
        }
    }

    public  void custom(int val){
        lock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (size <= 0)
                    emptyCondition.await();
                int inc = (size - left >= 0) ? left : size;
                size -= inc;
                left -= inc;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                fullCondition.signalAll();
            }
        }catch (InterruptedException e){
        }finally {
            lock.unlock();
        }
    }
}

class Producer{
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(final int val) {
        new Thread(){
            @Override
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}

class Customer{
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    public void custom(final int val) {
        new Thread(){
            @Override
            public void run() {
                depot.custom(val);
            }
        }.start();
    }
}