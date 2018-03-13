package desgin_pattern.strategy;

public class Context {
    private Double totalAmount = 0D;//客户在鹅厂消费的总额
    private Double amount = 0D;//客户单次消费金额
    private CalPrice calPrice;

    public void buy(Double amount) {
        this.amount = amount;
        totalAmount += amount;
        if (totalAmount > 30000) {//30000则改为金牌会员计算方式
            calPrice = new GoldVip();
        } else if (totalAmount > 20000) {//类似
            calPrice = new SuperVip();
        } else if (totalAmount > 10000) {//类似
            calPrice = new Vip();
        }else {
            calPrice=new Origin();
        }
    }

    public double calLastAmount() {
        return calPrice.calPrice(amount);
    }
}
