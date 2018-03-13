package desgin_pattern.template;

public class Bouilli extends DodishTemplate {
    @Override
    protected void server() {
        System.out.println("红烧肉上菜啦！！！");
    }

    @Override
    protected void ding() {
        System.out.println("做红烧肉");
    }

    @Override
    protected void preparation() {
        System.out.println("准备猪肉、油");
    }
}
