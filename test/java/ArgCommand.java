import io.aebrn.commands.Arguments;
import io.aebrn.commands.Command;
import io.aebrn.commands.Syntax;

/**
 * @author aebrn
 * 12/12/2020
 */
@Arguments({"maybe"})
@Syntax("[yes|no]")
public final class ArgCommand extends Command {
    public ArgCommand() {
        super("arg", "a");
    }

    @Override
    public String execute() {
        return switch (getArgument("maybe").getValue()) {
            case "yes" -> "yes";
            case "no" -> "no";
            default -> "stop";
        };
    }
}
