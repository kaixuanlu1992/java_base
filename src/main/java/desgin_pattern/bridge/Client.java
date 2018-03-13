package desgin_pattern.bridge;
/*
桥梁模式：将抽象部分与他的实现部分分离，使他们都可以独立的变化
桥梁：指的是抽象与实现是聚合关系
在软件系统中，某些类型由于自身的逻辑，它具有两个或多个维度的变化，桥梁模式就是处理这些维度的变化
抽象化：将对象的共同性质抽取出来形成类的过程即为抽象化的过程。
实现化：针对抽象化给出的具体实现，就是实现化，抽象化与实现化是一对互逆的概念
应用场景：聚合【部分整体】，多个维度【多个部分】
4个角色：
抽象化角色：抽象化给出的定义，并保存一个对实现化对象的引用。
修正抽象化(角色：扩展抽象化角色，改变和修正父类对抽象化的定义。
实现化角色：这个角色给出实现化角色的接口，但不给出具体的实现。
具体实现化角色：这个角色给出实现化角色接口的具体实现。
 */
public class Client {
    public static void main(String[] args) {
        MessageImplementor mImpl1=new MessageEmail();
        MessageImplementor mImpl2=new MessageSMS();

        AbstractMessage abstractMessage1=new CommonMessage(mImpl1);
        AbstractMessage abstractMessage2=new UrgencyMessage(mImpl1);
        AbstractMessage abstractMessage3=new CommonMessage(mImpl2);
        AbstractMessage abstractMessage4=new UrgencyMessage(mImpl2);

        abstractMessage1.sendMessage("加班申请速批","李总");
        abstractMessage2.sendMessage("加班申请速批","李总");
        abstractMessage3.sendMessage("加班申请速批","李总");
        abstractMessage4.sendMessage("加班申请速批","李总");
    }
}
