package netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        int port=20006;
        if (args!=null && args.length!=0){
            port=Integer.parseInt(args[0]);
        }
        Socket socket=null;
        BufferedReader in=null;
        BufferedReader input=null;
        //使用PrintWrite会产生问题
        PrintStream out=null;
        try {
            socket=new Socket("127.0.0.1",port);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            input=new BufferedReader(new InputStreamReader(System.in));
            out=new PrintStream(socket.getOutputStream());
            String str=input.readLine();
            while (str!="bye") {
                out.println(str);
                System.out.println("Send order 2 to Server succeed");
                String resp = in.readLine();
                System.out.println("now is :" + resp);
                str=input.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out!=null){
                out.close();
                out=null;
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket=null;

            }
        }
    }
}
