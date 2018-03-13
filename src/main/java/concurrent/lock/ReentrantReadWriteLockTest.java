package concurrent.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
“读取锁”支持被多个线程同时获取。
“写入锁”不支持被多个线程同时获取
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        Count myCount = new Count(33, 10000);
        User user = new User("Tommy", myCount);
        for (int i=0; i<6; i++) {
            user.getCash();
            user.setCash((i+1)*1000);
        }

    }
}

class Count{
    private int id;
    private double cash;

    public Count(int id, double cash) {
        this.id = id;
        this.cash = cash;
    }

    public Count() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}

class User{
    private String name;            //用户名
    private Count myCount;        //所要操作的账户
    private ReadWriteLock myLock;   //执行操作所需的锁对象

    public User(String name, Count myCount) {
        this.name = name;
        this.myCount = myCount;
        myLock=new ReentrantReadWriteLock();
    }

    public void getCash(){
        new Thread(){
            @Override
            public void run() {
                try {
                    myLock.readLock().lock();
                    System.out.println(Thread.currentThread().getName() + " getCash start");
                    myCount.getCash();
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " getCash end");
                }catch (InterruptedException e){

                }finally {
                    myLock.readLock().unlock();
                }
            }
        }.start();
    }

    public void setCash(final int cash) {
        new Thread() {
            public void run() {
                myLock.writeLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() +" setCash start");
                    myCount.setCash(cash);
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() +" setCash end");
                } catch (InterruptedException e) {

                } finally {
                    myLock.writeLock().unlock();
                }
            }
        }.start();
    }
}
