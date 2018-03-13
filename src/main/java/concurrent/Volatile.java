package concurrent;

/*
线程安全的三个特征：原子性、可见性、有序性
volatile：保证可见性和一定程度的有序性
 */
public class Volatile {
    public volatile int inc = 0;

    public  void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Volatile test = new Volatile();
        long t1=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>2)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
        System.out.println(System.currentTimeMillis()-t1);
    }
}
