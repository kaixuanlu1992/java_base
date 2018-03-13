package desgin_pattern.states;

public interface VoteState {
    public void vote(String user, String voteItem, VoteManager voteManager);
}
