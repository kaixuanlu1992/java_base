package desgin_pattern.factory;

import desgin_pattern.simplefactory.Car;
import desgin_pattern.simplefactory.Moveable;

public class CarFactory implements Factory {
    @Override
    public Moveable CreateIntstance() {
        return new Car();
    }
}
