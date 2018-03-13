package netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port=20006;
        if (args!=null && args.length!=0){
            port=Integer.parseInt(args[0]);
        }

        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(port);
            Socket socket=null;
            while (true){
                socket=serverSocket.accept();
                System.out.println("the time server is started at port:"+port);
                new Thread(new TimeServerHandle(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                System.out.println("the server is closed");
                serverSocket.close();
            }
        }
    }
}
