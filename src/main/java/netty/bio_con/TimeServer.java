package netty.bio_con;

import netty.bio.TimeServerHandle;

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
            TimeServerHandleExecutepool singleExecutepool=new TimeServerHandleExecutepool(50,1000);
            while (true){
                socket=serverSocket.accept();
                System.out.println("the time server is started at port:"+port);
                singleExecutepool.execute(new TimeServerHandle(socket));
                //new Thread(new TimeServerHandle(socket)).start();
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
