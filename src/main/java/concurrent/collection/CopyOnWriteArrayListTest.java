package concurrent.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
JUC集合主要包含三类List和set、map、queue三类
List&&set
1、CopyOnWriteArrayList：相当于线程安全的arraylist

2、CopyOnWriteArraySet：相当于线程安全的hashset
3、ConcurrentSkipListSet
 */
public class CopyOnWriteArrayListTest {
    private static List list=new ArrayList();
    //private static List list=new CopyOnWriteArrayList();

    public static void main(String[] args) {
        Thread t1=new MyThread("t1");
        Thread t2=new MyThread("t2");
        t1.start();
        t2.start();
    }
    private static void printAll(){
        Iterator it= list.iterator();
        while (it.hasNext())
            System.out.print(it.next()+", ");
        System.out.println();
    }
    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName()+"-"+i;
                list.add(val);
                // 通过“Iterator”遍历List。
                printAll();
            }
        }
    }
}
