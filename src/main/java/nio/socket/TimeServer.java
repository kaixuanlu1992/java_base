package nio.socket;

public class TimeServer {
    public static void main(String[] args) {
        int port=18888;
        if (args!=null && args.length>0){
            port=Integer.parseInt(args[0]);
        }
        MultiplexerTimeServer timeServer=new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
