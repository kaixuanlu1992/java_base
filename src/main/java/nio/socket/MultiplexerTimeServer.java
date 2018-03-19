package nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel servChannel;
    private volatile boolean stop;

    //初始化
    public MultiplexerTimeServer(int port) {
        try {
            selector=Selector.open();//选择器的初始化
            servChannel=ServerSocketChannel.open();
            servChannel.configureBlocking(false);//channel设置为非阻塞
            servChannel.socket().bind(new InetSocketAddress(port),1024);
            servChannel.register(selector, SelectionKey.OP_ACCEPT);//注册通道
            System.out.println("the timer SERVER is start in port :"+port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        stop=true;
    }

    @Override
    public void run() {
        while (!stop){
            try {
                selector.select(1000);
                //将线程置于睡眠状态，直到这些感兴趣的事情中的操作中的一个发生或者 1 秒钟的时间过去
                Set<SelectionKey> selectionKeys=selector.selectedKeys();//已经准备好的键的集合
                Iterator<SelectionKey> it=selectionKeys.iterator();
                SelectionKey key=null;
                while (it.hasNext()){
                    System.out.println(12);
                    key=it.next();
                    System.out.println(key.isValid());
                    it.remove();//处理完就从已选择键集合删除
                    try {
                        handleInput(key);
                    }catch (Exception e){
                        if (key!=null){
                            key.cancel();
                            if (key.channel()!=null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (selector!=null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()){
            if (key.isAcceptable()){
                ServerSocketChannel ssc=(ServerSocketChannel)key.channel();
                SocketChannel sc=ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector,SelectionKey.OP_READ);//重新注册
            }
            if (key.isReadable()){
                SocketChannel sc= (SocketChannel) key.channel();
                ByteBuffer readBuffer=ByteBuffer.allocate(1024);
                int readBytes=sc.read(readBuffer);
                if (readBytes>0){
                    readBuffer.flip();
                    byte[] bytes=new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body=new String(bytes,"utf-8");
                    System.out.println("the time server receive order:"+body);
                    String currentTime="query time order".equalsIgnoreCase(body)?
                            new Date(System.currentTimeMillis()).toString():"bad order";
                    doWrite(sc,currentTime);
                }else if (readBytes<0){
                    key.cancel();
                    sc.close();
                }else ;
            }
        }
    }

    private void doWrite(SocketChannel sc, String response) throws IOException {
        if (response!=null && response.trim().length()>0){
            byte[] bytes=response.getBytes();
            ByteBuffer writeBuffer=ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            sc.write(writeBuffer);
        }
    }
}
