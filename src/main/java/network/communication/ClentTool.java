package network.communication;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ClentTool {
    private Message message;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ClentTool() {
        message = new Message();
        socket = new Socket();

    }

    public void getConnect() {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 22222);
        try {
            socket.connect(address);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clostConnect() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Message message) {
        try {
            //out.write("123");
            out.write(String.valueOf(message.getrId()) + message.getInfo() + "\n");
            //必须有换行符并刷新缓冲区
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
        String str=null;
        try {
            str=in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  str;
    }
}
