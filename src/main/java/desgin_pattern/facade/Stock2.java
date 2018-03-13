package desgin_pattern.facade;

public class Stock2 implements Stock {
    @Override
    public void buy() {
        System.out.println("股票2买入");
    }

    @Override
    public void sell() {
        System.out.println("股票2卖出");

    }
}
