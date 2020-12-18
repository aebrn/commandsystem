import pw.highimhell.commands.Arguments;
import pw.highimhell.commands.Command;
import pw.highimhell.commands.Syntax;

/**
 * @author hell
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
