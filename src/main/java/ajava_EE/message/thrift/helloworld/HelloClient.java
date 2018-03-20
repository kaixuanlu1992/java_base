package ajava_EE.message.thrift.helloworld;

import ajava_EE.message.thrift.iface.HelloWorldService;
import ajava_EE.message.thrift.iface.Reponse;
import ajava_EE.message.thrift.iface.Request;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

public class HelloClient {
    static {
        BasicConfigurator.configure();
    }
    private static final Log LOGGER = LogFactory.getLog(HelloClient.class);
    public static void main(String[] args) throws TException {
        // 服务器所在的IP和端口
        TSocket transport = new TSocket("127.0.0.1", 9111);
        TProtocol protocol = new TBinaryProtocol(transport);

        // 准备调用参数
        Request request = new Request("{\"param\":\"field1\"}", "\\mySerivce\\queryService");
        HelloWorldService.Client client = new HelloWorldService.Client(protocol);

        // 准备传输
        transport.open();
        // 正式调用接口
        Reponse reponse = client.send(request);
        // 一定要记住关闭
        transport.close();

        HelloClient.LOGGER.info("response = " + reponse);
    }
}
