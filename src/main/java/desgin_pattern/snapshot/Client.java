package desgin_pattern.snapshot;
/*
备忘录模式：在不破坏封装的情况下，捕捉一个对象的内部状态，并在该对象之外保存，这样以后可以将该对象恢复到原来的对象
3个角色：
1、备忘录角色：负责存储发起人对象内部状态，并防止发起人对象之外的对象访问该对象
2、发起人角色：负责创建一个备忘录角色，并记录当前时刻它的状态，并可以是使用备忘录恢复内部状态
3、负责人角色：负责保存备忘录对象，不检查备忘录对象的内容
 */
public class Client {
    public static void main(String[] args) {
        Originator originator=new Originator(1,2,3);
        Caretaker stateAdmin=new Caretaker();

        stateAdmin.setMemento(originator.saveState());

        System.out.println("原始状态："+originator);
        originator.setVit(11);
        originator.setAtk(12);
        originator.setDef(13);
        System.out.println("修改后的状态："+originator);
        originator.recoveryState(stateAdmin.getMemento());
        System.out.println("恢复后的状态："+originator);


    }
}
