import io.aebrn.commands.Command;

/**
 * @author aebrn
 * 12/12/2020
 */
public final class NoArgCommand extends Command {
    public NoArgCommand() {
        super("noarg", "narg");
    }

    @Override
    public String execute() {
        return "finished";
    }
}
