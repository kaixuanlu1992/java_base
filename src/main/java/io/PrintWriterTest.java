package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/*
PrintStream 用于向文本输出流打印对象的格式化表示形式。
 */
public class PrintWriterTest {
    public static void main(String[] args) {
        testPrintWriterConstrutor1() ;

        // 测试write(), print(), println(), printf()等接口。
        testPrintWriterAPIS() ;
    }

    private static void testPrintWriterConstrutor1() {
        final char[] arr={'a', 'b', 'c', 'd', 'e' };
        try {
            File file = new File("myfile.txt");
            PrintWriter out = new PrintWriter(new FileOutputStream(file));

            out.write(arr);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testPrintWriterAPIS() {
        final char[] arr={'a', 'b', 'c', 'd', 'e' };
        try {
            PrintWriter out = new PrintWriter("other.txt");

            out.println("hello PrintWriter");
            out.write(0x41);
            out.print(0x41);
            out.append('B').append("CDEF");

            String str = "GHI";
            int num = 5;
            out.printf("%s is %d\n", str, num);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
