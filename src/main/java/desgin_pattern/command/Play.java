package desgin_pattern.command;

public class Play implements Command {
    private AutoPlayer autoPlayer;

    public Play(AutoPlayer autoPlayer) {
        this.autoPlayer = autoPlayer;
    }

    @Override
    public void execute() {
        autoPlayer.play();
    }
}
