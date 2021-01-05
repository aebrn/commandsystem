import io.aebrn.commands.Arguments;
import io.aebrn.commands.Command;
import io.aebrn.commands.Syntax;

/**
 * @author aebrn
 * 12/12/2020
 */
@Arguments({"first", "second"})
@Syntax("[yes|no] [no|yes]")
public final class TwoArgCommand extends Command {
    public TwoArgCommand() {
        super("twoarg");
    }

    @Override
    public String execute() {
        String second = getArgument("second").getValue();
        return switch (getArgument("first").getValue()) {
            case "yes" -> second;
            case "no" -> second.toUpperCase();
            default -> "stop";
        };
    }
}
