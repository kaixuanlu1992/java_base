package desgin_pattern.Visitor;

public abstract class Medicine {
    private String name;
    private double price;

    public Medicine(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //保留访问者操作元素的权限，同时也破坏了元素的封装
    public abstract void accept(Visitor visitor);
}
