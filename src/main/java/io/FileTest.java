package io;

import java.io.*;

/*
BIO文件的读写操作主要涉及几个：
1、FileInputStream/FileOutputSream:写入文件有两种方式，覆盖【清空源文件所有内容】和追加模式，通过构造函数的append参数设置
2、FileReader/FileWriter
3、RandomAccessFile：默认ISO-8859-1编码，一般是按字节读写，使用uft-8编码；支持随机读写通过seek或skipBytes实现
4、File：操作文件本身、而不是文件内容
 */
public class FileTest {
    private static File file;
    private static String str1="today is good and i hava good mood;";
    private static String str2="我是中文，我在这里！！！";

    public static void main(String[] args) throws IOException {
        buildFile();
        testFileStream();
        testFileReader();
        //testRandomFileAccess();
    }

    private static void testRandomFileAccess() {
        RandomAccessFile out;
        RandomAccessFile in;


        try {
            out = new RandomAccessFile(file,"rw");//需要指定操作文件的方式
            System.out.println(out.length());
            //faction.writeBoolean(false);
            out.skipBytes(33);
            out.writeByte(116);
            out.write("中国-湖北-天门\nhello,world".getBytes("utf-8"));

            out.close();

            in = new RandomAccessFile(file,"r");//需要指定操作文件的方式
            byte [] buffer=new byte[30];
            in.seek(4);
            in.read(buffer);

           // System.out.println(in.readByte());
            System.out.println(new String(buffer));
           // System.out.println(in.readLong());
            //System.out.println(in.readFloat());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testFileReader() {
        FileReader in = null;
        FileWriter out=null;
        try {
            in=new FileReader(file);
            char[] ch=new char[20];
            in.read(ch);
            System.out.println(ch);
            System.out.println((char)in.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //write
        try {
            out=new FileWriter(file,true);
            out.write(str1+str2);
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

    private static void buildFile() {
        try {
            if (file==null){
                file=new File("myfile.txt");
                if (file.exists())
                    file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testFileStream() throws FileNotFoundException {
        //write to file
        FileOutputStream out=new FileOutputStream(file,true);
        FileInputStream in=new FileInputStream(file);
        try {
            out.write(str1.getBytes());
            out.write(56);
            out.write("\n".getBytes());
            out.write(str1.getBytes(),5,10);
            out.write("\n".getBytes());
            out.write(str2.getBytes());

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

        //read from file
        try {
            byte[] con=new byte[30];
            con[0]=115;
            System.out.println((char)in.read());
            in.read(con,5,10);
            System.out.println(new String(con));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
