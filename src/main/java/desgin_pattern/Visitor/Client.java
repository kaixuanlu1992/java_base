package desgin_pattern.Visitor;
/*
访问者模式：表示一个作用于某对象结构中各元素的操作，可以使我们在不改变各元素类的前提下定义作用这些元素的操作。
作用：数据结构和作用于结构上的操作之间的耦合解脱开
5个角色：
抽象访问者：声明了一个或者多个方法操作，形成所有的具体访问者角色必须实现的接口。
具体访问者：实现抽象访问者接口
抽象节点：声明一个接受操作，接受一个访问者对象作为一个参数
具体节点：实现了抽象节点所规定的接受操作
结构对象：可以遍历结构中的所有元素；如果需要，提供一个高层次的接口让访问者对象可以访问每一个元素；
        如果需要，可以设计成一个复合对象或者一个聚集，如List或Set。
 */
public class Client {
    public static void main(String[] args) {
        Medicine a = new MedicineA("板蓝根", 11.0);
        Medicine b = new MedicineB("感康", 14.3);
        Medicine c = new MedicineB("马应龙", 1483);

        Presciption presciption = new Presciption();
        presciption.addMedicine(a);
        presciption.addMedicine(b);
        presciption.addMedicine(c);

        Visitor charger = new Charger();
        charger.setName("张三");

        Visitor workerOfPharmacy = new WorkerOfPharmacy();
        workerOfPharmacy.setName("李四");

        presciption.accept(charger);
        System.out.println("-------------------------------------");
        presciption.accept(workerOfPharmacy);
    }
}
