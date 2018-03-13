package concurrent;
/*
join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行
控制线程的执行顺讯：
1、Thread类的join方法：使宿主线程阻塞指定时间或者直到寄生线程执行完毕
2、CountDownLatch类：指定计数器，当计数器清零即取消阻塞
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Threada a=new Threada();
        Thread t1=new Thread(a);
        t1.start();
        //t1.join();
        System.out.println("主线程继续运行");

    }
}

class Threada implements  Runnable{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(i);
        }
    }
}
