package desgin_pattern.prototype;

public class ConcretePrototype implements ProtoType ,Cloneable{

    private String name;
    private int age;
    private String sex;
    private String timearea;
    private String company;


    @Override
    public ProtoType cloneOb() throws CloneNotSupportedException {
        return (ProtoType) super.clone();
    }

    @Override
    public void setWorkExperience(String timearea, String company) {
        this.timearea=timearea;
        this.company=company;

    }

    @Override
    public void setPersonInfo(String name, int age, String sex) {
        this.name=name;
        this.sex=sex;
        this.age=age;

    }

    @Override
    public void display() {
        System.out.println("name:"+name+" age"+age+" sex:"+sex
        +" timearea:"+timearea+" company:"+company);


    }
}
