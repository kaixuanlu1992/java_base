package desgin_pattern.command;

public class Stop implements Command {
    private AutoPlayer autoPlayer;

    public Stop(AutoPlayer autoPlayer) {
        this.autoPlayer = autoPlayer;
    }

    @Override
    public void execute() {
        autoPlayer.stop();
    }
}
