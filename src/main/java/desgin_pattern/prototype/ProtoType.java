package desgin_pattern.prototype;
/*
原型模式：用原型实例指定创建对象的种类，并通过拷贝这些原型来创建新的对象
涉及深浅复制问题
*/
public interface ProtoType {
    public ProtoType cloneOb() throws CloneNotSupportedException;
    public void setWorkExperience(String timearea, String company);
    public void setPersonInfo(String name, int age, String sex);
    public void display();
}
