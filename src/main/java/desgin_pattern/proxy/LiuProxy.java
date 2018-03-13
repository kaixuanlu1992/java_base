package desgin_pattern.proxy;

public class LiuProxy implements Person {
    private Person target;

    public LiuProxy(Person target) {
        this.target = target;
    }


    @Override
    public String sing(String name) {
        System.out.println("----开始唱歌！！-------");
        System.out.println("刘德华唱"+name+"歌！！");
        System.out.println("----结束唱歌！！-------");
        return "歌唱完了，谢谢大家！";
    }

    @Override
    public String dance(String name) {
        System.out.println("----开始跳舞！！-------");
        System.out.println("刘德华跳"+name+"舞！！");
        System.out.println("----结束跳舞！！-------");
        return "跳舞完了，谢谢大家！";
    }
}
