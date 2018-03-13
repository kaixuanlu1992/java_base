package desgin_pattern.observer;


import java.util.ArrayList;
import java.util.Iterator;

public class NewsPaper implements Subject{
    private ArrayList users;

    public NewsPaper() {
        users = new ArrayList();//初始化
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    @Override
    public void register(Observer observer) {
        users.add(observer);

    }

    @Override
    public void remove(Observer observer) {
        Iterator it=users.iterator();
        while (it.hasNext()){
            if (it.next().equals(observer)){
                it.remove();
            }
        }

    }

    @Override
    public void notifyOberver() {
        for (int i=0;i<users.size();i++){
            User user= (User) users.get(i);
            user.update(message);
        }

    }
}
