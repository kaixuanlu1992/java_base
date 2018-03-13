package network.communication;

public class Message {
    private long mId;
    private String info;
    private long sIn;
    private long rId;

    public long getsIn() {
        return sIn;
    }

    public void setsIn(long sIn) {
        this.sIn = sIn;
    }

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public Message() {
    }

    public Message(long mId, String info) {
        this.mId = mId;
        this.info = info;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
