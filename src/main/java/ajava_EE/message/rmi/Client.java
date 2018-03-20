package ajava_EE.message.rmi;

import org.apache.log4j.BasicConfigurator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Client {
    static {
        BasicConfigurator.configure();
    }
    public static void main(String[] args) {
        RemoteServiceInterface remoteServiceInterface = null;
        try {
            remoteServiceInterface = (RemoteServiceInterface) Naming.lookup("rmi://120.79.91.4:8085/queryAllUserInfo");
            List<UserInfos> users = remoteServiceInterface.queryAllUserInfo();
            System.out.println(users);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
