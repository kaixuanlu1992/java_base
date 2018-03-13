package desgin_pattern.observer;

public class User implements Observer {
    private String info;
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String info) {
        this.info=info;
        System.out.println(name+":"+info);
    }
}
