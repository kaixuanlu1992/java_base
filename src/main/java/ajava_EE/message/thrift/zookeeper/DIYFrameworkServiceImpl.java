//package ajava_EE.message.thrift.zookeeper;
//
//import ajava_EE.message.thrift.zoo.DIYFrameworkService;
//import ajava_EE.message.thrift.zoo.Reponse;
//import ajava_EE.message.thrift.zoo.Request;
//import ajava_EE.message.thrift.zoo.ServiceException;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.thrift.TException;
//import org.json.simple.JSONObject;
//
//import java.nio.ByteBuffer;
//
//public class DIYFrameworkServiceImpl implements DIYFrameworkService.Iface {
//    private static final Log LOGGER=LogFactory.getLog(DIYFrameworkServiceImpl.class);
//
//    //接口泛化，即这个接口不调用具体的业务，而只给出调用者需要调用的接口名称（包括参数）
//    @Override
//    public Reponse send(Request request) throws ServiceException, TException {
//
//        String serviceName = request.getServiceName();
//        String className = BusinessServicesMapping.SERVICES_MAPPING.get(serviceName);
//        //未发现服务
//        if(StringUtils.isEmpty(className)) {
//            return this.buildErrorReponse("无效的服务" , null);
//        }
//
//        //2、===================
//        // 首先得到以json为描述格式的请求参数信息
//        JSONObject paramJSON = null;
//        try {
//            byte [] paramJSON_bytes = request.getParamJSON();
//            if(paramJSON_bytes != null && paramJSON_bytes.length > 0) {
//                String paramJSON_string = new String(paramJSON_bytes);
//                paramJSON = JSONObject.fromObject(paramJSON_string);
//            }
//        } catch(Exception e) {
//            DIYFrameworkServiceImpl.LOGGER.error(e);
//            // 向调用者抛出异常
//            throw new ServiceException(EXCCODE.PARAMNOTFOUND, e.getMessage());
//        }
//
//        // 试图进行反射
//        BusinessService<AbstractPojo> businessServiceInstance = null;
//        try {
//            businessServiceInstance = (BusinessService<AbstractPojo>)Class.forName(className).newInstance();
//        } catch (Exception e) {
//            DIYFrameworkServiceImpl.LOGGER.error(e);
//            // 向调用者抛出异常
//            throw new ServiceException(EXCCODE.SERVICENOTFOUND, e.getMessage());
//        }
//
//        // 进行调用
//        AbstractPojo returnPojo = null;
//        try {
//            returnPojo = businessServiceInstance.handle(paramJSON);
//        } catch (BizException e) {
//            DIYFrameworkServiceImpl.LOGGER.error(e);
//            return this.buildErrorReponse(e.getMessage() , e.getResponseCode());
//        }
//
//        // 构造处理成功情况下的返回信息
//        BusinessResponsePojo responsePojo = new BusinessResponsePojo();
//        responsePojo.setData(returnPojo);
//        DescPojo descPojo = new DescPojo("", ResponseCode._200);
//        responsePojo.setDesc(descPojo);
//
//        // 生成json
//        String returnString = JSONUtils.toString(responsePojo);
//        byte[] returnBytes = returnString.getBytes();
//        ByteBuffer returnByteBuffer = ByteBuffer.allocate(returnBytes.length);
//        returnByteBuffer.put(returnBytes);
//        returnByteBuffer.flip();
//
//        // 构造response
//        Reponse reponse = new Reponse(RESCODE._200, returnByteBuffer);
//        return reponse;
//    }
//}
