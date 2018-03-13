package desgin_pattern.facade;

public class Stock1 implements Stock {
    @Override
    public void buy() {
        System.out.println("股票1买入");
    }

    @Override
    public void sell() {
        System.out.println("股票1卖出");

    }
}
