package desgin_pattern.factory;

import desgin_pattern.simplefactory.Bike;
import desgin_pattern.simplefactory.Moveable;

public class BikeFactory implements Factory {
    @Override
    public Moveable CreateIntstance() {
        return new Bike();
    }
}
