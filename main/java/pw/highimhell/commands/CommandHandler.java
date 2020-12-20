package pw.highimhell.commands;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hell
 * 12/12/2020
 */
public class CommandHandler {
    private final List<Command> commands = new CopyOnWriteArrayList<>();

    private String prefix;

    public CommandHandler(String prefix) {
        this.prefix = prefix;
    }

    private String handleCommands(String[] input) {
        Command command = getCommand(input[0].replaceFirst(prefix, ""));
        return command.getArguments() != null ?
                command.handleArguments(input) : command.execute();
    }

    public String execute(String command) {
        return handleCommands(command.split(" "));
    }

    public Command getCommand(String alias) {
        for (Command command : commands) {
            for (String commandAlias : command.getAliases()) {
                if (alias.equalsIgnoreCase(commandAlias)) {
                    return command;
                }
            }
        }
        return null;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    protected void register(Command command) {
        commands.add(command);
    }
}
