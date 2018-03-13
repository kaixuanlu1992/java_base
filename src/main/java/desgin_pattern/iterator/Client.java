package desgin_pattern.iterator;
/*
迭代器模式：提供一个方法顺序地访问一个聚集中的元素，而不必暴露聚集的内部表象
主要是一种思想，实际应用价值比较低，因为迭代器已经被坐在语言中了
4个角色：
抽象聚集：给出创建迭代子(Iterator)对象的接口
具体聚集：实现了创建迭代子(Iterator)对象的接口，返回一个合适的具体迭代子实例
抽象迭代器：定义出遍历元素所需的接口
具体迭代器：角色实现了Iterator接口，并保持迭代过程中的游标位置
 */
public class Client {
    public static void main(String[] args) {
        Object[] objArray = {"One","Two","Three","Four","Five","Six"};
        Aggregate aggregate=new ConcreteAggregate(objArray);
        Iterator iterator=aggregate.iterator();
        while (iterator.havNext()){
            System.out.println(iterator.next());
        }
    }
}
