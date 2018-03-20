package ajava_EE.message.thrift.helloworld;

import ajava_EE.message.thrift.iface.HelloWorldService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

import java.nio.channels.Selector;
import java.util.concurrent.Executors;

public class NIOHelloSevrer {
    static {
        BasicConfigurator.configure();
    }

    private static Log LOGGER = LogFactory.getLog(NIOHelloSevrer.class);
    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            NIOHelloSevrer.LOGGER.info("NIO HelloWorld TSimpleServer start ....");

            // 服务执行控制器（告诉apache thrift，实现了HelloWorldService.Iface接口的是具体的哪一个类）
            TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());

            // 非阻塞异步通讯模型（服务器端）绑定端口
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(NIOHelloSevrer.SERVER_PORT);
            serverTransport.registerSelector(Selector.open());

            THsHaServer.Args tArgs = new THsHaServer.Args(serverTransport);
            tArgs.processor(tprocessor);
            // 指定消息的封装格式（采用二进制流封装）
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            // 指定处理器的所使用的线程池。
            tArgs.executorService(Executors.newFixedThreadPool(100));

            // 启动服务
            THsHaServer server = new THsHaServer(tArgs);
            server.serve();
        } catch (Exception e) {
            NIOHelloSevrer.LOGGER.error(e);
        }

    }
    public static void main(String[] args) {
        NIOHelloSevrer server = new NIOHelloSevrer();
        server.startServer();
    }
}
