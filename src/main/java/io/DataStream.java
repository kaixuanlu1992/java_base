package io;

import java.io.*;

/*
DataInputStream和DataOutputStream:用来装饰其它输入流，它“允许应用程序以与机器无关方式从底层输入流中读写基本 Java 数据类型”
RandomAccessFile有一样的功能，不过是针对于文件
 */
public class DataStream {
    public static void main(String[] args) {
        testDataOutputStream();
        testDataInputStream();
    }

    private static void testDataOutputStream() {
        DataOutputStream out=null;
        try {
            File file=new File("myfile1.txt");
            if (!file.exists()) file.createNewFile();
            out=new DataOutputStream(new FileOutputStream(file,true));
            out.writeChar('s');
            out.writeBoolean(false);
            out.writeFloat(1.22f);
            out.writeDouble(1.555);
            out.writeInt(123);
            out.writeByte(115);
            out.writeShort(235);
            out.writeLong(12345678945L);
            out.writeUTF("你他妈就是一个傻逼");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testDataInputStream() {
        DataInputStream in=null;
        try {
            in=new DataInputStream(new FileInputStream("myfile1.txt"));
            System.out.println(in.readChar());
            System.out.println(in.readBoolean());
            System.out.println(in.readFloat());
            System.out.println(in.readDouble());
            System.out.println(in.readInt());
            System.out.println(in.readByte());
            System.out.println(in.readShort());
            System.out.println(in.readLong());
            System.out.println(in.readUTF());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
