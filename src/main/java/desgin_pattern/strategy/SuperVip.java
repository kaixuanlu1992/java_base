package desgin_pattern.strategy;

public class SuperVip implements CalPrice {
    @Override
    public double calPrice(double orgnicPrice) {
        System.out.println("超级VIP8折优惠");
        return orgnicPrice*0.8;
    }
}
