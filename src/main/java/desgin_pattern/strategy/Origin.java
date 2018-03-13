package desgin_pattern.strategy;

public class Origin implements  CalPrice {
    @Override
    public double calPrice(double orgnicPrice) {
        return orgnicPrice;
    }
}
