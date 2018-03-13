package desgin_pattern.simplefactory;

/*
简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例
缺点：扩展需要改变工厂类，不符合设计原则
*/
public class SimpleFactory {
    private Moveable moveable;

    public Moveable getInstance(String type){
        if (type.equals("car")){
            return new Car();
        }
        else return new Bike();
    }

}
