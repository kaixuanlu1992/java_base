package desgin_pattern.bridge;
//消息种类
public abstract class AbstractMessage {
    private MessageImplementor mImpl;

    public AbstractMessage(MessageImplementor mImpl) {
        this.mImpl = mImpl;
    }
    public void sendMessage(String message , String toUser){
        this.mImpl.send(message, toUser);
    }
}
