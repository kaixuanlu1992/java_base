package desgin_pattern.factory;

import desgin_pattern.simplefactory.Moveable;

public class BusFactory implements Factory {
    @Override
    public Moveable CreateIntstance() {
        return new Bus();
    }
}
