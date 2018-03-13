package desgin_pattern.decorator;
/*
装饰模式：动态的将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee=new CommonCoffee();
        Coffee milk=new MilkDecorator(coffee);
        Coffee suger1=new SugerDecorator(milk);
        Coffee suger=new SugerDecorator(suger1);
        System.out.println(suger.getPrice());
        System.out.println(suger.getName());
    }
}
