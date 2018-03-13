package io;

import java.io.*;

/*
字节流字符流的相互转换
InputStreamReader:按照相应的编码将字节转换成字符
OutputStreamWriter：按照相应的编码将字符编码成字节
 */
public class InputStreamReaderTest {
    public static void main(String[] args) {
        testWrite();
        testReader();
    }

    private static void testReader() {
        File file=new File("myfile.txt");
        InputStreamReader reader=null;
        try {
            char[] buf=new char[30];
            reader=new InputStreamReader(new FileInputStream(file),"gb2312");
            reader.read(buf);
            System.out.println(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
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

    private static void testWrite() {
        File file=new File("myfile.txt");
        OutputStreamWriter out=null;
        FileOutputStream outFile=null;
        try {
            out=new OutputStreamWriter(new FileOutputStream(file),"gb2312");
            outFile=new FileOutputStream(file);
            System.out.println(file.length());
            out.write("床前明月光abcde");
            out.flush();
            System.out.println(file.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
