package io;

import java.io.*;

/*
BufferedInputSteeam:处理流、为其他的输入流提供额外功能，如缓冲、跳过、标记，通过在内部的字节数组[8912]，每次从输入流读取一部分数据
到缓冲区，然后从缓冲区读取数据,读完或是不够就从输入流取数据，用户并不会感到缓冲的存在。
BufferedOutputSteeam:提供缓冲功能，缓冲会对操作产生影响，写入缓冲区未满时，缓冲区的内容并不会输出到输出流，这是需要关闭或flushBufferedOutputSteeam
 */
public class BufferedStream {
    public static void main(String[] args) {
        testBufferedInputStream();
        testBufferedOutputStream();
    }

    private static void testBufferedOutputStream() {
        BufferedOutputStream out=null;
        try {
            out=new BufferedOutputStream(new FileOutputStream("myfile.txt",true));
            out.write("文婷婷，我想你，想的想睡觉".getBytes());
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
               // out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void testBufferedInputStream() {
        BufferedInputStream buffer=null;
        try {
            buffer=new BufferedInputStream(new FileInputStream("myfile.txt"),10);
            byte[] buf=new byte[36];
            buffer.skip(48);
            buffer.read(buf);
            System.out.println(new String(buf,"utf-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
