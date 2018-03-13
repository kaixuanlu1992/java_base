package desgin_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LiuDeHuaDymicProxy {
    private Person ldh = new LiuDehua();

    public Person getProxy(){
        return (Person)Proxy.newProxyInstance(LiuDeHuaDymicProxy.class.getClassLoader(), ldh.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sing")) {
                    System.out.println("我是他的经纪人，要找他唱歌得先给十万块钱！！");
                    return method.invoke(ldh, args);
                }
                if (method.getName().equals("dance")) {
                    System.out.println("我是他的经纪人，要找他唱歌得先给二十万块钱！！");
                    return method.invoke(ldh, args);
                }
                return null;
            }
        });
    }
}
