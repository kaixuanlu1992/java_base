package desgin_pattern.bridge;
//消息的发送方式
public interface MessageImplementor {
    public abstract void send(String message, String toUser);
}
