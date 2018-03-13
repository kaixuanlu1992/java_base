package desgin_pattern.strategy;

/*
策略模式：定义一系列的算法,把每一个算法封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
目的：让算法独立于使用它的客户而独立变化

使用场景：
1.针对同一类型问题的多种处理方式，仅仅是具体行为有差别时；
2.需要安全地封装多种同一类型的操作时；
3.出现同一抽象类有多个子类，而又需要使用 if-else 或者 switch-case 来选择具体子类时。

模式涉及到三个角色：
环境(Context)角色：持有一个Strategy的引用。
抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。
 */
/*
实例：假设鹅厂推出了3种会员，分别为会员，超级会员以及金牌会员，还有就是普通玩家，针对不同类别的玩家，
购买《王者农药》皮肤有不同的打折方式，并且一个顾客每消费10000就增加一个级别
 */
public class Client {
    public static void main(String[] args) {
        Context player = new Context();
        player.buy(5000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
    }
}
