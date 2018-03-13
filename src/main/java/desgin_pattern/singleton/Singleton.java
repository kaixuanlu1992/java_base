package desgin_pattern.singleton;
//懒汉式单例模式，会有线程安全问题
public class Singleton {
    private static Singleton singleton;

    private Singleton(){ }

    public static Singleton getInstance(){
        if (singleton==null){
            return singleton=new Singleton();
        }
        return singleton;
    }
}
