package desgin_pattern.singleton;

public class Client {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1==singleton2);

        Singleton1 s1=Singleton1.getInstance();
        Singleton1 s2=Singleton1.getInstance();
        System.out.println(s1==s2);
    }
}
