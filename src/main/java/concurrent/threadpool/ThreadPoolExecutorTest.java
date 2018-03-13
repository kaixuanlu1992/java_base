package concurrent.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        testBuild1();
    }

    /*
    线程池的创建，主要有七个参数，后两个可选：
    1、核心池、最大池数量、保持存活时间、时间单位[TimeUnit]、阻塞队列、线程工厂、拒绝策略
     */
    private static void testBuild1() {
        BlockingQueue<Runnable> block= new ArrayBlockingQueue<Runnable>(5);
        ExecutorService pool=new ThreadPoolExecutor(2,3,3, TimeUnit.MINUTES,block);
    }

}
