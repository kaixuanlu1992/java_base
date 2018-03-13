package desgin_pattern.mediator;
/*
中介者模式：用一个中介对象来封装一些列的对象交互
作用 ：可使对象不需要显示的相互调用，降低系统耦合性，同时也可以独立的改变对象之间的交互方式
4个角色：
1、抽象中介者：定义同事到中介者的接口
2、具体中介者：实现抽象中介者对象，需要知道所有具体同事类，并从具体同事类接收消息，向具体同事对象发送消息
3、抽象同事者：
4、具体同事类：具体的同事类，实现自己的业务，需要与其他同事通信时候，就与持有的中介者通信，中介者会负责与其他同事类交互
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        // 定义具体同事类
        ColleagueA colleagueA = new ColleagueA("张三", mediator);
        ColleagueB colleagueB = new ColleagueB("李四", mediator);
        // 中介者知晓每一个具体的Colleague类
        mediator.setCollA(colleagueA);
        mediator.setCollB(colleagueB);
        colleagueA.contact("我是A，我要和同事B说说工作的事情");
        colleagueB.contact("我是B,我下午有时间,下午商量吧");
    }
}
