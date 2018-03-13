package desgin_pattern.simplefactory;



public class Client {
    public static void main(String[] args) {
        SimpleFactory factory=new SimpleFactory();
        Moveable car= factory.getInstance("car");
        Moveable bike= factory.getInstance("bike");
        car.move();
        bike.move();
    }
}
