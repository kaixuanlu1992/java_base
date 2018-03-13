package desgin_pattern.template;
/*
模板方法模式：定义一个操作中算法的骨架，而将一些步骤延迟到子类中。
作用：使得子类可以不改变一个算法结构就可重新定义一个算法的某些特定步骤
代表具体逻辑步骤的方法称做基本方法(primitive method)；而将这些基本方法汇总起来的方法叫做模板方法
是继承的应用

 */
public class Client {
    public static void main(String[] args) {
        DodishTemplate tomato=new Tomato();
        DodishTemplate bouilli=new Bouilli();
        tomato.template();
        bouilli.template();
    }
}
