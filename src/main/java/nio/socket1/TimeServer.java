package nio.socket1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeServer {
    public static void main(String[] args) {
        int port=18887;
        if (args!=null && args.length>0){
            port=Integer.parseInt(args[0]);
        }
        Acceptor timeServer=new Acceptor(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }

    private static class Acceptor implements Runnable{
        private NioReactorThreadGroup nioReactorThreadGroup;
        private Selector selector;
        private ServerSocketChannel servChannel;
        private ExecutorService threadpool;

        public Acceptor(int port) {
            try {
                nioReactorThreadGroup = new NioReactorThreadGroup();
                selector=Selector.open();
                servChannel=ServerSocketChannel.open();
                servChannel.configureBlocking(false);
                servChannel.socket().bind(new InetSocketAddress(port),1024);
                servChannel.register(selector, SelectionKey.OP_ACCEPT);
                threadpool= Executors.newFixedThreadPool(4);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true){
                try {
                    selector.select(1000);
                    Set<SelectionKey> selectionKeys=selector.selectedKeys();
                    Iterator<SelectionKey> it=selectionKeys.iterator();
                    while (it.hasNext()){
                        SelectionKey key=it.next();
                        it.remove();
                        handleAccept(key);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

        private void handleAccept(SelectionKey key) throws IOException {
            if (key.isValid()){
                if (key.isAcceptable()){
                    ServerSocketChannel ssc= (ServerSocketChannel) key.channel();
                    SocketChannel sc=ssc.accept();
                    sc.configureBlocking(false);
                    NioReactorThread task=new NioReactorThread();
                    task.register(sc);
                    threadpool.execute(task);
                }
            }
        }
    }
}
