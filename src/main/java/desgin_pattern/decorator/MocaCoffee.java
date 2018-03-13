package desgin_pattern.decorator;

public class MocaCoffee extends Coffee {
    @Override
    public String getName() {
        return "摩卡咖啡";
    }

    @Override
    public int getPrice() {
        return 30;
    }
}
