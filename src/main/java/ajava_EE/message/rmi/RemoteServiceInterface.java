package ajava_EE.message.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteServiceInterface extends Remote{
    List<UserInfos> queryAllUserInfo() throws RemoteException;
}
