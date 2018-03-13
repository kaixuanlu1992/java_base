package concurrent.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
JUC集合主要包含三类List和set、map、queue三类
List&&set
1、CopyOnWriteArrayList：相当于线程安全的arraylist

2、CopyOnWriteArraySet：相当于线程安全的hashset
    迭代器支持hasNext(), next()等不可变操作，但不支持可变 remove()等 操作
3、ConcurrentSkipListSet
 */
public class CopyOnWriteArraySetTest {
    private static Set<String> set = new HashSet<String>();
    //private static Set<String> set = new CopyOnWriteArraySet<String>();
    public static void main(String[] args) {

        // 同时启动两个线程对set进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String value = null;
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            int i = 0;
            while (i++ < 10) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName() + "-" + (i%6);
                set.add(val);
                // 通过“Iterator”遍历set。
                printAll();
            }
        }
    }
}
