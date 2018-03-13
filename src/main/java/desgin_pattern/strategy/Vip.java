package desgin_pattern.strategy;

public class Vip implements CalPrice {
    @Override
    public double calPrice(double orgnicPrice) {
        System.out.println("vip 9折优惠");
        return orgnicPrice*0.9;
    }
}
