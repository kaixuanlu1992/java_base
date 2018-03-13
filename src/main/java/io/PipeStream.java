package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/*
PipeInputStream和PipeOuputStream用于线程间通信，通信前需要建立管道的连接
通过在PipeInputStream保存一个字节数组[1024]，PipeOuputStream在该数组写入数据，PipeInputStream在数组上读取数据实现线程间通信
管道的缓冲区大小有限，可以写入超过缓冲区大小的数据，但是需要多次读取
 */
public class PipeStream {
    public static void main(String[] args) {
        Sender sender=new Sender();
        Receiver receiver=new Receiver();
        PipedOutputStream out=sender.getOutputStream();
        PipedInputStream in=receiver.getInputStream();
        try {
            out.connect(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sender.start();
        receiver.start();
    }
}

class Sender extends Thread{
    private PipedOutputStream outputStream;

    public PipedOutputStream getOutputStream() {
        return outputStream;
    }

    public Sender() {
        this.outputStream = new PipedOutputStream();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            outputStream.write("hello pipe".getBytes());
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

class Receiver extends Thread{
    private PipedInputStream inputStream;

    public PipedInputStream getInputStream() {
        return inputStream;
    }

    public Receiver() {
        inputStream=new PipedInputStream();
    }

    @Override
    public void run() {
        try {

            byte[] bufer=new byte[30];
            inputStream.read(bufer);
            System.out.println(new String(bufer));
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
