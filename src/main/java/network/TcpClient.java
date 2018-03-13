package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TcpClient {
    public static void main(String[] args) {
        testTcpClient();
    }

    private static void testTcpClient() {
        Socket client=null;
        try {
            client=new Socket("127.0.0.1",2018);
            client.setSoTimeout(10000);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader buf =  new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag=true;
            while (flag){
                System.out.print("输入信息：");
                String str = in.readLine();
                out.println(str);
                if("bye".equals(str)){
                    flag = false;
                }else{
                    try{
                        //从服务器端接收数据有个时间限制（系统自设，也可以自己设置），超过了这个时间，便会抛出该异常
                        String echo = buf.readLine();
                        System.out.println(echo);
                    }catch(SocketTimeoutException e){
                        System.out.println("Time out, No response");
                    }
                }
            }
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
