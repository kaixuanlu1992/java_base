package desgin_pattern.states;
/*
状态模式：允许一个对象在其内部状态改变的时候改变其行为。这个对象看上去就像是改变了它的类一样。
使用场景：当控制一个对象状态转换的条件的表达式过于复杂的时候，可以把状态的判断逻辑转移到表示不同状态的一些列类中
三个角色：环境、抽象状态、具体状态
 */
public class Client {
    public static void main(String[] args) {

        VoteManager vm = new VoteManager();
        for(int i=0;i<9;i++){
            vm.vote("u1","A");
        }
    }
}
