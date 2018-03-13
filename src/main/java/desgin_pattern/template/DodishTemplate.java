package desgin_pattern.template;

public abstract class DodishTemplate {
    //模板方法
    public void template(){
        preparation();
        ding();
        server();
    }
    //基本方法：分为抽象、具体、钩子三类
    protected abstract void server();

    protected abstract void ding();

    protected abstract void preparation();
    
}
