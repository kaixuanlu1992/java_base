package desgin_pattern.factory;

import desgin_pattern.simplefactory.Moveable;

public class Bus implements Moveable {
    @Override
    public void move() {
        System.out.println("i am a bus");
    }
}
