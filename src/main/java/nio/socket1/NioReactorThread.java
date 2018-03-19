package nio.socket1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class NioReactorThread extends Thread{
    private static final byte[] b = "hello,服务器收到了你的信息。".getBytes(); //服务端给客户端的响应
    private boolean stop;
    private Selector selector;
    private List<SocketChannel> waitRegisterList = new ArrayList<SocketChannel>(512);
    private ReentrantLock lock = new ReentrantLock();


    public NioReactorThread() {
        try {
            this.selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void register(SocketChannel socketChannel) {
        if(socketChannel != null ) {
            try {
                lock.lock();
                waitRegisterList.add(socketChannel);
            } finally {
                lock.unlock();
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
            stop=true;
        }
    }
    private void handler(SelectionKey key) throws IOException {
        if (key.isValid()){
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
    public void run() {
        while(!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys= selector.selectedKeys();
                Iterator<SelectionKey> it=selectionKeys.iterator();
                while (it.hasNext()){
                    SelectionKey key=it.next();
                    it.remove();
                    handler(key);
                }
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }


            //注册事件
            if(!waitRegisterList.isEmpty()) {
                try {
                    lock.lock();
                    Iterator<SocketChannel> it = waitRegisterList.iterator();
                    while (it.hasNext()) {
                        SocketChannel sc = it.next();
                        sc.register(selector, SelectionKey.OP_READ);
                        it.remove();
                    }
                } catch (ClosedChannelException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }


        }
    }
}
