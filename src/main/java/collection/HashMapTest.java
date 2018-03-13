package collection;

import java.util.*;

/*
map存储的是键值对的实现类有三种：
hashmap：基于hash表实现，无序的
treemap：基于红黑树实现，有序的【顺序是键值得代销排序】
hashtable：无序的，但是是线程安全的，线程安全通过同步方法实现
 */
public class HashMapTest {
    // private static Map<Integer,String> myMap=new HashMap<Integer,String>();
    private static Map<Integer,String> myMap=new TreeMap<Integer,String>();
    //private static Map<Integer,String> myMap=new Hashtable<Integer,String>();

    public static void main(String[] args) {
       // testHashMapBasic();
        for (int i = 0; i < 10; i++) {
            myMap.put(i, i+"");
        }
        printAll(myMap);
        testConcurrent();//线程安全问题还未测试
    }

    private static void testConcurrent() {
        final Random random=new Random();
        for (int j=0;j<2;j++) {
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        myMap.put(i, random.nextInt(20) + "");
                        printAll(myMap);
                    }
                    try {
                       // sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    private static void testHashMapBasic() {
        Map<Integer,String> map=new HashMap<Integer,String>();
        Map<Integer,String> map1=new TreeMap<Integer,String>();
        Map<Integer,String> map2=new Hashtable<Integer,String>();
        map.put(2,"a");
        map.put(33,"b");//覆盖前面键值对
        map.put(6,"e");
        map.put(7,"f");
        map.put(41,"c");
        map.put(5,"d");
        System.out.println(map.containsKey(2)+" "+map.size()+" ");
        map.remove(5);



        map1.put(2,"a");
        map1.put(33,"b");//覆盖前面键值对
        map1.put(41,"c");
        map1.put(5,"d");
        map1.put(6,"e");
        map1.put(7,"f");

        map2.put(2,"a");
        map2.put(33,"b");//覆盖前面键值对
        map2.put(41,"c");
        map2.put(5,"d");
        map2.put(6,"e");
        map2.put(7,"f");

        printAll2(map);
        printAll1(map1);
        printAll1(map2);

    }

    //遍历1
    private static void printAll(Map map){
        Iterator it=map.keySet().iterator();
        while (it.hasNext()){
            System.out.print(map.get(it.next())+" ");
        }
        System.out.println();

    }

    private static void printAll1(Map map){
        Iterator it=map.entrySet().iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();

    }
    private static void printAll2(Map map){
        Iterator it=map.values().iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();

    }
}
