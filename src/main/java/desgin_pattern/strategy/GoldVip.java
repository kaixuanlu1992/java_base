package desgin_pattern.strategy;

public class GoldVip implements CalPrice {
    @Override
    public double calPrice(double orgnicPrice) {
        System.out.println("黄金VIP7折优惠");
        return orgnicPrice*0.7;
    }
}
