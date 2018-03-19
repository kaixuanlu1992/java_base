package nio.socket;


public class TimeClient {
    public static void main(String[] args) {
        int port=18887;
        if (args!=null && args.length>0){
            port=Integer.parseInt(args[0]);
        }
        new Thread(new TimeClientHandle("127.0.0.1",port),"TimeClient-001").start();
    }
}
