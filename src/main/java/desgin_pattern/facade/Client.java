package desgin_pattern.facade;
/*
外观模式：为系统中的一组接口提供一个统一的访问界面，此模式定义了一个高层接口使得子系统的访问更加容易使用
 */
public class Client {
    public static void main(String[] args) {
        Facade facade=new Facade();
        facade.buy();
        facade.sell();
    }
}
