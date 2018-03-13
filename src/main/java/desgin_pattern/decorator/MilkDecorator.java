package desgin_pattern.decorator;

public class MilkDecorator extends Decorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getName() {
        return this.mcoffee.getName()+"addMilk";
    }

    @Override
    public int getPrice() {
        return this.mcoffee.getPrice()+10;
    }
}
