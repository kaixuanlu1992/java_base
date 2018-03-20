package ajava_EE.message.thrift.helloworld;

import ajava_EE.message.thrift.iface.HelloWorldService;
import ajava_EE.message.thrift.iface.RESCODE;
import ajava_EE.message.thrift.iface.Reponse;
import ajava_EE.message.thrift.iface.Request;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.TException;


public class HelloWorldServiceImpl implements HelloWorldService.Iface {

    private static final Log LOGGER = LogFactory.getLog(HelloWorldServiceImpl.class);

    @Override
    public Reponse send(Request request) throws TException {
        String json = request.getParamJSON();
        String serviceName = request.getServiceName();
        HelloWorldServiceImpl.LOGGER.info("得到的json：" + json + " ；得到的serviceName: " + serviceName);

        // 构造返回信息
        Reponse response = new Reponse();
        response.setResponeCode(RESCODE._200);
        response.setResponseJSON("{\"user\":\"yinwenjie\"}");
        return response;
    }
}
