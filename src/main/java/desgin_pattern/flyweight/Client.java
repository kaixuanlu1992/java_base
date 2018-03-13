package desgin_pattern.flyweight;
/*
享元模式:以共享的方式高效地支持大量的细粒度对象。
主要目的：共享对象，避免大量拥有相同内容对象的开销，将事物的共性共享，而又保留它的个性。
为了做到这点，享元模式中区分了内蕴状态和外蕴状态。内蕴状态存储在享元内部，不会随环境的改变而有所不同，是可以共享的；
外蕴状态是不可以共享的，它随环境的改变而改变的，因此外蕴状态是由客户端来保持

3个角色：
抽象享元(Flyweight)角色 ：给出一个抽象接口，以规定出所有具体享元角色需要实现的方法。
具体享元(ConcreteFlyweight)角色：实现抽象享元角色所规定出的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。
享元工厂(FlyweightFactory)角色 ：本角色负责创建和管理享元角色。
 */
public class Client {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory=new FlyweightFactory();
        Flyweight flyweight1=flyweightFactory.getTicket("hu","wuhan");
        flyweight1.showPrice("gaotie");
        Flyweight flyweight2=flyweightFactory.getTicket("hu","wuhan");
        flyweight1.showPrice("gaotie");
        Flyweight flyweight3=flyweightFactory.getTicket("hu1","wuhan");
        flyweight1.showPrice("gaotie");
        System.out.println(flyweight1==flyweight2);
        System.out.println(flyweight1==flyweight3);

    }
}
