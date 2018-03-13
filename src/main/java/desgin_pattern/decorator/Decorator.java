package desgin_pattern.decorator;

public abstract class Decorator extends Coffee{
    protected Coffee mcoffee;

    public Decorator(Coffee mcoffee) {
        this.mcoffee = mcoffee;
    }
}
