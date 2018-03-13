package desgin_pattern.command;

/*
命令模式：把一个请求或者操作封装到一个对象中。命令模式允许系统使用不同的请求把客户端参数化，
         对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。
作用：命令的请求与命令的执行解耦
角色：
1、请求者：负责调用命令对象执行请求
2、接收者：负责具体实施和执行一个请求
3、抽象命令：声明了一个给所有具体命令类的抽象接口
4、具体命令:负责调用接收者的相应操作
5、客户端
 */
public class Client {
    public static void main(String[] args) {
        AutoPlayer audioPlayer= new AutoPlayer();
        //创建命令对象
        Command play = new Play(audioPlayer);
        Command rewind = new Rewind(audioPlayer);
        Command stop = new Stop(audioPlayer);
        //创建请求者对象
        Keypad keypad = new Keypad();
        keypad.setPlayCommand(play);
        keypad.setRewindCommand(rewind);
        keypad.setStopCommand(stop);

        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();
    }
}
