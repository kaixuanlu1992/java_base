package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/*
ArrayList:
动态数组，相较于array
内部是array实现
 */
public class ArrayListTest {
    private static List<Integer> list=new ArrayList();

    public static void main(String[] args) {
        testAdd();
        // testFailfast();
        /*
        fail-fast 机制是java集合(Collection)中的一种错误机制。当多个线程对同一个集合的内容进行操作时，就可能会产生fail-fast事件。
        例如：当某一个线程A通过iterator去遍历某集合的过程中，若该集合的内容被其他线程所改变了；那么线程A访问集合时，
        就会抛出ConcurrentModificationException异常，产生fail-fast事件。
         */
        testBasic();
        testToArray();
        /*
        两个转化成数组的方法：
        Object[] toArray()会出现向下转型错误，应该使用下一种
        <T> T[] toArray(T[] contents)
         */

    }

    private static void testToArray() {
        Integer [] text=(Integer[])list.toArray(new Integer[0]);
        //list.toArray(text);
        System.out.println(Arrays.toString(text));
    }

    private static void testBasic() {
        System.out.println(list.get(5)+" "+list.remove(7)+list.contains(2)+list);
    }

    public static void testFailfast(){
        for (int i=0;i<1;i++) {
            testRead2();
            testRead1();
        }
    }
    public static void testAdd(){
        //存储
        for(int i=0;i<10;i++)
            list.add(i);
        System.out.println("list:"+list);
        System.out.println("size:"+list.size());
    }
    public static void  testRead(){
        Iterator it=list.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
    public static void  testRead1(){
        new Thread(){
            @Override
            public void run() {
                Iterator it=list.iterator();
                Integer temp;
                while (it.hasNext()){
                    temp= (Integer) it.next();
                    System.out.print(temp+" ");
                    if (temp%3==0){it.remove();}
                }
            }
        }.start();

    }
    public static void  testRead2(){
        new Thread(){
            @Override
            public void run() {
                Iterator it=list.iterator();
                while (it.hasNext()){
                    System.out.print(it.next()+" ");
                }
            }
        }.start();

    }

}
