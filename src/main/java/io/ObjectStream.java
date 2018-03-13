package io;

import java.io.*;

/*
该流是一种处理流，用于对象的序列化,可以用于对象和基本数据的持久存储，存储的位置是其他的流，需要用节点流初始化他
 */
public class ObjectStream{

    public static void main(String[] args) {
        //testWrite();
        testReader();
    }

    private static void testReader() {
        FileInputStream inputStream=null;
        ObjectInputStream in=null;

        try {
            inputStream=new FileInputStream("object.txt");
            in=new ObjectInputStream(inputStream);
            Student stu= (Student) in.readObject();
            System.out.println(stu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {

        }
    }

    private static void testWrite() {
        Student stu=new Student("kaixaun",2014);
        FileOutputStream outputStream=null;
        ObjectOutputStream out=null;
        File file=new File("object.txt");

        try {
            file.createNewFile();
            outputStream=new FileOutputStream(file);
            out=new ObjectOutputStream(outputStream);
            out.writeObject(stu);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//被序列化的对象需要实现序列化接口
class Student implements Serializable{
    private static final long serialVersionUID=123456789L;
    /*
    Java的序列化机制是通过判断类的serialVersionUID来验证版本一致性的。
    在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较，
    如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常，即是InvalidCastException。
     */

    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
