package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
set是利用map实现的分为两种：不允许重复
hashset：无序的
treemap：有序的

 */
public class SetTest {
    public static void main(String[] args) {
        testBasic();
    }

    private static void testBasic() {
        Set hs=new HashSet();
        Set ts=new TreeSet();

        hs.add("kai");
        hs.add("ka");
        hs.add("xuan");
        hs.add("lu");

        ts.add("ai");
        ts.add("kai");
        ts.add("xuan");
        ts.add("lu");
        System.out.println(ts.size());
        ts.remove("kai");
        System.out.println(ts.size());

        printAll(hs);
        printAll(ts);

    }
    private static void printAll(Set set){
        Iterator it=set.iterator();
        while (it.hasNext())
            System.out.print(it.next()+" ");
        System.out.println();
    }

}
