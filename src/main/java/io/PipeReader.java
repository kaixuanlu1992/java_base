package io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/*
PipeInputStream和PipeOuputStream用于线程间通信，通信前需要建立管道的连接
通过在PipeInputStream保存一个字节数组[1024]，PipeOuputStream在该数组写入数据，PipeInputStream在数组上读取数据实现线程间通信
管道的缓冲区大小有限，可以写入超过缓冲区大小的数据，但是需要多次读取
 */
public class PipeReader {
    public static void main(String[] args) {
        SenderR sender=new SenderR();
        ReceiverR receiver=new ReceiverR();
        PipedWriter out=sender.getOutputStream();
        PipedReader in=receiver.getInputStream();
        try {
            out.connect(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sender.start();
        receiver.start();
    }
}

class SenderR extends Thread{
    private PipedWriter outputStream;

    public PipedWriter getOutputStream() {
        return outputStream;
    }

    public SenderR() {
        this.outputStream = new PipedWriter();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            outputStream.write("hello pipe!!床前明月光");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

class ReceiverR extends Thread{
    private PipedReader inputStream;

    public PipedReader getInputStream() {
        return inputStream;
    }

    public ReceiverR() {
        inputStream=new PipedReader();
    }

    @Override
    public void run() {
        try {
            char[] bufer=new char[30];
            inputStream.read(bufer);
            System.out.println(new String(bufer)+"buffer size"+new String(bufer).indexOf('光'));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
