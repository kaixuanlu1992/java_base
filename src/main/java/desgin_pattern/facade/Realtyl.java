package desgin_pattern.facade;

public class Realtyl implements Stock {

    @Override
    public void buy() {
        System.out.println("房地产买入");
    }

    @Override
    public void sell() {
        System.out.println("房地产卖出");
    }
}
