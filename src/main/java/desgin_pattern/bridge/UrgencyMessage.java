package desgin_pattern.bridge;

public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(MessageImplementor mImpl) {
        super(mImpl);
    }
    @Override
    public void sendMessage(String message, String toUser) {
        message = "加急：" + message;
        super.sendMessage(message, toUser);
    }

    public Object watch(String messageId) {
        // 根据消息id获取消息的状态，组织成监控的数据对象，然后返回
        return null;
    }
}
