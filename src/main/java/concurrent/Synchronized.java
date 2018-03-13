package concurrent;

public class Synchronized {
    public static void main(String[] args) {
        /*
        此时t1、t2访问的是不同对象的同步锁，相互之间不会有影响
        Thread t1=new Thread(new mThread1(),"t1");
        Thread t2=new Thread(new mThread1(),"t2");
         */
        //此时访问的是同一对象的同步锁，会阻塞另一个线程
        Runnable demo=new mThread1();
        Thread t1=new Thread(demo,"t1");
        Thread t2=new Thread(demo,"t2");


        t1.start();
        t2.start();
    }

}

class mThread1 implements Runnable{
    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 5; i > 0; i--) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

