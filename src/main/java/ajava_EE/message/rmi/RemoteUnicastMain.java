package ajava_EE.message.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.activation.ActivationException;
import java.rmi.registry.LocateRegistry;

public class RemoteUnicastMain {
    public static void main(String[] args) {
        try {
            /*
             * Locate registry：RMI服务注册表，或者是RMI服务位置仓库。
             * 主要的作用是维护一个“可以正常提供RMI具体服务的所在位置”。
             * 每一个具体的RMI服务提供者，都会将自己的Stub注册到Locate registry中，以表示自己“可以提供服务”
             *
             * 有两种方式可以管理Locate registry，一种是通过操作系统的命令行启动注册表；
             * 另一种是在代码中使用LocateRegistry类。
             *
             * LocateRegistry类中有一个createRegistry方法，可以在这台物理机上创建一个“本地RMI注册表”
             * */
            LocateRegistry.createRegistry(1099);
            // 向LocateRegistry注册（绑定/重绑定）RMI Server实现。
            RemoteUnicastServiceImpl remoteService = new RemoteUnicastServiceImpl();
            // 通过java 名字服务技术，可以将具体的RMI Server实现绑定一个访问路径。注册到LocateRegistry中
            Naming.rebind("rmi://127.0.0.1:1099/queryAllUserInfo", remoteService);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ActivationException e) {
            e.printStackTrace();
        }
    }
}
