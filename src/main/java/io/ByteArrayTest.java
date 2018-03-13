package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/*
ByteArrayInputStream,ByteArrayOutputStream读写字节存储在对象内的字节数组上
此外支持标记和按序读取、跳过
 */

public class ByteArrayTest {
    private static byte[] buffer=new byte[40];

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    private static void testWrite() {
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        out.write("kaixuan lukaixuan lukaixuan lukaixuan lukaixuan lu".getBytes(),2,35);
        buffer=out.toByteArray();
        System.out.println(out.size()+" "+new String(buffer));
    }

    private static void testRead() {
        ByteArrayInputStream in=new ByteArrayInputStream(buffer);
        System.out.println((char)in.read());
    }
}
