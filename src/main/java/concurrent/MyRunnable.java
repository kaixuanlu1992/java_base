package concurrent;

public class MyRunnable {
    public static void main(String[] args) {
        Runnable m1=new mRunnable();
        Runnable m2=new mRunnable();
        new Thread(m1).start();
        new Thread(m2).start();
    }
}

class mRunnable implements Runnable{
    private int ticket=10;

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"ticket:"+ticket--);
                System.out.println(Thread.currentThread().getPriority());
            }
        }
    }
}