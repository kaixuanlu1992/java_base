package concurrent;
/*
生产/消费者问题
Condition与lock绑定，强大的地方在于：能够更加精细的控制多线程的休眠与唤醒。对于同一个锁，
可以创建多个Condition，在不同的情况下使用不同的Condition。
 */
public class ProducerAndCustomer {
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

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void produce(int val){
        try {
            int left=val;
            while (left>0){
                while (size>=capacity)
                   wait();
                int inc = (size+left)>capacity ? (capacity-size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                // 通知“消费者”可以消费了。
                notifyAll();
             }
        }catch (InterruptedException e){

        }

    }

    public synchronized void custom(int val){
        try {
            int left=val;
            while (left>0){
                while (size<=0)
                    wait();
                int inc=(size-left>=0)?left:size;
                size-=inc;
                left-=inc;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                notifyAll();
             }

        } catch (InterruptedException e) {
            e.printStackTrace();
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