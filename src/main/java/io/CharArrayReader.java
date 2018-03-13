package io;

import java.io.CharArrayWriter;
import java.io.IOException;

/*
字符的读写
 */
public class CharArrayReader {
    private static final char[] ArrayLetters = new char[] {'a','b','c','d','e','f',
            'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static void main(String[] args) {
        testCharArrayWriter();
        testCharArrayReader();
    }

    private static void testCharArrayWriter() {
        CharArrayWriter out=null;
        out=new CharArrayWriter();
        char[] buffer=new char[30];
        try {
            out.write("哈哈");
            out.append("床前v明余光");
            buffer=out.toCharArray();
            System.out.println(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    private static void testCharArrayReader() {
        java.io.CharArrayReader in = null;
        char[] buffer=new char[]{'\u4f60','d','1','他'};
       // buffer[0]= '你';
        try {
            in=new java.io.CharArrayReader(buffer);
            System.out.println((char)in.read());
            in.read();
            in.mark(1);
            System.out.println((char)in.read());
            System.out.println((char)in.read());
            in.reset();
            System.out.println((char)in.read());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            in.close();
        }
    }
}
