import io.aebrn.commands.CommandHandler;

/**
 * @author aebrn
 * 12/12/2020
 */
public final class TestCommandHandler extends CommandHandler {
    public TestCommandHandler() {
        super("-");

        register(new TwoArgCommand());
        register(new NoArgCommand());
        register(new ArgCommand());
    }
}
