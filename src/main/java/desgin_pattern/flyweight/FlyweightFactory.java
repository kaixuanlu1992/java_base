package desgin_pattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyweightFactory {
    private Map<String,Flyweight> map= new ConcurrentHashMap< String,Flyweight >();
    public  Flyweight getTicket(String from,String to){
        String key = from+to;
        if(map.containsKey(key)){
            System.out.println("使用缓存查询"+key);
            return map.get(key);
        }else{
            System.out.println("创建对象查询"+key);
            Flyweight ticket = new ConcreteFlyweight(from,to);
            map.put(key, ticket);
            return ticket;
        }
    }
}
