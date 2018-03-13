package desgin_pattern.simplefactory;

public class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("I AM A CAR");
    }
}
