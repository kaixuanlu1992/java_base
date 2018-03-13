package concurrent;

public class MyThread {
    public static void main(String[] args) {
        Thread t1=new mThread();
        Thread t2=new mThread();
        t1.start();
        t2.start();
    }

}

class mThread extends Thread{
    private int ticket=10;

    @Override
    public void run() {
        for (int i=ticket;i>0;i--){
            ticket--;
            System.out.println(Thread.currentThread()+"ticket:"+ticket);
        }
    }
}
