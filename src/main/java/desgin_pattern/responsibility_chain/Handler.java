package desgin_pattern.responsibility_chain;

public abstract class Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler getNextHandler(){
        return nextHandler;
    }

    public abstract String handleFeeRequest(String user , double fee);
}
