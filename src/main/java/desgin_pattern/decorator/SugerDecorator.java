package desgin_pattern.decorator;

public class SugerDecorator extends Decorator {
    public SugerDecorator(Coffee mcoffee) {
        super(mcoffee);
    }

    @Override
    public String getName() {
        return this.mcoffee.getName()+"加糖";
    }

    @Override
    public int getPrice() {
        return this.mcoffee.getPrice()+8;
    }
}
