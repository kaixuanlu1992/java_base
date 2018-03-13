package desgin_pattern.decorator;

public class CommonCoffee extends Coffee {

    @Override
    public String getName() {
        return "普通咖啡";
    }

    @Override
    public int getPrice() {
        return 20;
    }
}
