package desgin_pattern.adapter;

/*
适配器模式：把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作
两种类型：
1、类适配器：通过继承实现
2、对象适配器:委派关系连接到Adaptee,也就是组合来实现的
 */
public class Client {
    public static void main(String[] args) {
        classAdapter();
        objectAdapter();
        
    }

    private static void objectAdapter() {
        Adptee adptee=new Adptee();
        TargetInterface target=new ObjectAdpter(adptee);
        target.method1();
        target.method2();
    }

    private static void classAdapter() {
        TargetInterface target=new ClassAdpter();
        target.method1();
        target.method2();
    }
}
