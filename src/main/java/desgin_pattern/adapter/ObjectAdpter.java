package desgin_pattern.adapter;

public class ObjectAdpter implements TargetInterface{
    private Adptee adptee;
    public ObjectAdpter(Adptee adptee){  // 构造方法，接收一个BeAdapted引用作为参数
        this.adptee = adptee;
    }

    @Override
    public void method1() {
        adptee.method1();
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}
