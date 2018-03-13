package desgin_pattern.template;

public class Tomato extends DodishTemplate {
    @Override
    protected void server() {
        System.out.println("番茄鸡蛋上菜啦！！！");
    }

    @Override
    protected void ding() {
        System.out.println("番茄炒鸡蛋");
    }

    @Override
    protected void preparation() {
        System.out.println("装备番茄、鸡蛋");

    }
}
