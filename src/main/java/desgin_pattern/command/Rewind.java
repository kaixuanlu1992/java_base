package desgin_pattern.command;

public class Rewind implements  Command {
    private AutoPlayer autoPlayer;

    public Rewind(AutoPlayer autoPlayer) {
        this.autoPlayer = autoPlayer;
    }

    @Override
    public void execute() {
        autoPlayer.rewind();
    }
}
