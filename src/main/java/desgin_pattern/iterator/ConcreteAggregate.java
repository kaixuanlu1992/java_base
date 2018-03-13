package desgin_pattern.iterator;

public class ConcreteAggregate implements Aggregate {
    private Object[] objarray=null;

    public ConcreteAggregate(Object[] objarray) {
        this.objarray = objarray;
    }

    public Object getElement(int index){

        if(index < objarray.length){
            return objarray[index];
        }else{
            return null;
        }
    }

    public int size(){
        return objarray.length;
    }
    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }
}
