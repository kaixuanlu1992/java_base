package desgin_pattern.Visitor;

public abstract class Visitor {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //对每种类型的元素，进行操作，所以结构的改变访问者也需要修改
    public abstract void visitor(MedicineA a);
    public abstract void visitor(MedicineB b);
}
