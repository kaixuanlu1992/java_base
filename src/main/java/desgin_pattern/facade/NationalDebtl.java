package desgin_pattern.facade;

public class NationalDebtl implements Stock {
    @Override
    public void buy() {
        System.out.println("国债买入");
    }

    @Override
    public void sell() {
        System.out.println("国债卖出");

    }
}
