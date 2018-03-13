package netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TimeServerHandle implements Runnable {

    private Socket socket;

    public TimeServerHandle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in=null;
        BufferedReader input=null;
        PrintStream out=null;
        try {
            in=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            input=new BufferedReader(new InputStreamReader(System.in));
            out=new PrintStream(this.socket.getOutputStream(),true);

            String body=null;
            while (true){
                body=in.readLine();
                if (body==null) break;
                System.out.println("the time server receive order :"+body);
                String str=input.readLine();
                out.println(str);

            }
        } catch (Exception e) {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out!=null){
                out.close();
                out=null;
            }
            if (this.socket!=null){
                try {
                    this.socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.socket=null;
            }
            e.printStackTrace();
        }

    }
}
