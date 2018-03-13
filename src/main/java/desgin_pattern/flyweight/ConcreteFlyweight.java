package desgin_pattern.flyweight;

public class ConcreteFlyweight implements Flyweight {
    private String from;
    private String to;
    public ConcreteFlyweight(String from,String to){
        this.from = from;
        this.to = to;
    }
    @Override
    public void showPrice(String type){
        if(type.equals("Gaotie")){
            System.out.println("从"+from+"到"+to+"的高铁票价为200元");
        }else{
            System.out.println("从"+from+"到"+to+"的动车票价为120元");
        }
    }
}
