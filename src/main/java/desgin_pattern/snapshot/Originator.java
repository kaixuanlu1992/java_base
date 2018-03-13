package desgin_pattern.snapshot;

public class Originator {
    private int vit;
    private int atk;
    private int def;

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public Memento saveState(){
        return new Memento(vit,atk,def);
    }

    @Override
    public String toString() {
        return "Originator{" +
                "vit=" + vit +
                ", atk=" + atk +
                ", def=" + def +
                '}';
    }

    public void recoveryState(Memento memento){
        this.vit=memento.getVit();
        this.atk=memento.getAtk();
        this.def=memento.getDef();
    }

    public Originator(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    public Originator() {
    }
}
