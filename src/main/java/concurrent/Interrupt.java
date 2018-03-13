package concurrent;
/*
interrupted() 操作的是中断标记，并不是让线程实际中断，可以在run方法中判断中断标记，
然后将线程中断标记设置为true来中断线程。
interrupted()和isInterrupted()都返回中断标记，前者将中断标记置为true，但是当线程处在阻塞状态时，
调用了它的interrupt()方法，那么它的“中断状态”会被清除并且会收到一个InterruptedException异常。

 */
public class Interrupt {
    public static void main(String[] args) {
        Thread b=new Threadb();
        b.start();
        b.interrupt();

    }
}

class Threadb extends Thread{
    @Override
    public void run() {

        if (!isInterrupted()){
            try {
                Thread.sleep(100); // 休眠100ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true){

            }
        }
        System.out.println("中断线程");
    }
}
