package ajava_EE.message.rmi;

import java.rmi.RemoteException;
import java.rmi.activation.ActivationException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteUnicastServiceImpl extends UnicastRemoteObject implements RemoteServiceInterface {
    private static final long serialVersionUID = 6797720945876437472L;

    public RemoteUnicastServiceImpl() throws RemoteException, ActivationException {
       super();
    }


    @Override
    public List<UserInfos> queryAllUserInfo() throws RemoteException {
        List<UserInfos> users = new ArrayList<UserInfos>();

        UserInfos user1 = new UserInfos();
        user1.setUserAge(21);
        user1.setUserDesc("userDesc1");
        user1.setUserName("userName1");
        user1.setUserSex(true);
        users.add(user1);

        UserInfos user2 = new UserInfos();
        user2.setUserAge(21);
        user2.setUserDesc("userDesc2");
        user2.setUserName("userName2");
        user2.setUserSex(false);
        users.add(user2);

        return users;
    }
}
