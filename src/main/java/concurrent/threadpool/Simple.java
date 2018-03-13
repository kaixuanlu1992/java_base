package concurrent.threadpool;

import java.util.concurrent.*;

/*
线程池中的几个关键类与接口：
1、Executor：顶层接口，只有一个executor(Runnable)方法
2、ExecutorService：Executor的子接口，提供额外的方法
3、AbstractExecutorService：为ExecutorService接口的方法提供了默认的实现
4、ThreadPoolExecutor：线程池，继承了AbstractExecutorService
5、Executors：个静态工厂类，
   它通过静态工厂方法返回ExecutorService、ScheduledExecutorService、ThreadFactory 和 Callable 等类的对象。
6、ScheduledExecutorService：继承于于ExecutorService。它相当于提供了"延时"和"周期执行"功能的ExecutorService
7、ScheduledThreadPoolExecutor：继承于ThreadPoolExecutor，并且实现了ScheduledExecutorService接口。
---------------------------------------------------
任务有两种：有返回和无返回

 */
public class Simple {
    public static void main(String[] args) {
        //runnableTest();
        //callableTest();
        testFutureTask();
    }

    private static void testFutureTask() {
        MyTask task=new MyTask();
        ExecutorService threadpool=Executors.newFixedThreadPool(2);
        FutureTask<String> futureTask= new FutureTask<String>(task);
        threadpool.submit(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        threadpool.shutdown();
    }

    private static void runnableTest(){
        ExecutorService threadPool= Executors.newFixedThreadPool(3);
        Thread t1=new MyThread();
        Thread t2=new MyThread();
        Thread t3=new MyThread();
        Thread t4=new MyThread();
        threadPool.execute(t1);
        threadPool.execute(t2);
        threadPool.execute(t3);
        threadPool.execute(t4);

        threadPool.shutdown();
    }

    private static void callableTest() {
        ExecutorService es=Executors.newFixedThreadPool(2);
        MyTask task=new MyTask();
        Future<String> str=es.submit(task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("返回结果是："+str.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();

    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " is running.");
    }
}

class MyTask implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("子线程在进行计算");
        //Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<=100;i++)
            sum += i;
        return sum+"";
    }
}