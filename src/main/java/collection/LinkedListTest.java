package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
内部使用链表实现，修改效率高，随机访问效率低
 */
public class LinkedListTest {
    private static List list=new LinkedList();

    public static void main(String[] args) {
        testCURD();
        // 将LinkedList当作 LIFO(后进先出)的堆栈
        useLinkedListAsLIFO();

        // 将LinkedList当作 FIFO(先进先出)的队列
        useLinkedListAsFIFO();
    }

    private static void useLinkedListAsFIFO() {
        System.out.println("\nuseLinkedListAsFIFO");
        // 新建一个LinkedList
        LinkedList queue = new LinkedList();

        // 将10,20,30,40添加到队列。每次都是插入到末尾
        queue.add("10");
        queue.add("20");
        queue.add("30");
        queue.add("40");
        // 打印“队列”
        System.out.println("queue:"+queue);
        // 删除(队列的第一个元素)
        System.out.println("queue.remove():"+queue.remove());
        // 读取(队列的第一个元素)
        System.out.println("queue.element():"+queue.element());
        // 打印“队列”
        System.out.println("queue:"+queue);
    }

    private static void useLinkedListAsLIFO() {
        System.out.println("\nuseLinkedListAsLIFO");
        // 新建一个LinkedList
        LinkedList stack = new LinkedList();

        // 将1,2,3,4添加到堆栈中
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        // 打印“栈”
        System.out.println("stack:"+stack);
        // 删除“栈顶元素”
        System.out.println("stack.pop():"+stack.pop());
        // 取出“栈顶元素”
        System.out.println("stack.peek():"+stack.peek());
        // 打印“栈”
        System.out.println("stack:"+stack);
        
    }

    public static void  testCURD(){
        //添加元素
        list.add("kai");
        list.add("xuan");
        list.add("lu");

        printAll(list);

        //包含元素
        System.out.println(list.contains("kai"));
        //获取元素
        System.out.println(list.get(2));
        //修改元素
       list.remove(2);
       list.add(2,"LU");
       printAll(list);
       
    }

    private static void printAll(List list){
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
    }
}
