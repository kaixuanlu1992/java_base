package concurrent.threadpool;

import java.util.concurrent.*;

public class FutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool= Executors.newFixedThreadPool(2);
        Task task = new Task();
        Future<Integer> result = pool.submit(task);
        pool.shutdown();
        System.out.println(result.get());

    }
}
class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        int a=0;
        int i=0;
        while (i<=100){
            a=a+i;
            i++;
        }
        return a;
    }
}
