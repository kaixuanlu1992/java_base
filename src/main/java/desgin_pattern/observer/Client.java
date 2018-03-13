package desgin_pattern.observer;

public class Client {
    public static void main(String[] args) {
        NewsPaper newsPaper=new NewsPaper();
        User user1=new User("kai");
        User user2=new User("xuan");
        User user3=new User("lu");

        newsPaper.register(user1);
        newsPaper.register(user2);
        newsPaper.register(user3);
        newsPaper.setMessage("a paper");
        newsPaper.notifyOberver();
        newsPaper.setMessage("new paper is ready");
        newsPaper.notifyOberver();
    }
}
