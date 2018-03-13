package desgin_pattern.facade;

public class Facade {
    private Stock stock1;
    private Stock stock2;
    private Stock nationalDebtl;
    private Stock realtyl;

    public Facade() {
        stock1 = new Stock1();
        stock2 = new Stock2();
        nationalDebtl = new NationalDebtl();
        realtyl = new Realtyl();
    }
    public void buy(){
        stock1.buy();
        stock2.buy();
        nationalDebtl.buy();
        realtyl.buy();
    }
    public void sell(){
        stock1.sell();
        stock2.sell();
        nationalDebtl.sell();
        realtyl.sell();
    }
}
