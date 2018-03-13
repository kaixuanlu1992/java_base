package desgin_pattern.prototype;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePrototype con1=new ConcretePrototype();
        con1.setPersonInfo("java_SE",26,"男");
        ConcretePrototype con2= (ConcretePrototype) con1.cloneOb();
        con2.setWorkExperience("2010-2011","中心");
        ConcretePrototype con3= (ConcretePrototype) con1.cloneOb();
        con3.setWorkExperience("2010-2013","中心1");
        con1.display();
        con2.display();
        con3.display();
    }
}
