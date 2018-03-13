package io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
printstream：处理流，为其他输出提供额外的功能,使它们能够方便地使用print或是println打印各种数据值表示形式
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        testPrintStream();
    }

    private static void testPrintStream() {
        PrintStream out=null;
        try {
            out=new PrintStream("myfile.txt");
            out.print(1.123123);
            out.println(true);
            out.println("你他妈个傻逼");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            out.close();//不会抛出 IOException
        }
    }
}
