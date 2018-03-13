package network.communication;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        //testTcpClient();
        testTcpClient1();
    }

    private static void testTcpClient1() {
        final ClentTool clentTool=new ClentTool();
        clentTool.getConnect();
        final BufferedReader rec=new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter send=new BufferedWriter(new OutputStreamWriter(System.out));
        new Thread(){
            @Override
            public void run() {
               System.out.println("请输入信息：");
               boolean flag1=true;
               while (flag1){
                   try {
                       String sendMess=rec.readLine();
                       if (rec.equals("bye")) flag1=false;
                       Message message=new Message(123l,sendMess);
                       message.setrId(124l);
                       clentTool.sendMessage(message);
                       System.out.println(sendMess);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                boolean flag=true;
                while (flag){
                    String recMess=clentTool.getMessage();
                    if (rec.equals("bye")) flag=false;
                    if (recMess!=null && recMess!=""){
                        try {
                            send.write(recMess);
                            // send.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

    }

    private static void testTcpClient() {
        Socket client=null;
        try {
            client=new Socket("127.0.0.1",22222);
            client.setSoTimeout(10000);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader buf =  new BufferedReader(new InputStreamReader(client.getInputStream()));

                out.println("1123");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
