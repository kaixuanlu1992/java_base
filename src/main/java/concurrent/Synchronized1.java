package concurrent;
/*
同步方法的几条规则：
当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块。
当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 */
public class Synchronized1 {
    public static void main(String[] args) {
        final Count count=new Count();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                count.nonsynMethod();
            }
        }, "t1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                count.synMethod();
            }
        }, "t2");


        t1.start();
        t2.start();
    }

}


class Count{
    private int num=5;

    public  static synchronized void synMethod(){
        try {
            for (int i = 5; i > 0; i--) {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void nonsynMethod(){
        try {
            for (int i = 5; i > 0; i--) {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
