package desgin_pattern.proxy;
/*
代理对象存在的价值主要用于拦截对真实业务对象的访问
 */
public class Client {
    public static void main(String[] args) {
        proxy();
        dymicProxy();
    }

    private static void dymicProxy() {
        Person target=new LiuDehua();
        Person proxy=new LiuDeHuaDymicProxy().getProxy();
        proxy.sing("冰雨");
        proxy.dance("恰恰");
    }

    private static void proxy() {
        Person target=new LiuDehua();
        Person proxy=new LiuProxy(target);
        proxy.sing("冰雨");
        proxy.dance("恰恰");
    }
}
