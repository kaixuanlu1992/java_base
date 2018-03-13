package network.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
套接字位于应用层与传输层之间，可以选择传输协议，设置部分参数，主要API有：
ServerSocket
Socket
DatagramSocket
InetAddress
 */
public class Server {
    public static void main(String[] args) {
        testCommonSercer();
    }

    private static void testCommonSercer() {
        ServerSocket server=null;
        try {
            server=new ServerSocket(22222);//绑定端口
            Socket socket=null;
            while (true){
                socket=server.accept();
                new Handle(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Handle extends Thread{
    private Socket socket;

    public Handle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintStream out=null;
        BufferedReader in=null;
        try {
            out=new PrintStream(socket.getOutputStream());
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean flag =true;
            String str =  in.readLine();
              //只有遇到回车(\r)或者换行符(\n)才会返回读取结果
            out.println("echo:" + str);
            System.out.println(str);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

