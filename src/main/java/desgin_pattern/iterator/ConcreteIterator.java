package desgin_pattern.iterator;

public class ConcreteIterator implements Iterator {
    private ConcreteAggregate agg;
    private int index = 0;
    private int size = 0;

    public ConcreteIterator(ConcreteAggregate concreteAggregate) {
        this.agg=concreteAggregate;
        this.size=concreteAggregate.size();
    }

    @Override
    public boolean havNext() {
        return index<=(size-1);
    }

    @Override
    public Object next() {
        return agg.getElement(index++);
    }
}
