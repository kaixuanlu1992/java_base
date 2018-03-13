package desgin_pattern.factory;

import desgin_pattern.simplefactory.Moveable;

public class Client {
    public static void main(String[] args) {
        Factory carFactory=new CarFactory();
        Factory bikeFactory=new BikeFactory();
        Moveable car=carFactory.CreateIntstance();
        Moveable bike=bikeFactory.CreateIntstance();
        car.move();
        bike.move();
        Factory busFactory=new BusFactory();
        Moveable bus=busFactory.CreateIntstance();
        bus.move();
    }


}
