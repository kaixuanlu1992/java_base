package desgin_pattern.observer;

public interface Subject {
    public void register(Observer observer);
    public void remove(Observer observer);
    public void notifyOberver();
}
