package io;

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) {
        testBufferedWriter();
        testBufferedReader();
    }

    private static void testBufferedWriter() {
        BufferedWriter writer=null;
        try {
            writer=new BufferedWriter(new FileWriter("myfile.txt",true));
            writer.write("床前明月光，疑似地上霜");
            writer.newLine();
            writer.write("黑嘎地石佛哈速递回复");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testBufferedReader() {
        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new FileReader("myfile.txt"));
            System.out.println((char)reader.read());
            reader.skip(5);
            System.out.println(reader.readLine());
            reader.mark(2);
            reader.skip(6);
            System.out.println(reader.readLine());
            reader.reset();
            System.out.println(reader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
