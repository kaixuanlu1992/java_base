package network;

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
public class TcpServer {
    public static void main(String[] args) {
        testCommonSercer();
    }

    private static void testCommonSercer() {
        ServerSocket server=null;
        try {
            server=new ServerSocket(2018);//绑定端口
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
            while(flag){
                String str =  in.readLine();
                if(str == null || "".equals(str)){
                    flag = false;
                }else{
                    if("bye".equals(str)){
                        flag = false;
                    }else{
                        //将接收到的字符串前面加上echo，发送到对应的客户端
                        out.println("echo:" + str);
                    }
                }
            }
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

